package com.face.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IgcsIgreenhouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IgcsIgreenhouseExample() {
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

        public Criteria andGreenhouseNameIsNull() {
            addCriterion("greenhouse_name is null");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNameIsNotNull() {
            addCriterion("greenhouse_name is not null");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNameEqualTo(String value) {
            addCriterion("greenhouse_name =", value, "greenhouseName");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNameNotEqualTo(String value) {
            addCriterion("greenhouse_name <>", value, "greenhouseName");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNameGreaterThan(String value) {
            addCriterion("greenhouse_name >", value, "greenhouseName");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("greenhouse_name >=", value, "greenhouseName");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNameLessThan(String value) {
            addCriterion("greenhouse_name <", value, "greenhouseName");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNameLessThanOrEqualTo(String value) {
            addCriterion("greenhouse_name <=", value, "greenhouseName");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNameLike(String value) {
            addCriterion("greenhouse_name like", value, "greenhouseName");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNameNotLike(String value) {
            addCriterion("greenhouse_name not like", value, "greenhouseName");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNameIn(List<String> values) {
            addCriterion("greenhouse_name in", values, "greenhouseName");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNameNotIn(List<String> values) {
            addCriterion("greenhouse_name not in", values, "greenhouseName");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNameBetween(String value1, String value2) {
            addCriterion("greenhouse_name between", value1, value2, "greenhouseName");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNameNotBetween(String value1, String value2) {
            addCriterion("greenhouse_name not between", value1, value2, "greenhouseName");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNull() {
            addCriterion("park_id is null");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNotNull() {
            addCriterion("park_id is not null");
            return (Criteria) this;
        }

        public Criteria andParkIdEqualTo(String value) {
            addCriterion("park_id =", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotEqualTo(String value) {
            addCriterion("park_id <>", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThan(String value) {
            addCriterion("park_id >", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThanOrEqualTo(String value) {
            addCriterion("park_id >=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThan(String value) {
            addCriterion("park_id <", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThanOrEqualTo(String value) {
            addCriterion("park_id <=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLike(String value) {
            addCriterion("park_id like", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotLike(String value) {
            addCriterion("park_id not like", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdIn(List<String> values) {
            addCriterion("park_id in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotIn(List<String> values) {
            addCriterion("park_id not in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdBetween(String value1, String value2) {
            addCriterion("park_id between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotBetween(String value1, String value2) {
            addCriterion("park_id not between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrIsNull() {
            addCriterion("greenhouse_addr is null");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrIsNotNull() {
            addCriterion("greenhouse_addr is not null");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrEqualTo(String value) {
            addCriterion("greenhouse_addr =", value, "greenhouseAddr");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrNotEqualTo(String value) {
            addCriterion("greenhouse_addr <>", value, "greenhouseAddr");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrGreaterThan(String value) {
            addCriterion("greenhouse_addr >", value, "greenhouseAddr");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrGreaterThanOrEqualTo(String value) {
            addCriterion("greenhouse_addr >=", value, "greenhouseAddr");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrLessThan(String value) {
            addCriterion("greenhouse_addr <", value, "greenhouseAddr");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrLessThanOrEqualTo(String value) {
            addCriterion("greenhouse_addr <=", value, "greenhouseAddr");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrLike(String value) {
            addCriterion("greenhouse_addr like", value, "greenhouseAddr");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrNotLike(String value) {
            addCriterion("greenhouse_addr not like", value, "greenhouseAddr");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrIn(List<String> values) {
            addCriterion("greenhouse_addr in", values, "greenhouseAddr");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrNotIn(List<String> values) {
            addCriterion("greenhouse_addr not in", values, "greenhouseAddr");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrBetween(String value1, String value2) {
            addCriterion("greenhouse_addr between", value1, value2, "greenhouseAddr");
            return (Criteria) this;
        }

        public Criteria andGreenhouseAddrNotBetween(String value1, String value2) {
            addCriterion("greenhouse_addr not between", value1, value2, "greenhouseAddr");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicIsNull() {
            addCriterion("greenhouse_pic is null");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicIsNotNull() {
            addCriterion("greenhouse_pic is not null");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicEqualTo(String value) {
            addCriterion("greenhouse_pic =", value, "greenhousePic");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicNotEqualTo(String value) {
            addCriterion("greenhouse_pic <>", value, "greenhousePic");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicGreaterThan(String value) {
            addCriterion("greenhouse_pic >", value, "greenhousePic");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicGreaterThanOrEqualTo(String value) {
            addCriterion("greenhouse_pic >=", value, "greenhousePic");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicLessThan(String value) {
            addCriterion("greenhouse_pic <", value, "greenhousePic");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicLessThanOrEqualTo(String value) {
            addCriterion("greenhouse_pic <=", value, "greenhousePic");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicLike(String value) {
            addCriterion("greenhouse_pic like", value, "greenhousePic");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicNotLike(String value) {
            addCriterion("greenhouse_pic not like", value, "greenhousePic");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicIn(List<String> values) {
            addCriterion("greenhouse_pic in", values, "greenhousePic");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicNotIn(List<String> values) {
            addCriterion("greenhouse_pic not in", values, "greenhousePic");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicBetween(String value1, String value2) {
            addCriterion("greenhouse_pic between", value1, value2, "greenhousePic");
            return (Criteria) this;
        }

        public Criteria andGreenhousePicNotBetween(String value1, String value2) {
            addCriterion("greenhouse_pic not between", value1, value2, "greenhousePic");
            return (Criteria) this;
        }

        public Criteria andGatewayIdIsNull() {
            addCriterion("gateway_id is null");
            return (Criteria) this;
        }

        public Criteria andGatewayIdIsNotNull() {
            addCriterion("gateway_id is not null");
            return (Criteria) this;
        }

        public Criteria andGatewayIdEqualTo(String value) {
            addCriterion("gateway_id =", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdNotEqualTo(String value) {
            addCriterion("gateway_id <>", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdGreaterThan(String value) {
            addCriterion("gateway_id >", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdGreaterThanOrEqualTo(String value) {
            addCriterion("gateway_id >=", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdLessThan(String value) {
            addCriterion("gateway_id <", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdLessThanOrEqualTo(String value) {
            addCriterion("gateway_id <=", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdLike(String value) {
            addCriterion("gateway_id like", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdNotLike(String value) {
            addCriterion("gateway_id not like", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdIn(List<String> values) {
            addCriterion("gateway_id in", values, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdNotIn(List<String> values) {
            addCriterion("gateway_id not in", values, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdBetween(String value1, String value2) {
            addCriterion("gateway_id between", value1, value2, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdNotBetween(String value1, String value2) {
            addCriterion("gateway_id not between", value1, value2, "gatewayId");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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