package com.face.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SessionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_session
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_session
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_session
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_session
     *
     * @mbg.generated
     */
    public SessionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_session
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_session
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_session
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_session
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_session
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_session
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_session
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_session
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_session
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_session
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_session
     *
     * @mbg.generated
     */
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

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Integer value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Integer value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Integer value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Integer value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Integer value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Integer> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Integer> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Integer value1, Integer value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andLastActiveTimeIsNull() {
            addCriterion("last_active_time is null");
            return (Criteria) this;
        }

        public Criteria andLastActiveTimeIsNotNull() {
            addCriterion("last_active_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastActiveTimeEqualTo(Date value) {
            addCriterion("last_active_time =", value, "lastActiveTime");
            return (Criteria) this;
        }

        public Criteria andLastActiveTimeNotEqualTo(Date value) {
            addCriterion("last_active_time <>", value, "lastActiveTime");
            return (Criteria) this;
        }

        public Criteria andLastActiveTimeGreaterThan(Date value) {
            addCriterion("last_active_time >", value, "lastActiveTime");
            return (Criteria) this;
        }

        public Criteria andLastActiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_active_time >=", value, "lastActiveTime");
            return (Criteria) this;
        }

        public Criteria andLastActiveTimeLessThan(Date value) {
            addCriterion("last_active_time <", value, "lastActiveTime");
            return (Criteria) this;
        }

        public Criteria andLastActiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_active_time <=", value, "lastActiveTime");
            return (Criteria) this;
        }

        public Criteria andLastActiveTimeIn(List<Date> values) {
            addCriterion("last_active_time in", values, "lastActiveTime");
            return (Criteria) this;
        }

        public Criteria andLastActiveTimeNotIn(List<Date> values) {
            addCriterion("last_active_time not in", values, "lastActiveTime");
            return (Criteria) this;
        }

        public Criteria andLastActiveTimeBetween(Date value1, Date value2) {
            addCriterion("last_active_time between", value1, value2, "lastActiveTime");
            return (Criteria) this;
        }

        public Criteria andLastActiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_active_time not between", value1, value2, "lastActiveTime");
            return (Criteria) this;
        }

        public Criteria andLastCaptureTimeIsNull() {
            addCriterion("last_capture_time is null");
            return (Criteria) this;
        }

        public Criteria andLastCaptureTimeIsNotNull() {
            addCriterion("last_capture_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastCaptureTimeEqualTo(Date value) {
            addCriterion("last_capture_time =", value, "lastCaptureTime");
            return (Criteria) this;
        }

        public Criteria andLastCaptureTimeNotEqualTo(Date value) {
            addCriterion("last_capture_time <>", value, "lastCaptureTime");
            return (Criteria) this;
        }

        public Criteria andLastCaptureTimeGreaterThan(Date value) {
            addCriterion("last_capture_time >", value, "lastCaptureTime");
            return (Criteria) this;
        }

        public Criteria andLastCaptureTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_capture_time >=", value, "lastCaptureTime");
            return (Criteria) this;
        }

        public Criteria andLastCaptureTimeLessThan(Date value) {
            addCriterion("last_capture_time <", value, "lastCaptureTime");
            return (Criteria) this;
        }

        public Criteria andLastCaptureTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_capture_time <=", value, "lastCaptureTime");
            return (Criteria) this;
        }

        public Criteria andLastCaptureTimeIn(List<Date> values) {
            addCriterion("last_capture_time in", values, "lastCaptureTime");
            return (Criteria) this;
        }

        public Criteria andLastCaptureTimeNotIn(List<Date> values) {
            addCriterion("last_capture_time not in", values, "lastCaptureTime");
            return (Criteria) this;
        }

        public Criteria andLastCaptureTimeBetween(Date value1, Date value2) {
            addCriterion("last_capture_time between", value1, value2, "lastCaptureTime");
            return (Criteria) this;
        }

        public Criteria andLastCaptureTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_capture_time not between", value1, value2, "lastCaptureTime");
            return (Criteria) this;
        }

        public Criteria andLastAlarmTimeIsNull() {
            addCriterion("last_alarm_time is null");
            return (Criteria) this;
        }

        public Criteria andLastAlarmTimeIsNotNull() {
            addCriterion("last_alarm_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastAlarmTimeEqualTo(Date value) {
            addCriterion("last_alarm_time =", value, "lastAlarmTime");
            return (Criteria) this;
        }

        public Criteria andLastAlarmTimeNotEqualTo(Date value) {
            addCriterion("last_alarm_time <>", value, "lastAlarmTime");
            return (Criteria) this;
        }

        public Criteria andLastAlarmTimeGreaterThan(Date value) {
            addCriterion("last_alarm_time >", value, "lastAlarmTime");
            return (Criteria) this;
        }

        public Criteria andLastAlarmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_alarm_time >=", value, "lastAlarmTime");
            return (Criteria) this;
        }

        public Criteria andLastAlarmTimeLessThan(Date value) {
            addCriterion("last_alarm_time <", value, "lastAlarmTime");
            return (Criteria) this;
        }

        public Criteria andLastAlarmTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_alarm_time <=", value, "lastAlarmTime");
            return (Criteria) this;
        }

        public Criteria andLastAlarmTimeIn(List<Date> values) {
            addCriterion("last_alarm_time in", values, "lastAlarmTime");
            return (Criteria) this;
        }

        public Criteria andLastAlarmTimeNotIn(List<Date> values) {
            addCriterion("last_alarm_time not in", values, "lastAlarmTime");
            return (Criteria) this;
        }

        public Criteria andLastAlarmTimeBetween(Date value1, Date value2) {
            addCriterion("last_alarm_time between", value1, value2, "lastAlarmTime");
            return (Criteria) this;
        }

        public Criteria andLastAlarmTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_alarm_time not between", value1, value2, "lastAlarmTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_session
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_session
     *
     * @mbg.generated
     */
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