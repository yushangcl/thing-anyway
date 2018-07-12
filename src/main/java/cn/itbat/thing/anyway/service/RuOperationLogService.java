package cn.itbat.thing.anyway.service;

import cn.itbat.thing.anyway.model.RuOperationLog;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-10 下午4:15
 **/
public interface RuOperationLogService {
    /**
     * 记录操作日志
     *
     * @param ruOperationLog 日志
     * @return
     */
    Long insertOperationLog(RuOperationLog ruOperationLog);

    /**
     * 记录操纵日志
     *
     * @param relatedUkid   关联ukid
     * @param relatedType   关联类型
     * @param operationName 操作名称
     * @param userId        操作人
     * @param remark        备注
     * @return operationLogUkid
     */
    Long insertOperationLog(Long relatedUkid, String relatedType, String operationName, Long userId, String remark);

    /**
     * 记录操纵日志
     *
     * @param relatedUkid   关联ukid
     * @param relatedType   关联类型
     * @param operationName 操作名称
     * @param userId        操作人
     * @param remark        备注
     * @param logDyn1       预留字段1
     * @param logDyn2       预留字段2
     * @return operationLogUkid
     */
    Long insertOperationLog(Long relatedUkid, String relatedType, String operationName, Long userId, String remark,
                            String logDyn1, String logDyn2);

    /**
     * 记录登入操作
     *
     * @param userId 用户id
     * @param status 登录状态
     * @return operationLogUkid
     */
    Long insertLoginLog(Long userId, String status);
}
