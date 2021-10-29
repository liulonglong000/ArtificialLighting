package com.face.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IgcsCthresholdGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IgcsCthresholdGroupExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andThresholdGroupIdIsNull() {
            addCriterion("threshold_group_id is null");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupIdIsNotNull() {
            addCriterion("threshold_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupIdEqualTo(String value) {
            addCriterion("threshold_group_id =", value, "thresholdGroupId");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupIdNotEqualTo(String value) {
            addCriterion("threshold_group_id <>", value, "thresholdGroupId");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupIdGreaterThan(String value) {
            addCriterion("threshold_group_id >", value, "thresholdGroupId");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("threshold_group_id >=", value, "thresholdGroupId");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupIdLessThan(String value) {
            addCriterion("threshold_group_id <", value, "thresholdGroupId");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupIdLessThanOrEqualTo(String value) {
            addCriterion("threshold_group_id <=", value, "thresholdGroupId");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupIdLike(String value) {
            addCriterion("threshold_group_id like", value, "thresholdGroupId");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupIdNotLike(String value) {
            addCriterion("threshold_group_id not like", value, "thresholdGroupId");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupIdIn(List<String> values) {
            addCriterion("threshold_group_id in", values, "thresholdGroupId");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupIdNotIn(List<String> values) {
            addCriterion("threshold_group_id not in", values, "thresholdGroupId");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupIdBetween(String value1, String value2) {
            addCriterion("threshold_group_id between", value1, value2, "thresholdGroupId");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupIdNotBetween(String value1, String value2) {
            addCriterion("threshold_group_id not between", value1, value2, "thresholdGroupId");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameIsNull() {
            addCriterion("threshold_group_name is null");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameIsNotNull() {
            addCriterion("threshold_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameEqualTo(String value) {
            addCriterion("threshold_group_name =", value, "thresholdGroupName");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameNotEqualTo(String value) {
            addCriterion("threshold_group_name <>", value, "thresholdGroupName");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameGreaterThan(String value) {
            addCriterion("threshold_group_name >", value, "thresholdGroupName");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("threshold_group_name >=", value, "thresholdGroupName");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameLessThan(String value) {
            addCriterion("threshold_group_name <", value, "thresholdGroupName");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameLessThanOrEqualTo(String value) {
            addCriterion("threshold_group_name <=", value, "thresholdGroupName");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameLike(String value) {
            addCriterion("threshold_group_name like", value, "thresholdGroupName");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameNotLike(String value) {
            addCriterion("threshold_group_name not like", value, "thresholdGroupName");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameIn(List<String> values) {
            addCriterion("threshold_group_name in", values, "thresholdGroupName");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameNotIn(List<String> values) {
            addCriterion("threshold_group_name not in", values, "thresholdGroupName");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameBetween(String value1, String value2) {
            addCriterion("threshold_group_name between", value1, value2, "thresholdGroupName");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupNameNotBetween(String value1, String value2) {
            addCriterion("threshold_group_name not between", value1, value2, "thresholdGroupName");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdIsNull() {
            addCriterion("greenhouse_id is null");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdIsNotNull() {
            addCriterion("greenhouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdEqualTo(String value) {
            addCriterion("greenhouse_id =", value, "greenhouseId");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdNotEqualTo(String value) {
            addCriterion("greenhouse_id <>", value, "greenhouseId");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdGreaterThan(String value) {
            addCriterion("greenhouse_id >", value, "greenhouseId");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("greenhouse_id >=", value, "greenhouseId");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdLessThan(String value) {
            addCriterion("greenhouse_id <", value, "greenhouseId");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdLessThanOrEqualTo(String value) {
            addCriterion("greenhouse_id <=", value, "greenhouseId");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdLike(String value) {
            addCriterion("greenhouse_id like", value, "greenhouseId");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdNotLike(String value) {
            addCriterion("greenhouse_id not like", value, "greenhouseId");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdIn(List<String> values) {
            addCriterion("greenhouse_id in", values, "greenhouseId");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdNotIn(List<String> values) {
            addCriterion("greenhouse_id not in", values, "greenhouseId");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdBetween(String value1, String value2) {
            addCriterion("greenhouse_id between", value1, value2, "greenhouseId");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIdNotBetween(String value1, String value2) {
            addCriterion("greenhouse_id not between", value1, value2, "greenhouseId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(String value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(String value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(String value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(String value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(String value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLike(String value) {
            addCriterion("update_user_id like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotLike(String value) {
            addCriterion("update_user_id not like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<String> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<String> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(String value1, String value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(String value1, String value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andInDateIsNull() {
            addCriterion("in_date is null");
            return (Criteria) this;
        }

        public Criteria andInDateIsNotNull() {
            addCriterion("in_date is not null");
            return (Criteria) this;
        }

        public Criteria andInDateEqualTo(Date value) {
            addCriterion("in_date =", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotEqualTo(Date value) {
            addCriterion("in_date <>", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThan(Date value) {
            addCriterion("in_date >", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThanOrEqualTo(Date value) {
            addCriterion("in_date >=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThan(Date value) {
            addCriterion("in_date <", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThanOrEqualTo(Date value) {
            addCriterion("in_date <=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateIn(List<Date> values) {
            addCriterion("in_date in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotIn(List<Date> values) {
            addCriterion("in_date not in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateBetween(Date value1, Date value2) {
            addCriterion("in_date between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotBetween(Date value1, Date value2) {
            addCriterion("in_date not between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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