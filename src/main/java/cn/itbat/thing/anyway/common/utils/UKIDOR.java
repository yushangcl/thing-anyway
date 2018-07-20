package cn.itbat.thing.anyway.common.utils;

import cn.itbat.thing.anyway.common.config.SpringContextUtil;
import cn.itbat.thing.anyway.service.SyNextNumberService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * UKID生成
 *
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/4/19.
 */
public class UKIDOR {
    private static final Log logger = LogFactory.getLog(UKIDOR.class);

    private static Lock lock = new ReentrantLock();
    private int counter;
    //app的密钥
    private String appSecret;
    //第一位的控制位
    private String addr;
    //流水号的第一段
    private String jvmid;
    //距20120101的天数
    private String day;
    private int jvm_length;
    private int once_count = 999;
    //UKID分组号，目前10组，下标为0
    private int item = 0;

    private SyNextNumberService syNextNumberService;

    protected UKIDOR(int item) {
        this.item = item;
        this.init();
    }

    /**
     * 601115002610080121224303
     */
    private void init() {
        initAppSecret();
        try {
            this.addr = appSecret.substring(5, 6);
            this.jvm_length = Integer.parseInt(appSecret.substring(13, 14));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

//        calcJvmId();
    }

    private void initAppSecret() {
        if (syNextNumberService == null) {
            syNextNumberService = (SyNextNumberService) SpringContextUtil.getBean("syNextNumberService");
        }

        this.appSecret = syNextNumberService.getAppSecret();
        checkNull(appSecret);
    }

    private void calcJvmId() {
        String lastestNo = syNextNumberService.getNextNumber("XU" + item);
        calcJvmId(lastestNo);
    }

    /**
     * @param no ag:XU6117061300000001
     * @return
     */
    private void calcJvmId(String no) {
        day = calaDayString(no);
        jvmid = calaJvmid(no);
    }

    /**
     * @param no ag:XU6117061300000001
     * @return 0796
     */
    private String calaDayString(String no) {
        String date = no.substring(4, 10);
        date = String.valueOf(DateUtil.getDay(date));
        String dayStr = StringUtils.lpad(date, 4, "0");
        return dayStr;
    }

    /**
     * @param no ag:XU6117061300000001
     * @return 00000001
     */
    private String calaJvmid(String no) {
        String no1 = no.substring(no.length() - jvm_length);
        no1 = String.valueOf(Integer.parseInt(no1));
        return StringUtils.lpad(no1, jvm_length, "0");
    }

    protected int getCount() {
        lock.lock();
        try {
            // 如果超过once_count，则counter重新取0
            if (counter > once_count) {
                counter = 0;
                calcJvmId();
            }
            if (StringUtils.isEmpty(jvmid)) {
                calcJvmId();
            }
            return counter++;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 目前长度是17
     * 控制位（1位） + 距20120101的日期天数（4位） + 分组号（1位） + 流水号第1段(8位) + 流水号第2段(3位)
     *
     * @return
     */
    public final Long getUKID() {
        checkJvmLength();
        int count = getCount();
        int onceLength = String.valueOf(once_count).length();
        String padedCount = StringUtils.lpad(String.valueOf(count), onceLength, "0");

        StringBuilder ukid = new StringBuilder(addr);
        ukid.append(day).append(item).append(jvmid).append(padedCount);

        return Long.valueOf(ukid.toString());
    }

    private void checkNull(String arg) {
        if (StringUtils.isEmpty(arg)) {
            throw new RuntimeException("Not config SY_CONSTANT app_secret.");
        }
    }

    private void checkJvmLength() {
        if (jvmid == null) {
            return;
        }
        if (jvmid.length() > jvm_length) {
            throw new RuntimeException("计算UKID出错，超过最大值: " + jvmid + "   " + jvm_length);
        }
    }
}
