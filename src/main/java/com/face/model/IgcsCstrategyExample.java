package com.face.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IgcsCstrategyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IgcsCstrategyExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andStrategyIdIsNull() {
            addCriterion("strategy_id is null");
            return (Criteria) this;
        }

        public Criteria andStrategyIdIsNotNull() {
            addCriterion("strategy_id is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyIdEqualTo(String value) {
            addCriterion("strategy_id =", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdNotEqualTo(String value) {
            addCriterion("strategy_id <>", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdGreaterThan(String value) {
            addCriterion("strategy_id >", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdGreaterThanOrEqualTo(String value) {
            addCriterion("strategy_id >=", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdLessThan(String value) {
            addCriterion("strategy_id <", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdLessThanOrEqualTo(String value) {
            addCriterion("strategy_id <=", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdLike(String value) {
            addCriterion("strategy_id like", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdNotLike(String value) {
            addCriterion("strategy_id not like", value, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdIn(List<String> values) {
            addCriterion("strategy_id in", values, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdNotIn(List<String> values) {
            addCriterion("strategy_id not in", values, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdBetween(String value1, String value2) {
            addCriterion("strategy_id between", value1, value2, "strategyId");
            return (Criteria) this;
        }

        public Criteria andStrategyIdNotBetween(String value1, String value2) {
            addCriterion("strategy_id not between", value1, value2, "strategyId");
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

        public Criteria andThresholdGroupId1IsNull() {
            addCriterion("threshold_group_id1 is null");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId1IsNotNull() {
            addCriterion("threshold_group_id1 is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId1EqualTo(String value) {
            addCriterion("threshold_group_id1 =", value, "thresholdGroupId1");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId1NotEqualTo(String value) {
            addCriterion("threshold_group_id1 <>", value, "thresholdGroupId1");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId1GreaterThan(String value) {
            addCriterion("threshold_group_id1 >", value, "thresholdGroupId1");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId1GreaterThanOrEqualTo(String value) {
            addCriterion("threshold_group_id1 >=", value, "thresholdGroupId1");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId1LessThan(String value) {
            addCriterion("threshold_group_id1 <", value, "thresholdGroupId1");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId1LessThanOrEqualTo(String value) {
            addCriterion("threshold_group_id1 <=", value, "thresholdGroupId1");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId1Like(String value) {
            addCriterion("threshold_group_id1 like", value, "thresholdGroupId1");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId1NotLike(String value) {
            addCriterion("threshold_group_id1 not like", value, "thresholdGroupId1");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId1In(List<String> values) {
            addCriterion("threshold_group_id1 in", values, "thresholdGroupId1");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId1NotIn(List<String> values) {
            addCriterion("threshold_group_id1 not in", values, "thresholdGroupId1");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId1Between(String value1, String value2) {
            addCriterion("threshold_group_id1 between", value1, value2, "thresholdGroupId1");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId1NotBetween(String value1, String value2) {
            addCriterion("threshold_group_id1 not between", value1, value2, "thresholdGroupId1");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2IsNull() {
            addCriterion("threshold_group_id2 is null");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2IsNotNull() {
            addCriterion("threshold_group_id2 is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2EqualTo(String value) {
            addCriterion("threshold_group_id2 =", value, "thresholdGroupId2");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2NotEqualTo(String value) {
            addCriterion("threshold_group_id2 <>", value, "thresholdGroupId2");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2GreaterThan(String value) {
            addCriterion("threshold_group_id2 >", value, "thresholdGroupId2");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2GreaterThanOrEqualTo(String value) {
            addCriterion("threshold_group_id2 >=", value, "thresholdGroupId2");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2LessThan(String value) {
            addCriterion("threshold_group_id2 <", value, "thresholdGroupId2");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2LessThanOrEqualTo(String value) {
            addCriterion("threshold_group_id2 <=", value, "thresholdGroupId2");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2Like(String value) {
            addCriterion("threshold_group_id2 like", value, "thresholdGroupId2");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2NotLike(String value) {
            addCriterion("threshold_group_id2 not like", value, "thresholdGroupId2");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2In(List<String> values) {
            addCriterion("threshold_group_id2 in", values, "thresholdGroupId2");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2NotIn(List<String> values) {
            addCriterion("threshold_group_id2 not in", values, "thresholdGroupId2");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2Between(String value1, String value2) {
            addCriterion("threshold_group_id2 between", value1, value2, "thresholdGroupId2");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId2NotBetween(String value1, String value2) {
            addCriterion("threshold_group_id2 not between", value1, value2, "thresholdGroupId2");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3IsNull() {
            addCriterion("threshold_group_id3 is null");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3IsNotNull() {
            addCriterion("threshold_group_id3 is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3EqualTo(String value) {
            addCriterion("threshold_group_id3 =", value, "thresholdGroupId3");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3NotEqualTo(String value) {
            addCriterion("threshold_group_id3 <>", value, "thresholdGroupId3");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3GreaterThan(String value) {
            addCriterion("threshold_group_id3 >", value, "thresholdGroupId3");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3GreaterThanOrEqualTo(String value) {
            addCriterion("threshold_group_id3 >=", value, "thresholdGroupId3");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3LessThan(String value) {
            addCriterion("threshold_group_id3 <", value, "thresholdGroupId3");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3LessThanOrEqualTo(String value) {
            addCriterion("threshold_group_id3 <=", value, "thresholdGroupId3");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3Like(String value) {
            addCriterion("threshold_group_id3 like", value, "thresholdGroupId3");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3NotLike(String value) {
            addCriterion("threshold_group_id3 not like", value, "thresholdGroupId3");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3In(List<String> values) {
            addCriterion("threshold_group_id3 in", values, "thresholdGroupId3");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3NotIn(List<String> values) {
            addCriterion("threshold_group_id3 not in", values, "thresholdGroupId3");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3Between(String value1, String value2) {
            addCriterion("threshold_group_id3 between", value1, value2, "thresholdGroupId3");
            return (Criteria) this;
        }

        public Criteria andThresholdGroupId3NotBetween(String value1, String value2) {
            addCriterion("threshold_group_id3 not between", value1, value2, "thresholdGroupId3");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdIsNull() {
            addCriterion("operate_group_id is null");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdIsNotNull() {
            addCriterion("operate_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdEqualTo(String value) {
            addCriterion("operate_group_id =", value, "operateGroupId");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdNotEqualTo(String value) {
            addCriterion("operate_group_id <>", value, "operateGroupId");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdGreaterThan(String value) {
            addCriterion("operate_group_id >", value, "operateGroupId");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("operate_group_id >=", value, "operateGroupId");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdLessThan(String value) {
            addCriterion("operate_group_id <", value, "operateGroupId");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdLessThanOrEqualTo(String value) {
            addCriterion("operate_group_id <=", value, "operateGroupId");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdLike(String value) {
            addCriterion("operate_group_id like", value, "operateGroupId");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdNotLike(String value) {
            addCriterion("operate_group_id not like", value, "operateGroupId");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdIn(List<String> values) {
            addCriterion("operate_group_id in", values, "operateGroupId");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdNotIn(List<String> values) {
            addCriterion("operate_group_id not in", values, "operateGroupId");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdBetween(String value1, String value2) {
            addCriterion("operate_group_id between", value1, value2, "operateGroupId");
            return (Criteria) this;
        }

        public Criteria andOperateGroupIdNotBetween(String value1, String value2) {
            addCriterion("operate_group_id not between", value1, value2, "operateGroupId");
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

        public Criteria andExcutionStartTimeIsNull() {
            addCriterion("excution_start_time is null");
            return (Criteria) this;
        }

        public Criteria andExcutionStartTimeIsNotNull() {
            addCriterion("excution_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andExcutionStartTimeEqualTo(Date value) {
            addCriterionForJDBCTime("excution_start_time =", value, "excutionStartTime");
            return (Criteria) this;
        }

        public Criteria andExcutionStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("excution_start_time <>", value, "excutionStartTime");
            return (Criteria) this;
        }

        public Criteria andExcutionStartTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("excution_start_time >", value, "excutionStartTime");
            return (Criteria) this;
        }

        public Criteria andExcutionStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("excution_start_time >=", value, "excutionStartTime");
            return (Criteria) this;
        }

        public Criteria andExcutionStartTimeLessThan(Date value) {
            addCriterionForJDBCTime("excution_start_time <", value, "excutionStartTime");
            return (Criteria) this;
        }

        public Criteria andExcutionStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("excution_start_time <=", value, "excutionStartTime");
            return (Criteria) this;
        }

        public Criteria andExcutionStartTimeIn(List<Date> values) {
            addCriterionForJDBCTime("excution_start_time in", values, "excutionStartTime");
            return (Criteria) this;
        }

        public Criteria andExcutionStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("excution_start_time not in", values, "excutionStartTime");
            return (Criteria) this;
        }

        public Criteria andExcutionStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("excution_start_time between", value1, value2, "excutionStartTime");
            return (Criteria) this;
        }

        public Criteria andExcutionStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("excution_start_time not between", value1, value2, "excutionStartTime");
            return (Criteria) this;
        }

        public Criteria andExcutionEndTimeIsNull() {
            addCriterion("excution_end_time is null");
            return (Criteria) this;
        }

        public Criteria andExcutionEndTimeIsNotNull() {
            addCriterion("excution_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andExcutionEndTimeEqualTo(Date value) {
            addCriterionForJDBCTime("excution_end_time =", value, "excutionEndTime");
            return (Criteria) this;
        }

        public Criteria andExcutionEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("excution_end_time <>", value, "excutionEndTime");
            return (Criteria) this;
        }

        public Criteria andExcutionEndTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("excution_end_time >", value, "excutionEndTime");
            return (Criteria) this;
        }

        public Criteria andExcutionEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("excution_end_time >=", value, "excutionEndTime");
            return (Criteria) this;
        }

        public Criteria andExcutionEndTimeLessThan(Date value) {
            addCriterionForJDBCTime("excution_end_time <", value, "excutionEndTime");
            return (Criteria) this;
        }

        public Criteria andExcutionEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("excution_end_time <=", value, "excutionEndTime");
            return (Criteria) this;
        }

        public Criteria andExcutionEndTimeIn(List<Date> values) {
            addCriterionForJDBCTime("excution_end_time in", values, "excutionEndTime");
            return (Criteria) this;
        }

        public Criteria andExcutionEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("excution_end_time not in", values, "excutionEndTime");
            return (Criteria) this;
        }

        public Criteria andExcutionEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("excution_end_time between", value1, value2, "excutionEndTime");
            return (Criteria) this;
        }

        public Criteria andExcutionEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("excution_end_time not between", value1, value2, "excutionEndTime");
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