package com.face.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IgcsBGatherWDataCExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IgcsBGatherWDataCExample() {
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

        public Criteria andGatherIdIsNull() {
            addCriterion("gather_id is null");
            return (Criteria) this;
        }

        public Criteria andGatherIdIsNotNull() {
            addCriterion("gather_id is not null");
            return (Criteria) this;
        }

        public Criteria andGatherIdEqualTo(String value) {
            addCriterion("gather_id =", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdNotEqualTo(String value) {
            addCriterion("gather_id <>", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdGreaterThan(String value) {
            addCriterion("gather_id >", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdGreaterThanOrEqualTo(String value) {
            addCriterion("gather_id >=", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdLessThan(String value) {
            addCriterion("gather_id <", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdLessThanOrEqualTo(String value) {
            addCriterion("gather_id <=", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdLike(String value) {
            addCriterion("gather_id like", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdNotLike(String value) {
            addCriterion("gather_id not like", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdIn(List<String> values) {
            addCriterion("gather_id in", values, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdNotIn(List<String> values) {
            addCriterion("gather_id not in", values, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdBetween(String value1, String value2) {
            addCriterion("gather_id between", value1, value2, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdNotBetween(String value1, String value2) {
            addCriterion("gather_id not between", value1, value2, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherTimeIsNull() {
            addCriterion("gather_time is null");
            return (Criteria) this;
        }

        public Criteria andGatherTimeIsNotNull() {
            addCriterion("gather_time is not null");
            return (Criteria) this;
        }

        public Criteria andGatherTimeEqualTo(Date value) {
            addCriterion("gather_time =", value, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeNotEqualTo(Date value) {
            addCriterion("gather_time <>", value, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeGreaterThan(Date value) {
            addCriterion("gather_time >", value, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gather_time >=", value, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeLessThan(Date value) {
            addCriterion("gather_time <", value, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeLessThanOrEqualTo(Date value) {
            addCriterion("gather_time <=", value, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeIn(List<Date> values) {
            addCriterion("gather_time in", values, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeNotIn(List<Date> values) {
            addCriterion("gather_time not in", values, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeBetween(Date value1, Date value2) {
            addCriterion("gather_time between", value1, value2, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeNotBetween(Date value1, Date value2) {
            addCriterion("gather_time not between", value1, value2, "gatherTime");
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

        public Criteria andNodeIdIsNull() {
            addCriterion("node_id is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("node_id is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(String value) {
            addCriterion("node_id =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(String value) {
            addCriterion("node_id <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(String value) {
            addCriterion("node_id >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("node_id >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(String value) {
            addCriterion("node_id <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(String value) {
            addCriterion("node_id <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLike(String value) {
            addCriterion("node_id like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotLike(String value) {
            addCriterion("node_id not like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<String> values) {
            addCriterion("node_id in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<String> values) {
            addCriterion("node_id not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(String value1, String value2) {
            addCriterion("node_id between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(String value1, String value2) {
            addCriterion("node_id not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeIsNull() {
            addCriterion("sensor_type_code is null");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeIsNotNull() {
            addCriterion("sensor_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeEqualTo(String value) {
            addCriterion("sensor_type_code =", value, "sensorTypeCode");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeNotEqualTo(String value) {
            addCriterion("sensor_type_code <>", value, "sensorTypeCode");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeGreaterThan(String value) {
            addCriterion("sensor_type_code >", value, "sensorTypeCode");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_type_code >=", value, "sensorTypeCode");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeLessThan(String value) {
            addCriterion("sensor_type_code <", value, "sensorTypeCode");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("sensor_type_code <=", value, "sensorTypeCode");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeLike(String value) {
            addCriterion("sensor_type_code like", value, "sensorTypeCode");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeNotLike(String value) {
            addCriterion("sensor_type_code not like", value, "sensorTypeCode");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeIn(List<String> values) {
            addCriterion("sensor_type_code in", values, "sensorTypeCode");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeNotIn(List<String> values) {
            addCriterion("sensor_type_code not in", values, "sensorTypeCode");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeBetween(String value1, String value2) {
            addCriterion("sensor_type_code between", value1, value2, "sensorTypeCode");
            return (Criteria) this;
        }

        public Criteria andSensorTypeCodeNotBetween(String value1, String value2) {
            addCriterion("sensor_type_code not between", value1, value2, "sensorTypeCode");
            return (Criteria) this;
        }

        public Criteria andSensorIdIsNull() {
            addCriterion("sensor_id is null");
            return (Criteria) this;
        }

        public Criteria andSensorIdIsNotNull() {
            addCriterion("sensor_id is not null");
            return (Criteria) this;
        }

        public Criteria andSensorIdEqualTo(String value) {
            addCriterion("sensor_id =", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotEqualTo(String value) {
            addCriterion("sensor_id <>", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdGreaterThan(String value) {
            addCriterion("sensor_id >", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_id >=", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLessThan(String value) {
            addCriterion("sensor_id <", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLessThanOrEqualTo(String value) {
            addCriterion("sensor_id <=", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLike(String value) {
            addCriterion("sensor_id like", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotLike(String value) {
            addCriterion("sensor_id not like", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdIn(List<String> values) {
            addCriterion("sensor_id in", values, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotIn(List<String> values) {
            addCriterion("sensor_id not in", values, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdBetween(String value1, String value2) {
            addCriterion("sensor_id between", value1, value2, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotBetween(String value1, String value2) {
            addCriterion("sensor_id not between", value1, value2, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorValueIsNull() {
            addCriterion("sensor_value is null");
            return (Criteria) this;
        }

        public Criteria andSensorValueIsNotNull() {
            addCriterion("sensor_value is not null");
            return (Criteria) this;
        }

        public Criteria andSensorValueEqualTo(Float value) {
            addCriterion("sensor_value =", value, "sensorValue");
            return (Criteria) this;
        }

        public Criteria andSensorValueNotEqualTo(Float value) {
            addCriterion("sensor_value <>", value, "sensorValue");
            return (Criteria) this;
        }

        public Criteria andSensorValueGreaterThan(Float value) {
            addCriterion("sensor_value >", value, "sensorValue");
            return (Criteria) this;
        }

        public Criteria andSensorValueGreaterThanOrEqualTo(Float value) {
            addCriterion("sensor_value >=", value, "sensorValue");
            return (Criteria) this;
        }

        public Criteria andSensorValueLessThan(Float value) {
            addCriterion("sensor_value <", value, "sensorValue");
            return (Criteria) this;
        }

        public Criteria andSensorValueLessThanOrEqualTo(Float value) {
            addCriterion("sensor_value <=", value, "sensorValue");
            return (Criteria) this;
        }

        public Criteria andSensorValueIn(List<Float> values) {
            addCriterion("sensor_value in", values, "sensorValue");
            return (Criteria) this;
        }

        public Criteria andSensorValueNotIn(List<Float> values) {
            addCriterion("sensor_value not in", values, "sensorValue");
            return (Criteria) this;
        }

        public Criteria andSensorValueBetween(Float value1, Float value2) {
            addCriterion("sensor_value between", value1, value2, "sensorValue");
            return (Criteria) this;
        }

        public Criteria andSensorValueNotBetween(Float value1, Float value2) {
            addCriterion("sensor_value not between", value1, value2, "sensorValue");
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