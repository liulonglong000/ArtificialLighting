package com.face.model;

import java.util.ArrayList;
import java.util.List;

public class IgcsArmThresholdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IgcsArmThresholdExample() {
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

        public Criteria andArmStrategyIdIsNull() {
            addCriterion("arm_strategy_id is null");
            return (Criteria) this;
        }

        public Criteria andArmStrategyIdIsNotNull() {
            addCriterion("arm_strategy_id is not null");
            return (Criteria) this;
        }

        public Criteria andArmStrategyIdEqualTo(String value) {
            addCriterion("arm_strategy_id =", value, "armStrategyId");
            return (Criteria) this;
        }

        public Criteria andArmStrategyIdNotEqualTo(String value) {
            addCriterion("arm_strategy_id <>", value, "armStrategyId");
            return (Criteria) this;
        }

        public Criteria andArmStrategyIdGreaterThan(String value) {
            addCriterion("arm_strategy_id >", value, "armStrategyId");
            return (Criteria) this;
        }

        public Criteria andArmStrategyIdGreaterThanOrEqualTo(String value) {
            addCriterion("arm_strategy_id >=", value, "armStrategyId");
            return (Criteria) this;
        }

        public Criteria andArmStrategyIdLessThan(String value) {
            addCriterion("arm_strategy_id <", value, "armStrategyId");
            return (Criteria) this;
        }

        public Criteria andArmStrategyIdLessThanOrEqualTo(String value) {
            addCriterion("arm_strategy_id <=", value, "armStrategyId");
            return (Criteria) this;
        }

        public Criteria andArmStrategyIdLike(String value) {
            addCriterion("arm_strategy_id like", value, "armStrategyId");
            return (Criteria) this;
        }

        public Criteria andArmStrategyIdNotLike(String value) {
            addCriterion("arm_strategy_id not like", value, "armStrategyId");
            return (Criteria) this;
        }

        public Criteria andArmStrategyIdIn(List<String> values) {
            addCriterion("arm_strategy_id in", values, "armStrategyId");
            return (Criteria) this;
        }

        public Criteria andArmStrategyIdNotIn(List<String> values) {
            addCriterion("arm_strategy_id not in", values, "armStrategyId");
            return (Criteria) this;
        }

        public Criteria andArmStrategyIdBetween(String value1, String value2) {
            addCriterion("arm_strategy_id between", value1, value2, "armStrategyId");
            return (Criteria) this;
        }

