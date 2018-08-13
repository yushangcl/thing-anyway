package cn.itbat.thing.anyway.common.base;

import java.util.Map;

/**
 * 分页查询基础类
 *
 * @author huahui.wu.
 * Created on 2018/4/3.
 */
public class BaseQuery {

    private Integer page;

    private Integer size;

    private String sort;

    private String orderBy;

    /**
     * 其他参数
     */
    private Map<String, Object> params;


    public int getPage() {
        return page == null ? 1 : page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size == null ? 10 : size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 返回 orderBy sort的拼接，如果要得到sort,请调用{@getPureSort()}
     *
     * @return
     */
    public String getSort() {
        if (this.orderBy != null && this.orderBy.length() > 0) {
            return this.orderBy + " " + this.sort;
        } else {
            return this.sort;
        }
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    /**
     * 设置pageNo,如果不能正确转为正型，则使用defaultValue
     *
     * @param pageNo       页码
     * @param defaultValue
     */
    public void setPage(String pageNo, int defaultValue) {
        try {
            this.page = Integer.valueOf(pageNo);
        } catch (NumberFormatException e) {
            this.page = defaultValue;
        }
    }

    /**
     * 设置pageSize,如果不能正确转为正型，则使用defaultValue
     *
     * @param pageSize     页面容量
     * @param defaultValue
     */
    public void setSize(String pageSize, int defaultValue) {
        try {
            this.size = Integer.valueOf(pageSize);
        } catch (NumberFormatException e) {
            this.size = defaultValue;
        }
    }

    public void setSort(String sort, String defaultValue) {
        if (sort != null && sort.length() > 0) {
            this.sort = sort;
        } else {
            this.sort = defaultValue;
        }
    }

    public void setOrderBy(String orderBy, String defaultValue) {
        if (orderBy != null && orderBy.length() > 0) {
            this.orderBy = orderBy;
        } else {
            this.orderBy = defaultValue;
        }
    }


    /**
     * 仅仅返回sort
     *
     * @return
     */
    public String getPureSort() {
        return this.sort;
    }

    @Deprecated
    public String getOrderCause() {
        return getOrderClause();
    }

    public String getOrderClause() {
        StringBuilder strBuilder = new StringBuilder();
        if (this.orderBy != null && this.orderBy.length() > 0) {
            strBuilder.append(this.orderBy);

            //有order时才会添加sort
            if (this.sort != null && this.sort.length() > 0) {
                strBuilder.append(" ").append(this.sort);
            }
        }
        return strBuilder.toString();
    }

    public int getOffset() {
        int pageNo = getPage();
        int pageSize = getSize();

        return (pageNo - 1) * pageSize;
    }

    public Object getParamValue(String paramName) {
        return this.params == null ? null : this.params.get(paramName);
    }

}
