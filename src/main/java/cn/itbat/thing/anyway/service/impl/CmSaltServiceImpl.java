package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.mapper.CmSaltMapper;
import cn.itbat.thing.anyway.model.CmSalt;
import cn.itbat.thing.anyway.service.CmSaltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-11 下午2:42
 **/
@Service
public class CmSaltServiceImpl implements CmSaltService {

    @Autowired
    private CmSaltMapper cmSaltMapper;

    @Override
    public CmSalt findSalt(Long saltUkid){
       return cmSaltMapper.selectByPrimaryKey(saltUkid);
    }
}
