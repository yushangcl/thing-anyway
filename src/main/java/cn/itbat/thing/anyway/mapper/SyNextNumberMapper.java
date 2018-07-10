package cn.itbat.thing.anyway.mapper;


import cn.itbat.thing.anyway.model.SyNextNumberDO;

public interface SyNextNumberMapper {
    SyNextNumberDO select(String numberType);

    String getNextNumber(SyNextNumberDO nn);

    /**
     * 获取_seq的序列：从100000开始每次增1的数字
     *
     * @return
     */
    public Long getNextSeq();

    public String getAppSecret();
}
