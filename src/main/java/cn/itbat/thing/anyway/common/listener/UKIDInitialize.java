package cn.itbat.thing.anyway.common.listener;


import cn.itbat.thing.anyway.common.utils.DOCN;
import cn.itbat.thing.anyway.common.utils.UKID;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/4/19.
 */
@Lazy
@Component
public class UKIDInitialize implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        UKID.init();

        DOCN.init();

    }
}
