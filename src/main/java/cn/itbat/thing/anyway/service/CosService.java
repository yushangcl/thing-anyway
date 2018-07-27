package cn.itbat.thing.anyway.service;

/**
 * @author huahui.wu
 * @date 2018/7/26 16:01
 * @description
 */
public interface CosService {

    String uploadFile(String filePath);

    String uploadFile(String filePath, String fileName);

    // 上传文件, 根据文件大小自动选择简单上传或者分块上传。
    String uploadFileManager(String filePath);
}
