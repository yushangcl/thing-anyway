package cn.itbat.thing.anyway.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RuOperationLogExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public RuOperationLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    /**
     * ru_operation_log 2018-07-10
     */
    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOperationLogUkidIsNull() {
            addCriterion("operation_log_ukid is null");
            return (Criteria) this;
        }

        public Criteria andOperationLogUkidIsNotNull() {
            addCriterion("operation_log_ukid is not null");
            return (Criteria) this;
        }

        public Criteria andOperationLogUkidEqualTo(Long value) {
            addCriterion("operation_log_ukid =", value, "operationLogUkid");
            return (Criteria) this;
        }

        public Criteria andOperationLogUkidNotEqualTo(Long value) {
            addCriterion("operation_log_ukid <>", value, "operationLogUkid");
            return (Criteria) this;
        }

        public Criteria andOperationLogUkidGreaterThan(Long value) {
            addCriterion("operation_log_ukid >", value, "operationLogUkid");
            return (Criteria) this;
        }

        public Criteria andOperationLogUkidGreaterThanOrEqualTo(Long value) {
            addCriterion("operation_log_ukid >=", value, "operationLogUkid");
            return (Criteria) this;
        }

        public Criteria andOperationLogUkidLessThan(Long value) {
            addCriterion("operation_log_ukid <", value, "operationLogUkid");
            return (Criteria) this;
        }

        public Criteria andOperationLogUkidLessThanOrEqualTo(Long value) {
            addCriterion("operation_log_ukid <=", value, "operationLogUkid");
            return (Criteria) this;
        }

        public Criteria andOperationLogUkidIn(List<Long> values) {
            addCriterion("operation_log_ukid in", values, "operationLogUkid");
            return (Criteria) this;
        }

        public Criteria andOperationLogUkidNotIn(List<Long> values) {
            addCriterion("operation_log_ukid not in", values, "operationLogUkid");
            return (Criteria) this;
        }

        public Criteria andOperationLogUkidBetween(Long value1, Long value2) {
            addCriterion("operation_log_ukid between", value1, value2, "operationLogUkid");
            return (Criteria) this;
        }

        public Criteria andOperationLogUkidNotBetween(Long value1, Long value2) {
            addCriterion("operation_log_ukid not between", value1, value2, "operationLogUkid");
            return (Criteria) this;
        }

        public Criteria andRelatedUkidIsNull() {
            addCriterion("related_ukid is null");
            return (Criteria) this;
        }

        public Criteria andRelatedUkidIsNotNull() {
            addCriterion("related_ukid is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedUkidEqualTo(Long value) {
            addCriterion("related_ukid =", value, "relatedUkid");
            return (Criteria) this;
        }

        public Criteria andRelatedUkidNotEqualTo(Long value) {
            addCriterion("related_ukid <>", value, "relatedUkid");
            return (Criteria) this;
        }

        public Criteria andRelatedUkidGreaterThan(Long value) {
            addCriterion("related_ukid >", value, "relatedUkid");
            return (Criteria) this;
        }

        public Criteria andRelatedUkidGreaterThanOrEqualTo(Long value) {
            addCriterion("related_ukid >=", value, "relatedUkid");
            return (Criteria) this;
        }

        public Criteria andRelatedUkidLessThan(Long value) {
            addCriterion("related_ukid <", value, "relatedUkid");
            return (Criteria) this;
        }

        public Criteria andRelatedUkidLessThanOrEqualTo(Long value) {
            addCriterion("related_ukid <=", value, "relatedUkid");
            return (Criteria) this;
        }

        public Criteria andRelatedUkidIn(List<Long> values) {
            addCriterion("related_ukid in", values, "relatedUkid");
            return (Criteria) this;
        }

        public Criteria andRelatedUkidNotIn(List<Long> values) {
            addCriterion("related_ukid not in", values, "relatedUkid");
            return (Criteria) this;
        }

        public Criteria andRelatedUkidBetween(Long value1, Long value2) {
            addCriterion("related_ukid between", value1, value2, "relatedUkid");
            return (Criteria) this;
        }

        public Criteria andRelatedUkidNotBetween(Long value1, Long value2) {
            addCriterion("related_ukid not between", value1, value2, "relatedUkid");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeIsNull() {
            addCriterion("related_type is null");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeIsNotNull() {
            addCriterion("related_type is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeEqualTo(String value) {
            addCriterion("related_type =", value, "relatedType");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeNotEqualTo(String value) {
            addCriterion("related_type <>", value, "relatedType");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeGreaterThan(String value) {
            addCriterion("related_type >", value, "relatedType");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeGreaterThanOrEqualTo(String value) {
            addCriterion("related_type >=", value, "relatedType");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeLessThan(String value) {
            addCriterion("related_type <", value, "relatedType");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeLessThanOrEqualTo(String value) {
            addCriterion("related_type <=", value, "relatedType");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeLike(String value) {
            addCriterion("related_type like", value, "relatedType");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeNotLike(String value) {
            addCriterion("related_type not like", value, "relatedType");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeIn(List<String> values) {
            addCriterion("related_type in", values, "relatedType");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeNotIn(List<String> values) {
            addCriterion("related_type not in", values, "relatedType");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeBetween(String value1, String value2) {
            addCriterion("related_type between", value1, value2, "relatedType");
            return (Criteria) this;
        }

        public Criteria andRelatedTypeNotBetween(String value1, String value2) {
            addCriterion("related_type not between", value1, value2, "relatedType");
            return (Criteria) this;
        }

        public Criteria andOperationNameIsNull() {
            addCriterion("operation_name is null");
            return (Criteria) this;
        }

        public Criteria andOperationNameIsNotNull() {
            addCriterion("operation_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperationNameEqualTo(String value) {
            addCriterion("operation_name =", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotEqualTo(String value) {
            addCriterion("operation_name <>", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameGreaterThan(String value) {
            addCriterion("operation_name >", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameGreaterThanOrEqualTo(String value) {
            addCriterion("operation_name >=", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameLessThan(String value) {
            addCriterion("operation_name <", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameLessThanOrEqualTo(String value) {
            addCriterion("operation_name <=", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameLike(String value) {
            addCriterion("operation_name like", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotLike(String value) {
            addCriterion("operation_name not like", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameIn(List<String> values) {
            addCriterion("operation_name in", values, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotIn(List<String> values) {
            addCriterion("operation_name not in", values, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameBetween(String value1, String value2) {
            addCriterion("operation_name between", value1, value2, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotBetween(String value1, String value2) {
            addCriterion("operation_name not between", value1, value2, "operationName");
            return (Criteria) this;
        }

        public Criteria andLogUserIdIsNull() {
            addCriterion("log_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLogUserIdIsNotNull() {
            addCriterion("log_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogUserIdEqualTo(Long value) {
            addCriterion("log_user_id =", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdNotEqualTo(Long value) {
            addCriterion("log_user_id <>", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdGreaterThan(Long value) {
            addCriterion("log_user_id >", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_user_id >=", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdLessThan(Long value) {
            addCriterion("log_user_id <", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdLessThanOrEqualTo(Long value) {
            addCriterion("log_user_id <=", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdIn(List<Long> values) {
            addCriterion("log_user_id in", values, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdNotIn(List<Long> values) {
            addCriterion("log_user_id not in", values, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdBetween(Long value1, Long value2) {
            addCriterion("log_user_id between", value1, value2, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdNotBetween(Long value1, Long value2) {
            addCriterion("log_user_id not between", value1, value2, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogDateIsNull() {
            addCriterion("log_date is null");
            return (Criteria) this;
        }

        public Criteria andLogDateIsNotNull() {
            addCriterion("log_date is not null");
            return (Criteria) this;
        }

        public Criteria andLogDateEqualTo(Date value) {
            addCriterion("log_date =", value, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateNotEqualTo(Date value) {
            addCriterion("log_date <>", value, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateGreaterThan(Date value) {
            addCriterion("log_date >", value, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateGreaterThanOrEqualTo(Date value) {
            addCriterion("log_date >=", value, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateLessThan(Date value) {
            addCriterion("log_date <", value, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateLessThanOrEqualTo(Date value) {
            addCriterion("log_date <=", value, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateIn(List<Date> values) {
            addCriterion("log_date in", values, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateNotIn(List<Date> values) {
            addCriterion("log_date not in", values, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateBetween(Date value1, Date value2) {
            addCriterion("log_date between", value1, value2, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateNotBetween(Date value1, Date value2) {
            addCriterion("log_date not between", value1, value2, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogRemarkIsNull() {
            addCriterion("log_remark is null");
            return (Criteria) this;
        }

        public Criteria andLogRemarkIsNotNull() {
            addCriterion("log_remark is not null");
            return (Criteria) this;
        }

        public Criteria andLogRemarkEqualTo(String value) {
            addCriterion("log_remark =", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkNotEqualTo(String value) {
            addCriterion("log_remark <>", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkGreaterThan(String value) {
            addCriterion("log_remark >", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("log_remark >=", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkLessThan(String value) {
            addCriterion("log_remark <", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkLessThanOrEqualTo(String value) {
            addCriterion("log_remark <=", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkLike(String value) {
            addCriterion("log_remark like", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkNotLike(String value) {
            addCriterion("log_remark not like", value, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkIn(List<String> values) {
            addCriterion("log_remark in", values, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkNotIn(List<String> values) {
            addCriterion("log_remark not in", values, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkBetween(String value1, String value2) {
            addCriterion("log_remark between", value1, value2, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogRemarkNotBetween(String value1, String value2) {
            addCriterion("log_remark not between", value1, value2, "logRemark");
            return (Criteria) this;
        }

        public Criteria andLogDyn1IsNull() {
            addCriterion("log_dyn1 is null");
            return (Criteria) this;
        }

        public Criteria andLogDyn1IsNotNull() {
            addCriterion("log_dyn1 is not null");
            return (Criteria) this;
        }

        public Criteria andLogDyn1EqualTo(String value) {
            addCriterion("log_dyn1 =", value, "logDyn1");
            return (Criteria) this;
        }

        public Criteria andLogDyn1NotEqualTo(String value) {
            addCriterion("log_dyn1 <>", value, "logDyn1");
            return (Criteria) this;
        }

        public Criteria andLogDyn1GreaterThan(String value) {
            addCriterion("log_dyn1 >", value, "logDyn1");
            return (Criteria) this;
        }

        public Criteria andLogDyn1GreaterThanOrEqualTo(String value) {
            addCriterion("log_dyn1 >=", value, "logDyn1");
            return (Criteria) this;
        }

        public Criteria andLogDyn1LessThan(String value) {
            addCriterion("log_dyn1 <", value, "logDyn1");
            return (Criteria) this;
        }

        public Criteria andLogDyn1LessThanOrEqualTo(String value) {
            addCriterion("log_dyn1 <=", value, "logDyn1");
            return (Criteria) this;
        }

        public Criteria andLogDyn1Like(String value) {
            addCriterion("log_dyn1 like", value, "logDyn1");
            return (Criteria) this;
        }

        public Criteria andLogDyn1NotLike(String value) {
            addCriterion("log_dyn1 not like", value, "logDyn1");
            return (Criteria) this;
        }

        public Criteria andLogDyn1In(List<String> values) {
            addCriterion("log_dyn1 in", values, "logDyn1");
            return (Criteria) this;
        }

        public Criteria andLogDyn1NotIn(List<String> values) {
            addCriterion("log_dyn1 not in", values, "logDyn1");
            return (Criteria) this;
        }

        public Criteria andLogDyn1Between(String value1, String value2) {
            addCriterion("log_dyn1 between", value1, value2, "logDyn1");
            return (Criteria) this;
        }

        public Criteria andLogDyn1NotBetween(String value1, String value2) {
            addCriterion("log_dyn1 not between", value1, value2, "logDyn1");
            return (Criteria) this;
        }

        public Criteria andLogDyn2IsNull() {
            addCriterion("log_dyn2 is null");
            return (Criteria) this;
        }

        public Criteria andLogDyn2IsNotNull() {
            addCriterion("log_dyn2 is not null");
            return (Criteria) this;
        }

        public Criteria andLogDyn2EqualTo(String value) {
            addCriterion("log_dyn2 =", value, "logDyn2");
            return (Criteria) this;
        }

        public Criteria andLogDyn2NotEqualTo(String value) {
            addCriterion("log_dyn2 <>", value, "logDyn2");
            return (Criteria) this;
        }

        public Criteria andLogDyn2GreaterThan(String value) {
            addCriterion("log_dyn2 >", value, "logDyn2");
            return (Criteria) this;
        }

        public Criteria andLogDyn2GreaterThanOrEqualTo(String value) {
            addCriterion("log_dyn2 >=", value, "logDyn2");
            return (Criteria) this;
        }

        public Criteria andLogDyn2LessThan(String value) {
            addCriterion("log_dyn2 <", value, "logDyn2");
            return (Criteria) this;
        }

        public Criteria andLogDyn2LessThanOrEqualTo(String value) {
            addCriterion("log_dyn2 <=", value, "logDyn2");
            return (Criteria) this;
        }

        public Criteria andLogDyn2Like(String value) {
            addCriterion("log_dyn2 like", value, "logDyn2");
            return (Criteria) this;
        }

        public Criteria andLogDyn2NotLike(String value) {
            addCriterion("log_dyn2 not like", value, "logDyn2");
            return (Criteria) this;
        }

        public Criteria andLogDyn2In(List<String> values) {
            addCriterion("log_dyn2 in", values, "logDyn2");
            return (Criteria) this;
        }

        public Criteria andLogDyn2NotIn(List<String> values) {
            addCriterion("log_dyn2 not in", values, "logDyn2");
            return (Criteria) this;
        }

        public Criteria andLogDyn2Between(String value1, String value2) {
            addCriterion("log_dyn2 between", value1, value2, "logDyn2");
            return (Criteria) this;
        }

        public Criteria andLogDyn2NotBetween(String value1, String value2) {
            addCriterion("log_dyn2 not between", value1, value2, "logDyn2");
            return (Criteria) this;
        }
    }

    /**
     * ru_operation_log
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * ru_operation_log 2018-07-10
     */
    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}