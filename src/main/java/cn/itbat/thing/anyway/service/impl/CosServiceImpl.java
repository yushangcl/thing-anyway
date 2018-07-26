package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.common.utils.RandomUtil;
import cn.itbat.thing.anyway.service.CosService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author huahui.wu
 * @date 2018/7/26 16:01
 * @description
 */
@Service
public class CosServiceImpl implements CosService {

    private static final Logger _log = LoggerFactory.getLogger(CosServiceImpl.class);

    private static COSClient cosClient = null;
    private static String bucket = null;

    @Value("${cos.app-id}")
    private Long appId;

    @Value("${cos.access-key}")
    private String accessKey;

    @Value("${cos.secret-key}")
    private String secretKey;

    @Value("${cos.region}")
    private String region;

    @Value("${cos.bucket-name}")
    private String bucketName;

    private void init() {
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        // 3 生成cos客户端
        cosClient = new COSClient(cred, clientConfig);
        bucket = bucketName + "-" + appId;
    }

    /*******************************************文件操作************************************************/

    @Override
    public String uploadFile(String filePath) {
        if (cosClient == null) {
            init();
        }
        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        File localFile = new File(filePath);
        // 指定要上传到 COS 上对象键
        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String format = filePath.substring(filePath.lastIndexOf("."),filePath.length());
        String key = RandomUtil.generateLowerStr(50) + format;

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        return putObjectRequest.getKey();
    }

    @Override
    public String uploadFile(String filePath, String fileName) {
        if (cosClient == null) {
            init();
        }
        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        File localFile = new File(filePath);
        // 指定要上传到 COS 上对象键
        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, fileName, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        return putObjectRequest.getKey();
    }
}
