package cn.itbat.thing.anyway.service;


import cn.itbat.thing.anyway.common.utils.DOCN;
import cn.itbat.thing.anyway.common.utils.UKID;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


/**
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/4/19.
 */
public class UKIDInitialize implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        UKID.init();

        DOCN.init();
    }
}
