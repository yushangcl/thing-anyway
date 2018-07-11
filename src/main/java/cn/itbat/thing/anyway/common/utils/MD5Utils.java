package cn.itbat.thing.anyway.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 密码加密
 *
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-11 下午2:38
 **/
public class MD5Utils {

    private static final String ALGORITH_NAME = "md5";

    private static final int HASH_ITERATIONS = 2;

    public static String encrypt(String password, String salt) {
        return new SimpleHash(ALGORITH_NAME, password, ByteSource.Util.bytes(salt), HASH_ITERATIONS).toHex();
    }

    public static String encrypt(String username, String pswd, String salt) {
        return new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username.toLowerCase() + salt),
                HASH_ITERATIONS).toHex();
    }

    public static void main(String[] args) {

        System.out.println(MD5Utils.encrypt("测试","123456", "test"));
    }
}
