package cn.itbat.thing.anyway.model;

import java.io.Serializable;
import java.util.Date;

public class CmMailCode implements Serializable {
    /**
     * 邮箱激活code主键
     */
    private Long emailCodeUkid;

    /**
     * code值
     */
    private String code;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 状态 0 未使用， 1已使用，5已失效
     */
    private Integer state;

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
     * 邮箱激活code主键
     * @return email_code_ukid 邮箱激活code主键
     */
    public Long getEmailCodeUkid() {
        return emailCodeUkid;
    }

    /**
     * 邮箱激活code主键
     * @param emailCodeUkid 邮箱激活code主键
     */
    public void setEmailCodeUkid(Long emailCodeUkid) {
        this.emailCodeUkid = emailCodeUkid;
    }

    /**
     * code值
     * @return code code值
     */
    public String getCode() {
        return code;
    }

    /**
     * code值
     * @param code code值
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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
     * 状态 0 未使用， 1已使用，5已失效
     * @return state 状态 0 未使用， 1已使用，5已失效
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态 0 未使用， 1已使用，5已失效
     * @param state 状态 0 未使用， 1已使用，5已失效
     */
    public void setState(Integer state) {
        this.state = state;
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
        sb.append(", emailCodeUkid=").append(emailCodeUkid);
        sb.append(", code=").append(code);
        sb.append(", userId=").append(userId);
        sb.append(", state=").append(state);
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
        CmMailCode other = (CmMailCode) that;
        return (this.getEmailCodeUkid() == null ? other.getEmailCodeUkid() == null : this.getEmailCodeUkid().equals(other.getEmailCodeUkid()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEmailCodeUkid() == null) ? 0 : getEmailCodeUkid().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}