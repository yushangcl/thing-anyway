package cn.itbat.thing.anyway.mapper;

import cn.itbat.thing.anyway.model.CmMailCode;
import cn.itbat.thing.anyway.model.CmMailCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmMailCodeMapper {
    int countByExample(CmMailCodeExample example);

    int deleteByExample(CmMailCodeExample example);

    int deleteByPrimaryKey(Long emailCodeUkid);

    int insert(CmMailCode record);

    int insertSelective(CmMailCode record);

    List<CmMailCode> selectByExample(CmMailCodeExample example);

    CmMailCode selectByPrimaryKey(Long emailCodeUkid);

    int updateByExampleSelective(@Param("record") CmMailCode record, @Param("example") CmMailCodeExample example);

    int updateByExample(@Param("record") CmMailCode record, @Param("example") CmMailCodeExample example);

    int updateByPrimaryKeySelective(CmMailCode record);

    int updateByPrimaryKey(CmMailCode record);
}