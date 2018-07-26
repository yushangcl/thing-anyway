//package cn.itbat.thing.anyway.common.utils.cos;
//
//import com.qcloud.cos.COSClient;
//import com.qcloud.cos.ClientConfig;
//import com.qcloud.cos.auth.BasicCOSCredentials;
//import com.qcloud.cos.auth.COSCredentials;
//import com.qcloud.cos.model.PutObjectRequest;
//import com.qcloud.cos.model.PutObjectResult;
//import com.qcloud.cos.region.Region;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//
//import java.io.File;
//
///**
// * 腾讯云COS上传工具类
// *
// * @author huahui.wu
// * @date 2018/7/26 15:09
// */
//public class CosUtils {
//    private static final Logger _log = LoggerFactory.getLogger(CosUtils.class);
//
//    private static COSClient cosClient = null;
//    private static String bucket = null;
//
//    // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
//
//    @Value("${cos.app-id}")
//    private Long appId;
//
//    @Value("${cos.access-key}")
//    private String accessKey;
//
//    @Value("${cos.secret-key}")
//    private String secretKey;
//
//    @Value("${cos.region}")
//    private String region;
//
//    @Value("${cos.bucket-name}")
//    private String bucketName;
//
//    public CosUtils() {
//        if (cosClient == null) {
//            synchronized (COSClient.class) {
//                if (cosClient == null) {
//                    new CosUtils(appId, accessKey, secretKey, region, bucketName);
//                }
//            }
//        }
//    }
//
//    /**
//     * 初始化 CosClient
//     *
//     * @param appId     bucket id
//     * @param accessKey bucket secretId
//     * @param secretKey bucket secretKey
//     * @param region    bucket 所在区域 比如广州(gz), 天津(tj), 上海(sh)
//     */
//    private CosUtils(Long appId, String accessKey, String secretKey, String region, String bucketName) {
//
//    }
//
//    /*******************************************文件操作************************************************/
//
//    public String uploadFile() {
//        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
//        // 大文件上传请参照 API 文档高级 API 上传
//        File localFile = new File("E:\\Download\\20180626145232.png");
//        // 指定要上传到 COS 上对象键
//        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
//        String key = "upload_single_demo.txt";
//        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, localFile);
//        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
//        System.out.println(putObjectRequest);
//        return null;
//    }
//}