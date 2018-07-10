package cn.itbat.thing.anyway.utils;

import cn.itbat.thing.anyway.BaseTest;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-10 下午4:34
 **/
public class UKIDTest extends BaseTest {

    @Test
    public void test() throws Exception {
        Set<Long> longs = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            Long ukid = UKID.getUKID();
            longs.add(ukid);
            System.out.println(ukid);
        }
        System.out.println(longs.size());
    }

    @Test
    public void getBuID() throws Exception {
        Long buId = DOCN.getBuId();
        System.out.println(buId);
    }


    @Test
    public void getUserID() throws Exception {
        Long buId = DOCN.getEmpId();
        System.out.println(buId);
    }

}
