package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.common.utils.DateUtil;
import cn.itbat.thing.anyway.common.utils.UUIDUtil;
import cn.itbat.thing.anyway.service.CosService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.UploadResult;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.Transfer;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.TransferProgress;
import com.qcloud.cos.transfer.Upload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;

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
    private static String path = null;

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
        path = "/" + DateUtil.toDateString(new Date()) + "/";
    }

    // Prints progress while waiting for the transfer to finish.
    private static void showTransferProgress(Transfer transfer) {
        System.out.println(transfer.getDescription());
        do {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
            TransferProgress progress = transfer.getProgress();
            long so_far = progress.getBytesTransferred();
            long total = progress.getTotalBytesToTransfer();
            double pct = progress.getPercentTransferred();
            System.out.printf("[%d / %d]\n", so_far, total);
        } while (!transfer.isDone());
        System.out.println(transfer.getState());
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
        String format = filePath.substring(filePath.lastIndexOf("."), filePath.length());
        String key = path + UUIDUtil.get32UUID() + format;

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


    // 上传文件, 根据文件大小自动选择简单上传或者分块上传。
    @Override
    public String uploadFileManager(String filePath) {
        if (cosClient == null) {
            init();
        }
        // 传入一个threadpool, 若不传入线程池, 默认TransferManager中会生成一个单线程的线程池。
        TransferManager transferManager = new TransferManager(cosClient);
        String format = filePath.substring(filePath.lastIndexOf("."), filePath.length());
        String key = path + UUIDUtil.get32UUID() + format;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, new File(filePath));
        try {
            // 返回一个异步结果Upload, 可同步的调用waitForUploadResult等待upload结束, 成功返回UploadResult, 失败抛出异常.
            long startTime = System.currentTimeMillis();
            Upload upload = transferManager.upload(putObjectRequest);
            showTransferProgress(upload);
            UploadResult uploadResult = upload.waitForUploadResult();
            long endTime = System.currentTimeMillis();
            _log.debug("【used time】：" + (endTime - startTime) / 1000);
            _log.debug("【ETag】：" + uploadResult.getETag());
        } catch (CosClientException | InterruptedException e) {
            e.printStackTrace();
        }

        transferManager.shutdownNow();
        cosClient.shutdown();
        return key;
    }
}
