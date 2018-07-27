package cn.itbat.thing.anyway.common.utils;

import java.util.Random;

/**
 * @author huahui.wu
 * @date 2018/7/12 10:55
 * @description
 */
public class RandomUtil {
    private static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String numberChar = "0123456789";

    /**
     * 产生len长度的随机字符串
     *
     * @param len
     * @return
     */
    public static String generateStr(int len) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机纯字母字符串(只包含大小写字母)
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateMixStr(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(letterChar.charAt(random.nextInt(letterChar.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机纯大写字母字符串(只包含大小写字母)
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateLowerStr(int length) {
        return generateMixStr(length).toLowerCase();
    }

    /**
     * 返回一个定长的随机纯小写字母字符串(只包含大小写字母)
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateUpperStr(int length) {
        return generateMixStr(length).toUpperCase();
    }

    /**
     * 返回一个定长的税基纯大写字符串，但是每隔五位使用"-"隔开
     *
     * @param length 长度（不包含"-"）
     * @return
     */
    public static String getNumberUpperStrLine(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            if (i != 0 && i % 5 == 0) {
                sb.append("-");
            }
            sb.append(allChar.charAt(random.nextInt(allChar.length())));

        }
        return sb.toString();

    }


    public static void main(String[] args) {
        System.out.println(getNumberUpperStrLine(100));
    }

}
