package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.mapper.CmUserMapper;
import cn.itbat.thing.anyway.model.CmUser;
import cn.itbat.thing.anyway.service.CmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-10 下午3:45
 **/
@Service
public class CmUserServiceImpl implements CmUserService {

    @Autowired
    private CmUserMapper cmUserMapper;

    @Override
    public CmUser findByName(String userName){
        return cmUserMapper.findByName(userName);
    }
}
