package cn.itbat.thing.anyway.service.impl;

import cn.itbat.thing.anyway.common.utils.*;
import cn.itbat.thing.anyway.constant.Constants;
import cn.itbat.thing.anyway.enums.UserStatusEnum;
import cn.itbat.thing.anyway.mapper.CmUserMapper;
import cn.itbat.thing.anyway.model.CmUser;
import cn.itbat.thing.anyway.service.CmSaltService;
import cn.itbat.thing.anyway.service.CmUserService;
import cn.itbat.thing.anyway.service.MailService;
import cn.itbat.thing.anyway.service.RuOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author log.r   (;￢＿￢)   
 * @date 2018-07-10 下午3:45
 **/
@Service
@Transactional
public class CmUserServiceImpl implements CmUserService {

    @Autowired
    private CmUserMapper cmUserMapper;

    @Resource
    private CmSaltService cmSaltService;

    @Resource
    private MailService mailService;

    @Resource
    private RuOperationLogService ruOperationLogService;

    @Override
    public CmUser findByName(String userName) {
        return cmUserMapper.findByName(userName);
    }

    @Override
    public void updateUserStatus(Long userId, UserStatusEnum status) {
        //更新用户状态，需要判断状态的不可逆转
        CmUser cmUser = cmUserMapper.selectByPrimaryKey(userId);
        if (UserStatusEnum.compare(cmUser.getStatus(), status.getCode())) {
            cmUser.setStatus(status.getCode());
            cmUser.setUpdateUserId(Constants.SYS_USER_ID);
            cmUserMapper.updateByPrimaryKeySelective(cmUser);

            //记录用户状态更新日志
            ruOperationLogService.insertOperationLog(userId, "USER_STATUS_UPDATE", "用户状态更新",
                    userId, status.getCode() + ":" + status.getMessage());
        }
    }


    @Override
    public AbsResponse register(String userName, String password, String email) {
        // todo 以后需要对密码加密传输

        //判断用户名格式 英文，数字组合 6-16位
        if (!RegexUtils.checkUserName(userName)) {
            return AbsResponse.warn("用户名格式错误！");
        }

        //判断密码格式是否正确， 大小写，数字，符号，包含两者，8-16位
        if (!RegexUtils.checkPassword(password)) {
            return AbsResponse.warn("密码格式错误！");
        }

        //判断email格式是否正确
        if (!RegexUtils.checkEmail(email)) {
            return AbsResponse.warn("邮箱格式错误！");
        }

        //判断用户名是否重复
        CmUser result = this.findByName(userName);
        if (result != null) {
            return AbsResponse.warn("该用户名已被使用！");
        }

        //校验邮箱是否被使用，
        if (cmUserMapper.findByEmail(email) != null) {
            return AbsResponse.warn("该邮箱地址已被使用！");
        }

        Long userId = DOCN.getEmpId();
        // 生成密码盐值
        String salt = RandomUtil.generateStr(10);
        Long saltUkid = cmSaltService.insertSalt(salt, userId);
        password = MD5Utils.encrypt(userName, password, salt);

        CmUser cmUser = new CmUser();
        cmUser.setUserId(userId);
        cmUser.setUserName(userName);
        cmUser.setUserPassword(password);
        cmUser.setSaltUkid(saltUkid);
        cmUser.setEmail(email);
        cmUser.setStatus(UserStatusEnum.NOT_EFFECTIVE.getCode());
        cmUserMapper.insertSelective(cmUser);
        //发送激活邮件
        mailService.sendEmail(userName, userId, email);

        //记录日志
        ruOperationLogService.insertOperationLog(userId, "USER_ID", "用户注册", userId, "注册成功");
        return AbsResponse.ok();
    }

}
