package cn.itbat.thing.anyway.service.impl;


import cn.itbat.thing.anyway.mapper.RuOperationLogMapper;
import cn.itbat.thing.anyway.model.RuOperationLog;
import cn.itbat.thing.anyway.service.RuOperationLogService;
import cn.itbat.thing.anyway.common.utils.UKID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 操作日志
 *
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-10 下午4:15
 **/
@Service
public class RuOperationLogServiceImpl implements RuOperationLogService {

    @Autowired
    RuOperationLogMapper ruOperationLogMapper;

    @Override
    public Long insertOperationLog(RuOperationLog ruOperationLog) {
        if (ruOperationLog.getOperationLogUkid() == null) {
            ruOperationLog.setOperationLogUkid(UKID.getUKID());
        }
        ruOperationLogMapper.insert(ruOperationLog);
        return ruOperationLog.getOperationLogUkid();
    }

    @Override
    public Long insertOperationLog(Long relatedUkid, String relatedType, String operationName, Long userId, String remark) {
        RuOperationLog operationLog = new RuOperationLog();
        operationLog.setOperationLogUkid(UKID.getUKID());
        operationLog.setRelatedUkid(relatedUkid);
        operationLog.setRelatedType(relatedType);
        operationLog.setOperationName(operationName);
        operationLog.setLogUserId(userId);
        operationLog.setLogDate(new Date());
        operationLog.setLogRemark(remark);
        ruOperationLogMapper.insert(operationLog);
        return operationLog.getOperationLogUkid();
    }

    @Override
    public Long insertOperationLog(Long relatedUkid, String relatedType, String operationName, Long userId, String remark,
                                   String logDyn1, String logDyn2) {
        RuOperationLog operationLog = new RuOperationLog();
        operationLog.setOperationLogUkid(UKID.getUKID());
        operationLog.setRelatedUkid(relatedUkid);
        operationLog.setRelatedType(relatedType);
        operationLog.setOperationName(operationName);
        operationLog.setLogUserId(userId);
        operationLog.setLogDate(new Date());
        operationLog.setLogRemark(remark);
        operationLog.setLogDyn1(logDyn1);
        operationLog.setLogDyn2(logDyn2);
        ruOperationLogMapper.insert(operationLog);
        return operationLog.getOperationLogUkid();
    }

    @Override
    public Long insertLoginLog(Long userId, String status) {
        RuOperationLog operationLog = new RuOperationLog();
        operationLog.setOperationLogUkid(UKID.getUKID());
        operationLog.setRelatedUkid(userId);
        operationLog.setRelatedType("LOGIN");
        operationLog.setOperationName("登录操作");
        operationLog.setLogUserId(userId);
        operationLog.setLogDate(new Date());
        operationLog.setLogRemark(status);
        ruOperationLogMapper.insertSelective(operationLog);
        return operationLog.getOperationLogUkid();
    }
}
