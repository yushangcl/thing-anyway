package cn.itbat.thing.anyway.mapper;

import cn.itbat.thing.anyway.model.CmUser;
import cn.itbat.thing.anyway.model.CmUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmUserMapper {
    int countByExample(CmUserExample example);

    int deleteByExample(CmUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(CmUser record);

    int insertSelective(CmUser record);

    List<CmUser> selectByExample(CmUserExample example);

    CmUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") CmUser record, @Param("example") CmUserExample example);

    int updateByExample(@Param("record") CmUser record, @Param("example") CmUserExample example);

    int updateByPrimaryKeySelective(CmUser record);

    int updateByPrimaryKey(CmUser record);

    CmUser findByName(@Param("userName") String userName);

    CmUser findByEmail(@Param("emailAddress") String emailAddress);
}