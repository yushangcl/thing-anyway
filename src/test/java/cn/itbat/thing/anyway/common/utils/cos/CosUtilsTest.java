package cn.itbat.thing.anyway.common.utils.cos;

import cn.itbat.thing.anyway.BaseTest;
import cn.itbat.thing.anyway.service.CosService;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author huahui.wu
 * @date 2018/7/26 15:49
 * @description
 */
public class CosUtilsTest extends BaseTest {

    @Resource
    private CosService cosService;

    @Test
    public void uploadFile() {
        cosService.uploadFile("E:\\Download\\20180626145232.png");
    }
}