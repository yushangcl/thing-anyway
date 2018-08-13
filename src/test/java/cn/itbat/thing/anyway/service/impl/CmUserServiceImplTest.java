package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.BaseTest;
import cn.itbat.thing.anyway.common.base.AbsResponse;
import cn.itbat.thing.anyway.service.CmUserService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author huahui.wu
 * @date 2018/7/12 11:14
 * @description
 */
public class CmUserServiceImplTest extends BaseTest {

    @Resource
    private CmUserService cmUserService;

    @Test
    public void register() throws Exception{
        AbsResponse absResponse = cmUserService.register("test_2123457", "Whh123456489", "test@m.likie.win");
        Assert.assertNotNull(absResponse);
        System.out.println(absResponse);
    }

    @Test
    public void findByName() {
        cmUserService.findByName("");
    }
}