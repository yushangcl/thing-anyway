package cn.itbat.thing.anyway.utils;


import cn.itbat.thing.anyway.service.SyNextNumberService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 单号生成工具类
 *
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/4/19.
 */
public class DOCN {
    private static Logger log = LogManager.getLogger(DOCN.class);
    private static SyNextNumberService syNextNumberService;

    static {

    }

    public static void init() {
        if (DOCN.syNextNumberService == null) {
            DOCN.syNextNumberService = (SyNextNumberService) SpringContextUtil.getBean("syNextNumberService");
        }
    }

    //---------------------   业务对象编号  -----------------------------------------

    /**
     * 业务单位
     */
    public static Long getBuId() {
        return getLongNextNumber("BU");
    }


    /**
     * 系统员工编号
     *
     * @return
     */
    public static Long getEmpId() {
        return getLongNextNumber("BE");
    }

    /**
     * 获取序列
     *
     * @return
     */
    public static Long getSeq() {
        return getNextSeq();
    }

    /**
     * 获取格式化好的序列:每3位一段，用空格分隔开的字符串
     * eg: input:1234567890 return:123 456 789 0
     *
     * @return
     */
    public static String getFSeq() {
        return String.valueOf(getNextSeq());
    }

    //---------------------------  其它 X  ---------------------------


    private static String getNextNumber(String type) {
        if (syNextNumberService == null) {
            syNextNumberService = (SyNextNumberService) SpringContextUtil.getBean("syNextNumberService");
        }
        return syNextNumberService.getNextNumber(type);
    }

    private static Long getNextSeq() {
        if (syNextNumberService == null) {
            syNextNumberService = (SyNextNumberService) SpringContextUtil.getBean("syNextNumberService");
        }
        return syNextNumberService.getNextSeq();
    }

    private static Long getLongNextNumber(String type) {
        return Long.parseLong(getNextNumber(type));
    }
}
