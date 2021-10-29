package com.face.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IgcsCthresholdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IgcsCthresholdExample() {
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

        public Criteria andThresholdIdIsNull() {
            addCriterion("threshold_id is null");
            return (Criteria) this;
        }

        public Criteria andThresholdIdIsNotNull() {
            addCriterion("threshold_id is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdIdEqualTo(String value) {
            addCriterion("threshold_id =", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdNotEqualTo(String value) {
            addCriterion("threshold_id <>", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdGreaterThan(String value) {
            addCriterion("threshold_id >", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdGreaterThanOrEqualTo(String value) {
            addCriterion("threshold_id >=", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdLessThan(String value) {
            addCriterion("threshold_id <", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdLessThanOrEqualTo(String value) {
            addCriterion("threshold_id <=", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdLike(String value) {
            addCriterion("threshold_id like", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdNotLike(String value) {
            addCriterion("threshold_id not like", value, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdIn(List<String> values) {
            addCriterion("threshold_id in", values, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdNotIn(List<String> values) {
            addCriterion("threshold_id not in", values, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdBetween(String value1, String value2) {
            addCriterion("threshold_id between", value1, value2, "thresholdId");
            return (Criteria) this;
        }

        public Criteria andThresholdIdNotBetween(String value1, String value2) {
            addCriterion("threshold_id not between", value1, value2, "thresholdId");
            return (Criteria) this;
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

        public Criteria andThresholdTypeCodeIsNull() {
            addCriterion("threshold_type_code is null");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeCodeIsNotNull() {
            addCriterion("threshold_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeCodeEqualTo(String value) {
            addCriterion("threshold_type_code =", value, "thresholdTypeCode");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeCodeNotEqualTo(String value) {
            addCriterion("threshold_type_code <>", value, "thresholdTypeCode");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeCodeGreaterThan(String value) {
            addCriterion("threshold_type_code >", value, "thresholdTypeCode");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("threshold_type_code >=", value, "thresholdTypeCode");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeCodeLessThan(String value) {
            addCriterion("threshold_type_code <", value, "thresholdTypeCode");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("threshold_type_code <=", value, "thresholdTypeCode");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeCodeLike(String value) {
            addCriterion("threshold_type_code like", value, "thresholdTypeCode");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeCodeNotLike(String value) {
            addCriterion("threshold_type_code not like", value, "thresholdTypeCode");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeCodeIn(List<String> values) {
            addCriterion("threshold_type_code in", values, "thresholdTypeCode");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeCodeNotIn(List<String> values) {
            addCriterion("threshold_type_code not in", values, "thresholdTypeCode");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeCodeBetween(String value1, String value2) {
            addCriterion("threshold_type_code between", value1, value2, "thresholdTypeCode");
            return (Criteria) this;
        }

        public Criteria andThresholdTypeCodeNotBetween(String value1, String value2) {
            addCriterion("threshold_type_code not between", value1, value2, "thresholdTypeCode");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterIsNull() {
            addCriterion("threshold_parameter is null");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterIsNotNull() {
            addCriterion("threshold_parameter is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterEqualTo(String value) {
            addCriterion("threshold_parameter =", value, "thresholdParameter");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterNotEqualTo(String value) {
            addCriterion("threshold_parameter <>", value, "thresholdParameter");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterGreaterThan(String value) {
            addCriterion("threshold_parameter >", value, "thresholdParameter");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterGreaterThanOrEqualTo(String value) {
            addCriterion("threshold_parameter >=", value, "thresholdParameter");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterLessThan(String value) {
            addCriterion("threshold_parameter <", value, "thresholdParameter");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterLessThanOrEqualTo(String value) {
            addCriterion("threshold_parameter <=", value, "thresholdParameter");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterLike(String value) {
            addCriterion("threshold_parameter like", value, "thresholdParameter");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterNotLike(String value) {
            addCriterion("threshold_parameter not like", value, "thresholdParameter");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterIn(List<String> values) {
            addCriterion("threshold_parameter in", values, "thresholdParameter");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterNotIn(List<String> values) {
            addCriterion("threshold_parameter not in", values, "thresholdParameter");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterBetween(String value1, String value2) {
            addCriterion("threshold_parameter between", value1, value2, "thresholdParameter");
            return (Criteria) this;
        }

        public Criteria andThresholdParameterNotBetween(String value1, String value2) {
            addCriterion("threshold_parameter not between", value1, value2, "thresholdParameter");
            return (Criteria) this;
        }

        public Criteria andComparaTypeIsNull() {
            addCriterion("compara_type is null");
            return (Criteria) this;
        }

        public Criteria andComparaTypeIsNotNull() {
            addCriterion("compara_type is not null");
            return (Criteria) this;
        }

        public Criteria andComparaTypeEqualTo(String value) {
            addCriterion("compara_type =", value, "comparaType");
            return (Criteria) this;
        }

        public Criteria andComparaTypeNotEqualTo(String value) {
            addCriterion("compara_type <>", value, "comparaType");
            return (Criteria) this;
        }

        public Criteria andComparaTypeGreaterThan(String value) {
            addCriterion("compara_type >", value, "comparaType");
            return (Criteria) this;
        }

        public Criteria andComparaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("compara_type >=", value, "comparaType");
            return (Criteria) this;
        }

        public Criteria andComparaTypeLessThan(String value) {
            addCriterion("compara_type <", value, "comparaType");
            return (Criteria) this;
        }

        public Criteria andComparaTypeLessThanOrEqualTo(String value) {
            addCriterion("compara_type <=", value, "comparaType");
            return (Criteria) this;
        }

        public Criteria andComparaTypeLike(String value) {
            addCriterion("compara_type like", value, "comparaType");
            return (Criteria) this;
        }

        public Criteria andComparaTypeNotLike(String value) {
            addCriterion("compara_type not like", value, "comparaType");
            return (Criteria) this;
        }

        public Criteria andComparaTypeIn(List<String> values) {
            addCriterion("compara_type in", values, "comparaType");
            return (Criteria) this;
        }

        public Criteria andComparaTypeNotIn(List<String> values) {
            addCriterion("compara_type not in", values, "comparaType");
            return (Criteria) this;
        }

        public Criteria andComparaTypeBetween(String value1, String value2) {
            addCriterion("compara_type between", value1, value2, "comparaType");
            return (Criteria) this;
        }

        public Criteria andComparaTypeNotBetween(String value1, String value2) {
            addCriterion("compara_type not between", value1, value2, "comparaType");
            return (Criteria) this;
        }

        public Criteria andThresholdValueIsNull() {
            addCriterion("threshold_value is null");
            return (Criteria) this;
        }

        public Criteria andThresholdValueIsNotNull() {
            addCriterion("threshold_value is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdValueEqualTo(Integer value) {
            addCriterion("threshold_value =", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueNotEqualTo(Integer value) {
            addCriterion("threshold_value <>", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueGreaterThan(Integer value) {
            addCriterion("threshold_value >", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("threshold_value >=", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueLessThan(Integer value) {
            addCriterion("threshold_value <", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueLessThanOrEqualTo(Integer value) {
            addCriterion("threshold_value <=", value, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueIn(List<Integer> values) {
            addCriterion("threshold_value in", values, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueNotIn(List<Integer> values) {
            addCriterion("threshold_value not in", values, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueBetween(Integer value1, Integer value2) {
            addCriterion("threshold_value between", value1, value2, "thresholdValue");
            return (Criteria) this;
        }

        public Criteria andThresholdValueNotBetween(Integer value1, Integer value2) {
            addCriterion("threshold_value not between", value1, value2, "thresholdValue");
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