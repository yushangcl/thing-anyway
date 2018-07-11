package cn.itbat.thing.anyway.model;

import java.io.Serializable;
import java.util.Date;

public class SysMenu implements Serializable {
    /**
     * 
     */
    private Long menuId;

    /**
     * 权限名称
     */
    private String menuName;

    /**
     * 类型 0菜单 1按钮
     */
    private String type;

    /**
     * 地址
     */
    private String url;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 父级权限
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否外部链接
     */
    private Boolean external;

    /**
     * 是否可用
     */
    private Boolean available;

    /**
     * 菜单图标
     */
    private String icon;

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
     * 
     * @return menu_id 
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 
     * @param menuId 
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 权限名称
     * @return menu_name 权限名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 权限名称
     * @param menuName 权限名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 类型 0菜单 1按钮
     * @return type 类型 0菜单 1按钮
     */
    public String getType() {
        return type;
    }

    /**
     * 类型 0菜单 1按钮
     * @param type 类型 0菜单 1按钮
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 地址
     * @return url 地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 地址
     * @param url 地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 权限标识
     * @return perms 权限标识
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 权限标识
     * @param perms 权限标识
     */
    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    /**
     * 父级权限
     * @return parent_id 父级权限
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父级权限
     * @param parentId 父级权限
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 排序
     * @return sort 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 是否外部链接
     * @return external 是否外部链接
     */
    public Boolean getExternal() {
        return external;
    }

    /**
     * 是否外部链接
     * @param external 是否外部链接
     */
    public void setExternal(Boolean external) {
        this.external = external;
    }

    /**
     * 是否可用
     * @return available 是否可用
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * 是否可用
     * @param available 是否可用
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    /**
     * 菜单图标
     * @return icon 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 菜单图标
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
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
        sb.append(", menuId=").append(menuId);
        sb.append(", menuName=").append(menuName);
        sb.append(", type=").append(type);
        sb.append(", url=").append(url);
        sb.append(", perms=").append(perms);
        sb.append(", parentId=").append(parentId);
        sb.append(", sort=").append(sort);
        sb.append(", external=").append(external);
        sb.append(", available=").append(available);
        sb.append(", icon=").append(icon);
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
        SysMenu other = (SysMenu) that;
        return (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getPerms() == null ? other.getPerms() == null : this.getPerms().equals(other.getPerms()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getExternal() == null ? other.getExternal() == null : this.getExternal().equals(other.getExternal()))
            && (this.getAvailable() == null ? other.getAvailable() == null : this.getAvailable().equals(other.getAvailable()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getPerms() == null) ? 0 : getPerms().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getExternal() == null) ? 0 : getExternal().hashCode());
        result = prime * result + ((getAvailable() == null) ? 0 : getAvailable().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}