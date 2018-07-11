package cn.itbat.thing.anyway.mapper;

import cn.itbat.thing.anyway.model.CmSalt;
import cn.itbat.thing.anyway.model.CmSaltExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmSaltMapper {
    int countByExample(CmSaltExample example);

    int deleteByExample(CmSaltExample example);

    int deleteByPrimaryKey(Long saltUkid);

    int insert(CmSalt record);

    int insertSelective(CmSalt record);

    List<CmSalt> selectByExample(CmSaltExample example);

    CmSalt selectByPrimaryKey(Long saltUkid);

    int updateByExampleSelective(@Param("record") CmSalt record, @Param("example") CmSaltExample example);

    int updateByExample(@Param("record") CmSalt record, @Param("example") CmSaltExample example);

    int updateByPrimaryKeySelective(CmSalt record);

    int updateByPrimaryKey(CmSalt record);
}