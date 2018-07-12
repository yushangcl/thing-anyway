package cn.itbat.thing.anyway.common.utils;


import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式校验工具集
 *
 * @author huahui.wu
 * Created on 2018/4/13.
 */
public class RegexUtils {
    /**
     * 车牌号：支持新能源车牌号
     */
    private static String REGEX_CAR_NUMBER = "^([冀豫云辽黑湘皖鲁苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼渝京津沪新京军空海北沈兰济南广成使领][a-zA-Z](([DF](?![a-zA-Z0-9]*[IO])[0-9]{5})|([0-9]{5}[DF])))|([冀豫云辽黑湘皖鲁苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼渝京津沪新京军空海北沈兰济南广成使领A-Z]{1}[a-zA-Z0-9]{5}[a-zA-Z0-9挂学警港澳]{1})$";
    /**
     * mac地址
     */
    private static String REGEX_MAC_ADDRESS = "([A-Fa-f0-9]{2}:){5}[A-Fa-f0-9]{2}";
    /**
     * 邮箱
     */
    private static String REGEX_EMAIL = "^[A-Za-z0-9\\u4e00-\\u9fa5\\._-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+){1,3}$";
    /**
     * 身份证号
     */
    private static String REGEX_ID_CARD = "[1-9]\\d{16}[a-zA-Z0-9]{1}";
    /**
     * 手机号
     */
    private static String REGEX_MOBILE = "(\\+\\d+)?1[345789]\\d{9}$";
    /**
     * 电话号码
     */
    private static String REGEX_PHONE = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
    /**
     * 整型数字
     */
    private static String REGEX_NUMBER = "\\-?[1-9]\\d+";
    /**
     * ip
     */
    public static final String REGEX_IP = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
    /**
     * 邮政编码
     */
    public static final String REGEX_POSTCODE = "[1-9]\\d{5}";
    public static final String REGEX_DECIMAL = "\\-?[1-9]\\d+(\\.\\d+)?";
    public static final String REGEX_BLANK = "\\s+";
    public static final String REGEX_CHINESE = "^[\u4E00-\u9FA5]+$";
    public static final String REGEX_DAY = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";
    public static final String REGEX_URL = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
    public static final String REGEX_DOMAIN = "(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)";

    /**
     * 包含大小写，数字和字符其中之二，8-16位
     */
    private static String REGEX_PASSWORD = "^(?![A-Za-z]+$)(?!\\d+$)(?![\\W_]+$)\\S{7,15}$";

    /**
     * 字母开头，数字和下划线 5-16位
     */
    private static String REGEX_USERNAME = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";


    /**
     * 验证Email
     *
     * @param email email地址，格式：zhangsan@sina.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 验证身份证号码
     *
     * @param idCard 居民身份证号码18位，第一位不能为0，最后一位可能是数字或字母，中间16位为数字 \d同[0-9]
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkIdCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
     *
     * @param mobile 移动、联通、电信运营商的号码段
     *               <p>移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
     *               、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p>
     *               <p>联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p>
     *               <p>电信的号段：133、153、180（未启用）、189</p>
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 验证固定电话号码
     *
     * @param phone 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
     *              <p><b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字，
     *              数字之后是空格分隔的国家（地区）代码。</p>
     *              <p><b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
     *              对不使用地区或城市代码的国家（地区），则省略该组件。</p>
     *              <p><b>电话号码：</b>这包含从 0 到 9 的一个或多个数字 </p>
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkPhone(String phone) {
        return Pattern.matches(REGEX_PHONE, phone);
    }

    /**
     * 验证整数（正整数和负整数）
     *
     * @param digit 一位或多位0-9之间的整数
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkDigit(String digit) {
        return Pattern.matches(REGEX_NUMBER, digit);
    }

    /**
     * 验证整数和浮点数（正负整数和正负浮点数）
     *
     * @param decimals 一位或多位0-9之间的浮点数，如：1.23，233.30
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkDecimals(String decimals) {
        return Pattern.matches(REGEX_DECIMAL, decimals);
    }

    /**
     * 验证空白字符
     *
     * @param blankSpace 空白字符，包括：空格、\t、\n、\r、\f、\x0B
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkBlankSpace(String blankSpace) {
        return Pattern.matches(REGEX_BLANK, blankSpace);
    }

    /**
     * 验证中文
     *
     * @param chinese 中文字符
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 验证日期（年月日）
     *
     * @param birthday 日期，格式：1992-09-03，或1992.09.03
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkBirthday(String birthday) {
        return Pattern.matches(REGEX_DAY, birthday);
    }

    /**
     * 验证URL地址
     *
     * @param url 格式：http://blog.csdn.net:80/xyang81/article/details/7705960? 或 http://www.csdn.net:80
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkURL(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * <pre>
     * 获取网址 URL 的一级域名
     * http://detail.tmall.com/item.htm?spm=a230r.1.10.44.1xpDSH&id=15453106243&_u=f4ve1uq1092 ->> tmall.com
     * </pre>
     * 获取完整的域名
     * "[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)"
     *
     * @param url
     * @return
     */
    public static String getDomain(String url) {
        Pattern p = Pattern.compile(REGEX_DOMAIN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        matcher.find();
        return matcher.group();
    }

    /**
     * 匹配中国邮政编码
     *
     * @param postcode 邮政编码
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkPostcode(String postcode) {
        return Pattern.matches(REGEX_POSTCODE, postcode);
    }

    /**
     * 匹配IP地址(简单匹配，格式，如：192.168.1.1，127.0.0.1，没有匹配IP段的大小)
     *
     * @param ipAddress IPv4标准地址
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkIpAddress(String ipAddress) {
        return Pattern.matches(REGEX_IP, ipAddress);
    }

    /**
     * 匹配MAC地址 因需求只允许 XX:XX:XX:XX:XX:XX 格式mac地址
     *
     * @param macAddress mac地址
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkMacAddress(String macAddress) {
        return Pattern.matches(REGEX_MAC_ADDRESS, macAddress);
    }

    /**
     * 判断车牌号是否正确
     *
     * @param data
     * @return
     */
    public static boolean isCarNumber(String data) {
        return Pattern.matches(REGEX_CAR_NUMBER, data);
    }

    /**
     * 包括大小写字母、数字、标点符号的其中两项,共计8-16位编码组成
     *
     * @param password
     * @return
     */
    public static boolean checkPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
     *
     * @param userName
     * @return
     */
    public static boolean checkUserName(String userName) {
        return Pattern.matches(REGEX_USERNAME, userName);
    }
}