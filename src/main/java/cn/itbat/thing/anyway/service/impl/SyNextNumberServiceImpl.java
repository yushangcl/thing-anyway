package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.mapper.SyNextNumberMapper;
import cn.itbat.thing.anyway.model.SyNextNumberDO;
import cn.itbat.thing.anyway.service.SyNextNumberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 流水号序列数的实现.
 *
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/4/19.
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service("syNextNumberService")
public class SyNextNumberServiceImpl implements SyNextNumberService {

    @Resource
    private SyNextNumberMapper syNextNumberMapper;

    @Override
    public String getNextNumber(String numberType) {
        SyNextNumberDO nextNumberDO = new SyNextNumberDO();
        nextNumberDO.setNumberType(numberType);
        syNextNumberMapper.getNextNumber(nextNumberDO);
        return nextNumberDO.getReturnNo();
    }

    @Override
    public Long getNextSeq() {
        return syNextNumberMapper.getNextSeq();
    }

    @Override
    public String getAppSecret() {
        return syNextNumberMapper.getAppSecret();
    }
}
