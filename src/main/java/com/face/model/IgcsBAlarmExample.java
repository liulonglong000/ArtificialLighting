package com.face.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IgcsBAlarmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IgcsBAlarmExample() {
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

        public Criteria andAlarmLogIdIsNull() {
            addCriterion("alarm_log_id is null");
            return (Criteria) this;
        }

        public Criteria andAlarmLogIdIsNotNull() {
            addCriterion("alarm_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmLogIdEqualTo(String value) {
            addCriterion("alarm_log_id =", value, "alarmLogId");
            return (Criteria) this;
        }

        public Criteria andAlarmLogIdNotEqualTo(String value) {
            addCriterion("alarm_log_id <>", value, "alarmLogId");
            return (Criteria) this;
        }

        public Criteria andAlarmLogIdGreaterThan(String value) {
            addCriterion("alarm_log_id >", value, "alarmLogId");
            return (Criteria) this;
        }

        public Criteria andAlarmLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_log_id >=", value, "alarmLogId");
            return (Criteria) this;
        }

        public Criteria andAlarmLogIdLessThan(String value) {
            addCriterion("alarm_log_id <", value, "alarmLogId");
            return (Criteria) this;
        }

        public Criteria andAlarmLogIdLessThanOrEqualTo(String value) {
            addCriterion("alarm_log_id <=", value, "alarmLogId");
            return (Criteria) this;
        }

        public Criteria andAlarmLogIdLike(String value) {
            addCriterion("alarm_log_id like", value, "alarmLogId");
            return (Criteria) this;
        }

        public Criteria andAlarmLogIdNotLike(String value) {
            addCriterion("alarm_log_id not like", value, "alarmLogId");
            return (Criteria) this;
        }

        public Criteria andAlarmLogIdIn(List<String> values) {
            addCriterion("alarm_log_id in", values, "alarmLogId");
            return (Criteria) this;
        }

        public Criteria andAlarmLogIdNotIn(List<String> values) {
            addCriterion("alarm_log_id not in", values, "alarmLogId");
            return (Criteria) this;
        }

        public Criteria andAlarmLogIdBetween(String value1, String value2) {
            addCriterion("alarm_log_id between", value1, value2, "alarmLogId");
            return (Criteria) this;
        }

        public Criteria andAlarmLogIdNotBetween(String value1, String value2) {
            addCriterion("alarm_log_id not between", value1, value2, "alarmLogId");
            return (Criteria) this;
        }

        public Criteria andTradeIdIsNull() {
            addCriterion("trade_id is null");
            return (Criteria) this;
        }

        public Criteria andTradeIdIsNotNull() {
            addCriterion("trade_id is not null");
            return (Criteria) this;
        }

        public Criteria andTradeIdEqualTo(String value) {
            addCriterion("trade_id =", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdNotEqualTo(String value) {
            addCriterion("trade_id <>", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdGreaterThan(String value) {
            addCriterion("trade_id >", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdGreaterThanOrEqualTo(String value) {
            addCriterion("trade_id >=", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdLessThan(String value) {
            addCriterion("trade_id <", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdLessThanOrEqualTo(String value) {
            addCriterion("trade_id <=", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdLike(String value) {
            addCriterion("trade_id like", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdNotLike(String value) {
            addCriterion("trade_id not like", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdIn(List<String> values) {
            addCriterion("trade_id in", values, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdNotIn(List<String> values) {
            addCriterion("trade_id not in", values, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdBetween(String value1, String value2) {
            addCriterion("trade_id between", value1, value2, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdNotBetween(String value1, String value2) {
            addCriterion("trade_id not between", value1, value2, "tradeId");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageIsNull() {
            addCriterion("alarm_message is null");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageIsNotNull() {
            addCriterion("alarm_message is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageEqualTo(String value) {
            addCriterion("alarm_message =", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageNotEqualTo(String value) {
            addCriterion("alarm_message <>", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageGreaterThan(String value) {
            addCriterion("alarm_message >", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_message >=", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageLessThan(String value) {
            addCriterion("alarm_message <", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageLessThanOrEqualTo(String value) {
            addCriterion("alarm_message <=", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageLike(String value) {
            addCriterion("alarm_message like", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageNotLike(String value) {
            addCriterion("alarm_message not like", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageIn(List<String> values) {
            addCriterion("alarm_message in", values, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageNotIn(List<String> values) {
            addCriterion("alarm_message not in", values, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageBetween(String value1, String value2) {
            addCriterion("alarm_message between", value1, value2, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageNotBetween(String value1, String value2) {
            addCriterion("alarm_message not between", value1, value2, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNull() {
            addCriterion("insert_time is null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNotNull() {
            addCriterion("insert_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeEqualTo(Date value) {
            addCriterion("insert_time =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Date value) {
            addCriterion("insert_time <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Date value) {
            addCriterion("insert_time >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("insert_time >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Date value) {
            addCriterion("insert_time <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
            addCriterion("insert_time <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Date> values) {
            addCriterion("insert_time in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Date> values) {
            addCriterion("insert_time not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Date value1, Date value2) {
            addCriterion("insert_time between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
            addCriterion("insert_time not between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdIsNull() {
            addCriterion("insert_user_id is null");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdIsNotNull() {
            addCriterion("insert_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdEqualTo(String value) {
            addCriterion("insert_user_id =", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdNotEqualTo(String value) {
            addCriterion("insert_user_id <>", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdGreaterThan(String value) {
            addCriterion("insert_user_id >", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("insert_user_id >=", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdLessThan(String value) {
            addCriterion("insert_user_id <", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdLessThanOrEqualTo(String value) {
            addCriterion("insert_user_id <=", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdLike(String value) {
            addCriterion("insert_user_id like", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdNotLike(String value) {
            addCriterion("insert_user_id not like", value, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdIn(List<String> values) {
            addCriterion("insert_user_id in", values, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdNotIn(List<String> values) {
            addCriterion("insert_user_id not in", values, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdBetween(String value1, String value2) {
            addCriterion("insert_user_id between", value1, value2, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andInsertUserIdNotBetween(String value1, String value2) {
            addCriterion("insert_user_id not between", value1, value2, "insertUserId");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdIsNull() {
            addCriterion("recv_user_id is null");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdIsNotNull() {
            addCriterion("recv_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdEqualTo(String value) {
            addCriterion("recv_user_id =", value, "recvUserId");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdNotEqualTo(String value) {
            addCriterion("recv_user_id <>", value, "recvUserId");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdGreaterThan(String value) {
            addCriterion("recv_user_id >", value, "recvUserId");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("recv_user_id >=", value, "recvUserId");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdLessThan(String value) {
            addCriterion("recv_user_id <", value, "recvUserId");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdLessThanOrEqualTo(String value) {
            addCriterion("recv_user_id <=", value, "recvUserId");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdLike(String value) {
            addCriterion("recv_user_id like", value, "recvUserId");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdNotLike(String value) {
            addCriterion("recv_user_id not like", value, "recvUserId");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdIn(List<String> values) {
            addCriterion("recv_user_id in", values, "recvUserId");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdNotIn(List<String> values) {
            addCriterion("recv_user_id not in", values, "recvUserId");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdBetween(String value1, String value2) {
            addCriterion("recv_user_id between", value1, value2, "recvUserId");
            return (Criteria) this;
        }

        public Criteria andRecvUserIdNotBetween(String value1, String value2) {
            addCriterion("recv_user_id not between", value1, value2, "recvUserId");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNull() {
            addCriterion("is_read is null");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNotNull() {
            addCriterion("is_read is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadEqualTo(String value) {
            addCriterion("is_read =", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotEqualTo(String value) {
            addCriterion("is_read <>", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThan(String value) {
            addCriterion("is_read >", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThanOrEqualTo(String value) {
            addCriterion("is_read >=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThan(String value) {
            addCriterion("is_read <", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThanOrEqualTo(String value) {
            addCriterion("is_read <=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLike(String value) {
            addCriterion("is_read like", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotLike(String value) {
            addCriterion("is_read not like", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadIn(List<String> values) {
            addCriterion("is_read in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotIn(List<String> values) {
            addCriterion("is_read not in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadBetween(String value1, String value2) {
            addCriterion("is_read between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotBetween(String value1, String value2) {
            addCriterion("is_read not between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andReadTimeIsNull() {
            addCriterion("read_time is null");
            return (Criteria) this;
        }

        public Criteria andReadTimeIsNotNull() {
            addCriterion("read_time is not null");
            return (Criteria) this;
        }

        public Criteria andReadTimeEqualTo(Date value) {
            addCriterion("read_time =", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotEqualTo(Date value) {
            addCriterion("read_time <>", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeGreaterThan(Date value) {
            addCriterion("read_time >", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("read_time >=", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeLessThan(Date value) {
            addCriterion("read_time <", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeLessThanOrEqualTo(Date value) {
            addCriterion("read_time <=", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeIn(List<Date> values) {
            addCriterion("read_time in", values, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotIn(List<Date> values) {
            addCriterion("read_time not in", values, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeBetween(Date value1, Date value2) {
            addCriterion("read_time between", value1, value2, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotBetween(Date value1, Date value2) {
            addCriterion("read_time not between", value1, value2, "readTime");
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