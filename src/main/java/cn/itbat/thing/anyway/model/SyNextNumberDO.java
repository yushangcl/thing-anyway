package cn.itbat.thing.anyway.model;

/**
 * SyNextNumber entity.
 *
 * @author MyEclipse Persistence Tools
 */

public class SyNextNumberDO implements java.io.Serializable {

    // Fields

    private String numberType;
    private String dataType;
    private String prefix;
    private Long useDate;
    private String dateString;
    private Long nextNumber;
    private Long nextNumberLength;
    private String returnNo;

    // Property accessors

    public String getNumberType() {
        return this.numberType;
    }

    public void setNumberType(String numberType) {
        this.numberType = numberType;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Long getUseDate() {
        return this.useDate;
    }

    public void setUseDate(Long useDate) {
        this.useDate = useDate;
    }

    public String getDateString() {
        return this.dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public Long getNextNumber() {
        return this.nextNumber;
    }

    public void setNextNumber(Long nextNumber) {
        this.nextNumber = nextNumber;
    }

    public Long getNextNumberLength() {
        return this.nextNumberLength;
    }

    public void setNextNumberLength(Long nextNumberLength) {
        this.nextNumberLength = nextNumberLength;
    }

    public String getReturnNo() {
        return returnNo;
    }

    public void setReturnNo(String returnNo) {
        this.returnNo = returnNo;
    }

}