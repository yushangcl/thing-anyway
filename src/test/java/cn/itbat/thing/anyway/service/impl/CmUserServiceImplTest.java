package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.BaseTest;
import cn.itbat.thing.anyway.common.utils.AbsResponse;
import cn.itbat.thing.anyway.service.CmUserService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author huahui.wu
 * @date 2018/7/12 11:14
 * @description
 */
public class CmUserServiceImplTest extends BaseTest {

    @Resource
    private CmUserService cmUserService;

    @Test
    public void register() {
            AbsResponse absResponse = cmUserService.register("test_123", "Whh123456489", "test@email.com");
        Assert.assertNotNull(absResponse);
        System.out.println(absResponse);
    }
}