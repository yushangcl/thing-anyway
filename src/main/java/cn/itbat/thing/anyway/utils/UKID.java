package cn.itbat.thing.anyway.utils;


import java.util.concurrent.ThreadLocalRandom;

public class UKID implements java.io.Serializable {
    private static UKIDOR[] ukidors = new UKIDOR[10];

    public static synchronized void init() {
        //已经初始化，则不用再执行
        if (ukidors[0] != null) {
            return;
        }
        for (int i = 0; i < ukidors.length; i++) {
            ukidors[i] = new UKIDOR(i);
        }
    }

    public final static Long getUKID() {
        int item = ThreadLocalRandom.current().nextInt(ukidors.length);
        if (ukidors[item] == null) {
            synchronized (UKIDOR.class) {
                ukidors[item] = new UKIDOR(item);
            }
        }
        return ukidors[item].getUKID();
    }
}
