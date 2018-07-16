package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.common.utils.UKID;
import cn.itbat.thing.anyway.enums.MailCodeEnum;
import cn.itbat.thing.anyway.mapper.CmMailCodeMapper;
import cn.itbat.thing.anyway.model.CmMailCode;
import cn.itbat.thing.anyway.service.CmMailCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-13 下午3:40
 **/
@Service
@Transactional
public class CmMailCodeServiceImpl implements CmMailCodeService {

    @Autowired
    private CmMailCodeMapper cmMailCodeMapper;

    @Override
    public Long insertMailCode(String code, Long userId) {
        CmMailCode cmMailCode = new CmMailCode();
        cmMailCode.setEmailCodeUkid(UKID.getUKID());
        cmMailCode.setCode(code);
        cmMailCode.setUserId(userId);
        cmMailCode.setState(MailCodeEnum.VALID.code);
        cmMailCodeMapper.insertSelective(cmMailCode);
        return cmMailCode.getEmailCodeUkid();
    }
}
