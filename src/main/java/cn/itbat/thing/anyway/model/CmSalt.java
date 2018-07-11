package cn.itbat.thing.anyway.model;

import java.io.Serializable;
import java.util.Date;

public class CmSalt implements Serializable {
    /**
     * 主键
     */
    private Long saltUkid;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 盐值
     */
    private String saltValue;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @return salt_ukid 主键
     */
    public Long getSaltUkid() {
        return saltUkid;
    }

    /**
     * 主键
     * @param saltUkid 主键
     */
    public void setSaltUkid(Long saltUkid) {
        this.saltUkid = saltUkid;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 盐值
     * @return salt_value 盐值
     */
    public String getSaltValue() {
        return saltValue;
    }

    /**
     * 盐值
     * @param saltValue 盐值
     */
    public void setSaltValue(String saltValue) {
        this.saltValue = saltValue == null ? null : saltValue.trim();
    }

    /**
     * 添加时间
     * @return create_time 添加时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 添加时间
     * @param createTime 添加时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", saltUkid=").append(saltUkid);
        sb.append(", userId=").append(userId);
        sb.append(", saltValue=").append(saltValue);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CmSalt other = (CmSalt) that;
        return (this.getSaltUkid() == null ? other.getSaltUkid() == null : this.getSaltUkid().equals(other.getSaltUkid()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSaltValue() == null ? other.getSaltValue() == null : this.getSaltValue().equals(other.getSaltValue()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSaltUkid() == null) ? 0 : getSaltUkid().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSaltValue() == null) ? 0 : getSaltValue().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}