        public Criteria andArmStrategyIdNotBetween(String value1, String value2) {
            addCriterion("arm_strategy_id not between", value1, value2, "armStrategyId");
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

        public Criteria andThresholdIdIsNull() {
            addCriterion("threshold_id is null");
            return (Criteria) this;
        }

        public Criteria andThresholdIdIsNotNull() {
            addCriterion("threshold_id is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdIdEqualTo(Integer value) {
            addCriterion("threshold_id =", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdNotEqualTo(Integer value) {
            addCriterion("threshold_id <>", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdGreaterThan(Integer value) {
            addCriterion("threshold_id >", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("threshold_id >=", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdLessThan(Integer value) {
            addCriterion("threshold_id <", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdLessThanOrEqualTo(Integer value) {
            addCriterion("threshold_id <=", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdIn(List<Integer> values) {
            addCriterion("threshold_id in", values, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdNotIn(List<Integer> values) {
            addCriterion("threshold_id not in", values, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdBetween(Integer value1, Integer value2) {
            addCriterion("threshold_id between", value1, value2, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("threshold_id not between", value1, value2, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeIsNull() {
            addCriterion("threshold_type is null");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeIsNotNull() {
            addCriterion("threshold_type is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeEqualTo(String value) {
            addCriterion("threshold_type =", value, "thresholdType");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeNotEqualTo(String value) {
            addCriterion("threshold_type <>", value, "thresholdType");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeGreaterThan(String value) {
            addCriterion("threshold_type >", value, "thresholdType");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("threshold_type >=", value, "thresholdType");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeLessThan(String value) {
            addCriterion("threshold_type <", value, "thresholdType");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeLessThanOrEqualTo(String value) {
            addCriterion("threshold_type <=", value, "thresholdType");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeLike(String value) {
            addCriterion("threshold_type like", value, "thresholdType");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeNotLike(String value) {
            addCriterion("threshold_type not like", value, "thresholdType");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeIn(List<String> values) {
            addCriterion("threshold_type in", values, "thresholdType");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeNotIn(List<String> values) {
            addCriterion("threshold_type not in", values, "thresholdType");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeBetween(String value1, String value2) {
            addCriterion("threshold_type between", value1, value2, "thresholdType");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeNotBetween(String value1, String value2) {
            addCriterion("threshold_type not between", value1, value2, "thresholdType");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNull() {
            addCriterion("is_use is null");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNotNull() {
            addCriterion("is_use is not null");
            return (Criteria) this;
        }

        public Criteria andIsUseEqualTo(Integer value) {
            addCriterion("is_use =", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotEqualTo(Integer value) {
            addCriterion("is_use <>", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThan(Integer value) {
            addCriterion("is_use >", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_use >=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThan(Integer value) {
            addCriterion("is_use <", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThanOrEqualTo(Integer value) {
            addCriterion("is_use <=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseIn(List<Integer> values) {
            addCriterion("is_use in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotIn(List<Integer> values) {
            addCriterion("is_use not in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseBetween(Integer value1, Integer value2) {
            addCriterion("is_use between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_use not between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andStartHourIsNull() {
            addCriterion("start_hour is null");
            return (Criteria) this;
        }

        public Criteria andStartHourIsNotNull() {
            addCriterion("start_hour is not null");
            return (Criteria) this;
        }

        public Criteria andStartHourEqualTo(Integer value) {
            addCriterion("start_hour =", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourNotEqualTo(Integer value) {
            addCriterion("start_hour <>", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourGreaterThan(Integer value) {
            addCriterion("start_hour >", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_hour >=", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourLessThan(Integer value) {
            addCriterion("start_hour <", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourLessThanOrEqualTo(Integer value) {
            addCriterion("start_hour <=", value, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourIn(List<Integer> values) {
            addCriterion("start_hour in", values, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourNotIn(List<Integer> values) {
            addCriterion("start_hour not in", values, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourBetween(Integer value1, Integer value2) {
            addCriterion("start_hour between", value1, value2, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartHourNotBetween(Integer value1, Integer value2) {
            addCriterion("start_hour not between", value1, value2, "startHour");
            return (Criteria) this;
        }

        public Criteria andStartMinIsNull() {
            addCriterion("start_min is null");
            return (Criteria) this;
        }

        public Criteria andStartMinIsNotNull() {
            addCriterion("start_min is not null");
            return (Criteria) this;
        }

        public Criteria andStartMinEqualTo(Integer value) {
            addCriterion("start_min =", value, "startMin");
            return (Criteria) this;
        }

        public Criteria andStartMinNotEqualTo(Integer value) {
            addCriterion("start_min <>", value, "startMin");
            return (Criteria) this;
        }

        public Criteria andStartMinGreaterThan(Integer value) {
            addCriterion("start_min >", value, "startMin");
            return (Criteria) this;
        }

        public Criteria andStartMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_min >=", value, "startMin");
            return (Criteria) this;
        }

        public Criteria andStartMinLessThan(Integer value) {
            addCriterion("start_min <", value, "startMin");
            return (Criteria) this;
        }

        public Criteria andStartMinLessThanOrEqualTo(Integer value) {
            addCriterion("start_min <=", value, "startMin");
            return (Criteria) this;
        }

        public Criteria andStartMinIn(List<Integer> values) {
            addCriterion("start_min in", values, "startMin");
            return (Criteria) this;
        }

        public Criteria andStartMinNotIn(List<Integer> values) {
            addCriterion("start_min not in", values, "startMin");
            return (Criteria) this;
        }

        public Criteria andStartMinBetween(Integer value1, Integer value2) {
            addCriterion("start_min between", value1, value2, "startMin");
            return (Criteria) this;
        }

        public Criteria andStartMinNotBetween(Integer value1, Integer value2) {
            addCriterion("start_min not between", value1, value2, "startMin");
            return (Criteria) this;
        }

        public Criteria andEndHourIsNull() {
            addCriterion("end_hour is null");
            return (Criteria) this;
        }

        public Criteria andEndHourIsNotNull() {
            addCriterion("end_hour is not null");
            return (Criteria) this;
        }

        public Criteria andEndHourEqualTo(Integer value) {
            addCriterion("end_hour =", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourNotEqualTo(Integer value) {
            addCriterion("end_hour <>", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourGreaterThan(Integer value) {
            addCriterion("end_hour >", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_hour >=", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourLessThan(Integer value) {
            addCriterion("end_hour <", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourLessThanOrEqualTo(Integer value) {
            addCriterion("end_hour <=", value, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourIn(List<Integer> values) {
            addCriterion("end_hour in", values, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourNotIn(List<Integer> values) {
            addCriterion("end_hour not in", values, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourBetween(Integer value1, Integer value2) {
            addCriterion("end_hour between", value1, value2, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndHourNotBetween(Integer value1, Integer value2) {
            addCriterion("end_hour not between", value1, value2, "endHour");
            return (Criteria) this;
        }

        public Criteria andEndMinIsNull() {
            addCriterion("end_min is null");
            return (Criteria) this;
        }

        public Criteria andEndMinIsNotNull() {
            addCriterion("end_min is not null");
            return (Criteria) this;
        }

        public Criteria andEndMinEqualTo(Integer value) {
            addCriterion("end_min =", value, "endMin");
            return (Criteria) this;
        }

        public Criteria andEndMinNotEqualTo(Integer value) {
            addCriterion("end_min <>", value, "endMin");
            return (Criteria) this;
        }

        public Criteria andEndMinGreaterThan(Integer value) {
            addCriterion("end_min >", value, "endMin");
            return (Criteria) this;
        }

        public Criteria andEndMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_min >=", value, "endMin");
            return (Criteria) this;
        }

        public Criteria andEndMinLessThan(Integer value) {
            addCriterion("end_min <", value, "endMin");
            return (Criteria) this;
        }

        public Criteria andEndMinLessThanOrEqualTo(Integer value) {
            addCriterion("end_min <=", value, "endMin");
            return (Criteria) this;
        }

        public Criteria andEndMinIn(List<Integer> values) {
            addCriterion("end_min in", values, "endMin");
            return (Criteria) this;
        }

        public Criteria andEndMinNotIn(List<Integer> values) {
            addCriterion("end_min not in", values, "endMin");
            return (Criteria) this;
        }

        public Criteria andEndMinBetween(Integer value1, Integer value2) {
            addCriterion("end_min between", value1, value2, "endMin");
            return (Criteria) this;
        }

        public Criteria andEndMinNotBetween(Integer value1, Integer value2) {
            addCriterion("end_min not between", value1, value2, "endMin");
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

        public Criteria andCompareTypeIsNull() {
            addCriterion("compare_type is null");
            return (Criteria) this;
        }

        public Criteria andCompareTypeIsNotNull() {
            addCriterion("compare_type is not null");
            return (Criteria) this;
        }

        public Criteria andCompareTypeEqualTo(String value) {
            addCriterion("compare_type =", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeNotEqualTo(String value) {
            addCriterion("compare_type <>", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeGreaterThan(String value) {
            addCriterion("compare_type >", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeGreaterThanOrEqualTo(String value) {
            addCriterion("compare_type >=", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeLessThan(String value) {
            addCriterion("compare_type <", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeLessThanOrEqualTo(String value) {
            addCriterion("compare_type <=", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeLike(String value) {
            addCriterion("compare_type like", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeNotLike(String value) {
            addCriterion("compare_type not like", value, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeIn(List<String> values) {
            addCriterion("compare_type in", values, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeNotIn(List<String> values) {
            addCriterion("compare_type not in", values, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeBetween(String value1, String value2) {
            addCriterion("compare_type between", value1, value2, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareTypeNotBetween(String value1, String value2) {
            addCriterion("compare_type not between", value1, value2, "compareType");
            return (Criteria) this;
        }

        public Criteria andCompareParaIsNull() {
            addCriterion("compare_para is null");
            return (Criteria) this;
        }

        public Criteria andCompareParaIsNotNull() {
            addCriterion("compare_para is not null");
            return (Criteria) this;
        }

        public Criteria andCompareParaEqualTo(Integer value) {
            addCriterion("compare_para =", value, "comparePara");
            return (Criteria) this;
        }

        public Criteria andCompareParaNotEqualTo(Integer value) {
            addCriterion("compare_para <>", value, "comparePara");
            return (Criteria) this;
        }

        public Criteria andCompareParaGreaterThan(Integer value) {
            addCriterion("compare_para >", value, "comparePara");
            return (Criteria) this;
        }

        public Criteria andCompareParaGreaterThanOrEqualTo(Integer value) {
            addCriterion("compare_para >=", value, "comparePara");
            return (Criteria) this;
        }

        public Criteria andCompareParaLessThan(Integer value) {
            addCriterion("compare_para <", value, "comparePara");
            return (Criteria) this;
        }

        public Criteria andCompareParaLessThanOrEqualTo(Integer value) {
            addCriterion("compare_para <=", value, "comparePara");
            return (Criteria) this;
        }

        public Criteria andCompareParaIn(List<Integer> values) {
            addCriterion("compare_para in", values, "comparePara");
            return (Criteria) this;
        }

        public Criteria andCompareParaNotIn(List<Integer> values) {
            addCriterion("compare_para not in", values, "comparePara");
            return (Criteria) this;
        }

        public Criteria andCompareParaBetween(Integer value1, Integer value2) {
            addCriterion("compare_para between", value1, value2, "comparePara");
            return (Criteria) this;
        }

        public Criteria andCompareParaNotBetween(Integer value1, Integer value2) {
            addCriterion("compare_para not between", value1, value2, "comparePara");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeIsNull() {
            addCriterion("equipment_type is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeIsNotNull() {
            addCriterion("equipment_type is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeEqualTo(String value) {
            addCriterion("equipment_type =", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotEqualTo(String value) {
            addCriterion("equipment_type <>", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeGreaterThan(String value) {
            addCriterion("equipment_type >", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_type >=", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLessThan(String value) {
            addCriterion("equipment_type <", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLessThanOrEqualTo(String value) {
            addCriterion("equipment_type <=", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLike(String value) {
            addCriterion("equipment_type like", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotLike(String value) {
            addCriterion("equipment_type not like", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeIn(List<String> values) {
            addCriterion("equipment_type in", values, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotIn(List<String> values) {
            addCriterion("equipment_type not in", values, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeBetween(String value1, String value2) {
            addCriterion("equipment_type between", value1, value2, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotBetween(String value1, String value2) {
            addCriterion("equipment_type not between", value1, value2, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNull() {
            addCriterion("equipment_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNotNull() {
            addCriterion("equipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdEqualTo(String value) {
            addCriterion("equipment_id =", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotEqualTo(String value) {
            addCriterion("equipment_id <>", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThan(String value) {
            addCriterion("equipment_id >", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_id >=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThan(String value) {
            addCriterion("equipment_id <", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThanOrEqualTo(String value) {
            addCriterion("equipment_id <=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLike(String value) {
            addCriterion("equipment_id like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotLike(String value) {
            addCriterion("equipment_id not like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIn(List<String> values) {
            addCriterion("equipment_id in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotIn(List<String> values) {
            addCriterion("equipment_id not in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdBetween(String value1, String value2) {
            addCriterion("equipment_id between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotBetween(String value1, String value2) {
            addCriterion("equipment_id not between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNull() {
            addCriterion("operate_type is null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNotNull() {
            addCriterion("operate_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeEqualTo(String value) {
            addCriterion("operate_type =", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotEqualTo(String value) {
            addCriterion("operate_type <>", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThan(String value) {
            addCriterion("operate_type >", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("operate_type >=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThan(String value) {
            addCriterion("operate_type <", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThanOrEqualTo(String value) {
            addCriterion("operate_type <=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLike(String value) {
            addCriterion("operate_type like", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotLike(String value) {
            addCriterion("operate_type not like", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIn(List<String> values) {
            addCriterion("operate_type in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotIn(List<String> values) {
            addCriterion("operate_type not in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeBetween(String value1, String value2) {
            addCriterion("operate_type between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotBetween(String value1, String value2) {
            addCriterion("operate_type not between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateParaIsNull() {
            addCriterion("operate_para is null");
            return (Criteria) this;
        }

        public Criteria andOperateParaIsNotNull() {
            addCriterion("operate_para is not null");
            return (Criteria) this;
        }

        public Criteria andOperateParaEqualTo(Integer value) {
            addCriterion("operate_para =", value, "operatePara");
            return (Criteria) this;
        }

        public Criteria andOperateParaNotEqualTo(Integer value) {
            addCriterion("operate_para <>", value, "operatePara");
            return (Criteria) this;
        }

        public Criteria andOperateParaGreaterThan(Integer value) {
            addCriterion("operate_para >", value, "operatePara");
            return (Criteria) this;
        }

        public Criteria andOperateParaGreaterThanOrEqualTo(Integer value) {
            addCriterion("operate_para >=", value, "operatePara");
            return (Criteria) this;
        }

        public Criteria andOperateParaLessThan(Integer value) {
            addCriterion("operate_para <", value, "operatePara");
            return (Criteria) this;
        }

        public Criteria andOperateParaLessThanOrEqualTo(Integer value) {
            addCriterion("operate_para <=", value, "operatePara");
            return (Criteria) this;
        }

        public Criteria andOperateParaIn(List<Integer> values) {
            addCriterion("operate_para in", values, "operatePara");
            return (Criteria) this;
        }

        public Criteria andOperateParaNotIn(List<Integer> values) {
            addCriterion("operate_para not in", values, "operatePara");
            return (Criteria) this;
        }

        public Criteria andOperateParaBetween(Integer value1, Integer value2) {
            addCriterion("operate_para between", value1, value2, "operatePara");
            return (Criteria) this;
        }

        public Criteria andOperateParaNotBetween(Integer value1, Integer value2) {
            addCriterion("operate_para not between", value1, value2, "operatePara");
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