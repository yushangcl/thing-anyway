package cn.itbat.thing.anyway.mapper;

import cn.itbat.thing.anyway.model.RuOperationLog;
import cn.itbat.thing.anyway.model.RuOperationLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RuOperationLogMapper {
    int countByExample(RuOperationLogExample example);

    int deleteByExample(RuOperationLogExample example);

    int deleteByPrimaryKey(Long operationLogUkid);

    int insert(RuOperationLog record);

    int insertSelective(RuOperationLog record);

    List<RuOperationLog> selectByExample(RuOperationLogExample example);

    RuOperationLog selectByPrimaryKey(Long operationLogUkid);

    int updateByExampleSelective(@Param("record") RuOperationLog record, @Param("example") RuOperationLogExample example);

    int updateByExample(@Param("record") RuOperationLog record, @Param("example") RuOperationLogExample example);

    int updateByPrimaryKeySelective(RuOperationLog record);

    int updateByPrimaryKey(RuOperationLog record);
}