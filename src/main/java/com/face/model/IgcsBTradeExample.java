package com.face.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IgcsBTradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IgcsBTradeExample() {
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

        public Criteria andEquipmentTypeCodeIsNull() {
            addCriterion("equipment_type_code is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeCodeIsNotNull() {
            addCriterion("equipment_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeCodeEqualTo(String value) {
            addCriterion("equipment_type_code =", value, "equipmentTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeCodeNotEqualTo(String value) {
            addCriterion("equipment_type_code <>", value, "equipmentTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeCodeGreaterThan(String value) {
            addCriterion("equipment_type_code >", value, "equipmentTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_type_code >=", value, "equipmentTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeCodeLessThan(String value) {
            addCriterion("equipment_type_code <", value, "equipmentTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("equipment_type_code <=", value, "equipmentTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeCodeLike(String value) {
            addCriterion("equipment_type_code like", value, "equipmentTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeCodeNotLike(String value) {
            addCriterion("equipment_type_code not like", value, "equipmentTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeCodeIn(List<String> values) {
            addCriterion("equipment_type_code in", values, "equipmentTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeCodeNotIn(List<String> values) {
            addCriterion("equipment_type_code not in", values, "equipmentTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeCodeBetween(String value1, String value2) {
            addCriterion("equipment_type_code between", value1, value2, "equipmentTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeCodeNotBetween(String value1, String value2) {
            addCriterion("equipment_type_code not between", value1, value2, "equipmentTypeCode");
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

        public Criteria andControlTypeIsNull() {
            addCriterion("control_type is null");
            return (Criteria) this;
        }

        public Criteria andControlTypeIsNotNull() {
            addCriterion("control_type is not null");
            return (Criteria) this;
        }

        public Criteria andControlTypeEqualTo(String value) {
            addCriterion("control_type =", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotEqualTo(String value) {
            addCriterion("control_type <>", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeGreaterThan(String value) {
            addCriterion("control_type >", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("control_type >=", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeLessThan(String value) {
            addCriterion("control_type <", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeLessThanOrEqualTo(String value) {
            addCriterion("control_type <=", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeLike(String value) {
            addCriterion("control_type like", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotLike(String value) {
            addCriterion("control_type not like", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeIn(List<String> values) {
            addCriterion("control_type in", values, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotIn(List<String> values) {
            addCriterion("control_type not in", values, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeBetween(String value1, String value2) {
            addCriterion("control_type between", value1, value2, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotBetween(String value1, String value2) {
            addCriterion("control_type not between", value1, value2, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlParameter1IsNull() {
            addCriterion("control_parameter1 is null");
            return (Criteria) this;
        }

        public Criteria andControlParameter1IsNotNull() {
            addCriterion("control_parameter1 is not null");
            return (Criteria) this;
        }

        public Criteria andControlParameter1EqualTo(String value) {
            addCriterion("control_parameter1 =", value, "controlParameter1");
            return (Criteria) this;
        }

        public Criteria andControlParameter1NotEqualTo(String value) {
            addCriterion("control_parameter1 <>", value, "controlParameter1");
            return (Criteria) this;
        }

        public Criteria andControlParameter1GreaterThan(String value) {
            addCriterion("control_parameter1 >", value, "controlParameter1");
            return (Criteria) this;
        }

        public Criteria andControlParameter1GreaterThanOrEqualTo(String value) {
            addCriterion("control_parameter1 >=", value, "controlParameter1");
            return (Criteria) this;
        }

        public Criteria andControlParameter1LessThan(String value) {
            addCriterion("control_parameter1 <", value, "controlParameter1");
            return (Criteria) this;
        }

        public Criteria andControlParameter1LessThanOrEqualTo(String value) {
            addCriterion("control_parameter1 <=", value, "controlParameter1");
            return (Criteria) this;
        }

        public Criteria andControlParameter1Like(String value) {
            addCriterion("control_parameter1 like", value, "controlParameter1");
            return (Criteria) this;
        }

        public Criteria andControlParameter1NotLike(String value) {
            addCriterion("control_parameter1 not like", value, "controlParameter1");
            return (Criteria) this;
        }

        public Criteria andControlParameter1In(List<String> values) {
            addCriterion("control_parameter1 in", values, "controlParameter1");
            return (Criteria) this;
        }

        public Criteria andControlParameter1NotIn(List<String> values) {
            addCriterion("control_parameter1 not in", values, "controlParameter1");
            return (Criteria) this;
        }

        public Criteria andControlParameter1Between(String value1, String value2) {
            addCriterion("control_parameter1 between", value1, value2, "controlParameter1");
            return (Criteria) this;
        }

        public Criteria andControlParameter1NotBetween(String value1, String value2) {
            addCriterion("control_parameter1 not between", value1, value2, "controlParameter1");
            return (Criteria) this;
        }

        public Criteria andControlParameter2IsNull() {
            addCriterion("control_parameter2 is null");
            return (Criteria) this;
        }

        public Criteria andControlParameter2IsNotNull() {
            addCriterion("control_parameter2 is not null");
            return (Criteria) this;
        }

        public Criteria andControlParameter2EqualTo(String value) {
            addCriterion("control_parameter2 =", value, "controlParameter2");
            return (Criteria) this;
        }

        public Criteria andControlParameter2NotEqualTo(String value) {
            addCriterion("control_parameter2 <>", value, "controlParameter2");
            return (Criteria) this;
        }

        public Criteria andControlParameter2GreaterThan(String value) {
            addCriterion("control_parameter2 >", value, "controlParameter2");
            return (Criteria) this;
        }

        public Criteria andControlParameter2GreaterThanOrEqualTo(String value) {
            addCriterion("control_parameter2 >=", value, "controlParameter2");
            return (Criteria) this;
        }

        public Criteria andControlParameter2LessThan(String value) {
            addCriterion("control_parameter2 <", value, "controlParameter2");
            return (Criteria) this;
        }

        public Criteria andControlParameter2LessThanOrEqualTo(String value) {
            addCriterion("control_parameter2 <=", value, "controlParameter2");
            return (Criteria) this;
        }

        public Criteria andControlParameter2Like(String value) {
            addCriterion("control_parameter2 like", value, "controlParameter2");
            return (Criteria) this;
        }

        public Criteria andControlParameter2NotLike(String value) {
            addCriterion("control_parameter2 not like", value, "controlParameter2");
            return (Criteria) this;
        }

        public Criteria andControlParameter2In(List<String> values) {
            addCriterion("control_parameter2 in", values, "controlParameter2");
            return (Criteria) this;
        }

        public Criteria andControlParameter2NotIn(List<String> values) {
            addCriterion("control_parameter2 not in", values, "controlParameter2");
            return (Criteria) this;
        }

        public Criteria andControlParameter2Between(String value1, String value2) {
            addCriterion("control_parameter2 between", value1, value2, "controlParameter2");
            return (Criteria) this;
        }

        public Criteria andControlParameter2NotBetween(String value1, String value2) {
            addCriterion("control_parameter2 not between", value1, value2, "controlParameter2");
            return (Criteria) this;
        }

        public Criteria andControlParameter3IsNull() {
            addCriterion("control_parameter3 is null");
            return (Criteria) this;
        }

        public Criteria andControlParameter3IsNotNull() {
            addCriterion("control_parameter3 is not null");
            return (Criteria) this;
        }

        public Criteria andControlParameter3EqualTo(String value) {
            addCriterion("control_parameter3 =", value, "controlParameter3");
            return (Criteria) this;
        }

        public Criteria andControlParameter3NotEqualTo(String value) {
            addCriterion("control_parameter3 <>", value, "controlParameter3");
            return (Criteria) this;
        }

        public Criteria andControlParameter3GreaterThan(String value) {
            addCriterion("control_parameter3 >", value, "controlParameter3");
            return (Criteria) this;
        }

        public Criteria andControlParameter3GreaterThanOrEqualTo(String value) {
            addCriterion("control_parameter3 >=", value, "controlParameter3");
            return (Criteria) this;
        }

        public Criteria andControlParameter3LessThan(String value) {
            addCriterion("control_parameter3 <", value, "controlParameter3");
            return (Criteria) this;
        }

        public Criteria andControlParameter3LessThanOrEqualTo(String value) {
            addCriterion("control_parameter3 <=", value, "controlParameter3");
            return (Criteria) this;
        }

        public Criteria andControlParameter3Like(String value) {
            addCriterion("control_parameter3 like", value, "controlParameter3");
            return (Criteria) this;
        }

        public Criteria andControlParameter3NotLike(String value) {
            addCriterion("control_parameter3 not like", value, "controlParameter3");
            return (Criteria) this;
        }

        public Criteria andControlParameter3In(List<String> values) {
            addCriterion("control_parameter3 in", values, "controlParameter3");
            return (Criteria) this;
        }

        public Criteria andControlParameter3NotIn(List<String> values) {
            addCriterion("control_parameter3 not in", values, "controlParameter3");
            return (Criteria) this;
        }

        public Criteria andControlParameter3Between(String value1, String value2) {
            addCriterion("control_parameter3 between", value1, value2, "controlParameter3");
            return (Criteria) this;
        }

        public Criteria andControlParameter3NotBetween(String value1, String value2) {
            addCriterion("control_parameter3 not between", value1, value2, "controlParameter3");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andInsertWayIsNull() {
            addCriterion("insert_way is null");
            return (Criteria) this;
        }

        public Criteria andInsertWayIsNotNull() {
            addCriterion("insert_way is not null");
            return (Criteria) this;
        }

        public Criteria andInsertWayEqualTo(String value) {
            addCriterion("insert_way =", value, "insertWay");
            return (Criteria) this;
        }

        public Criteria andInsertWayNotEqualTo(String value) {
            addCriterion("insert_way <>", value, "insertWay");
            return (Criteria) this;
        }

        public Criteria andInsertWayGreaterThan(String value) {
            addCriterion("insert_way >", value, "insertWay");
            return (Criteria) this;
        }

        public Criteria andInsertWayGreaterThanOrEqualTo(String value) {
            addCriterion("insert_way >=", value, "insertWay");
            return (Criteria) this;
        }

        public Criteria andInsertWayLessThan(String value) {
            addCriterion("insert_way <", value, "insertWay");
            return (Criteria) this;
        }

        public Criteria andInsertWayLessThanOrEqualTo(String value) {
            addCriterion("insert_way <=", value, "insertWay");
            return (Criteria) this;
        }

        public Criteria andInsertWayLike(String value) {
            addCriterion("insert_way like", value, "insertWay");
            return (Criteria) this;
        }

        public Criteria andInsertWayNotLike(String value) {
            addCriterion("insert_way not like", value, "insertWay");
            return (Criteria) this;
        }

        public Criteria andInsertWayIn(List<String> values) {
            addCriterion("insert_way in", values, "insertWay");
            return (Criteria) this;
        }

        public Criteria andInsertWayNotIn(List<String> values) {
            addCriterion("insert_way not in", values, "insertWay");
            return (Criteria) this;
        }

        public Criteria andInsertWayBetween(String value1, String value2) {
            addCriterion("insert_way between", value1, value2, "insertWay");
            return (Criteria) this;
        }

        public Criteria andInsertWayNotBetween(String value1, String value2) {
            addCriterion("insert_way not between", value1, value2, "insertWay");
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

        public Criteria andPreDealTimeIsNull() {
            addCriterion("pre_deal_time is null");
            return (Criteria) this;
        }

        public Criteria andPreDealTimeIsNotNull() {
            addCriterion("pre_deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andPreDealTimeEqualTo(Date value) {
            addCriterion("pre_deal_time =", value, "preDealTime");
            return (Criteria) this;
        }

        public Criteria andPreDealTimeNotEqualTo(Date value) {
            addCriterion("pre_deal_time <>", value, "preDealTime");
            return (Criteria) this;
        }

        public Criteria andPreDealTimeGreaterThan(Date value) {
            addCriterion("pre_deal_time >", value, "preDealTime");
            return (Criteria) this;
        }

        public Criteria andPreDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pre_deal_time >=", value, "preDealTime");
            return (Criteria) this;
        }

        public Criteria andPreDealTimeLessThan(Date value) {
            addCriterion("pre_deal_time <", value, "preDealTime");
            return (Criteria) this;
        }

        public Criteria andPreDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("pre_deal_time <=", value, "preDealTime");
            return (Criteria) this;
        }

        public Criteria andPreDealTimeIn(List<Date> values) {
            addCriterion("pre_deal_time in", values, "preDealTime");
            return (Criteria) this;
        }

        public Criteria andPreDealTimeNotIn(List<Date> values) {
            addCriterion("pre_deal_time not in", values, "preDealTime");
            return (Criteria) this;
        }

        public Criteria andPreDealTimeBetween(Date value1, Date value2) {
            addCriterion("pre_deal_time between", value1, value2, "preDealTime");
            return (Criteria) this;
        }

        public Criteria andPreDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("pre_deal_time not between", value1, value2, "preDealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterion("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterion("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterion("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterion("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Date> values) {
            addCriterion("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Date> values) {
            addCriterion("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterion("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealCountIsNull() {
            addCriterion("deal_count is null");
            return (Criteria) this;
        }

        public Criteria andDealCountIsNotNull() {
            addCriterion("deal_count is not null");
            return (Criteria) this;
        }

        public Criteria andDealCountEqualTo(Integer value) {
            addCriterion("deal_count =", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountNotEqualTo(Integer value) {
            addCriterion("deal_count <>", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountGreaterThan(Integer value) {
            addCriterion("deal_count >", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_count >=", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountLessThan(Integer value) {
            addCriterion("deal_count <", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountLessThanOrEqualTo(Integer value) {
            addCriterion("deal_count <=", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountIn(List<Integer> values) {
            addCriterion("deal_count in", values, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountNotIn(List<Integer> values) {
            addCriterion("deal_count not in", values, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountBetween(Integer value1, Integer value2) {
            addCriterion("deal_count between", value1, value2, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_count not between", value1, value2, "dealCount");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andIsDealIsNull() {
            addCriterion("is_deal is null");
            return (Criteria) this;
        }

        public Criteria andIsDealIsNotNull() {
            addCriterion("is_deal is not null");
            return (Criteria) this;
        }

        public Criteria andIsDealEqualTo(String value) {
            addCriterion("is_deal =", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotEqualTo(String value) {
            addCriterion("is_deal <>", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThan(String value) {
            addCriterion("is_deal >", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThanOrEqualTo(String value) {
            addCriterion("is_deal >=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThan(String value) {
            addCriterion("is_deal <", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThanOrEqualTo(String value) {
            addCriterion("is_deal <=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLike(String value) {
            addCriterion("is_deal like", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotLike(String value) {
            addCriterion("is_deal not like", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealIn(List<String> values) {
            addCriterion("is_deal in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotIn(List<String> values) {
            addCriterion("is_deal not in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealBetween(String value1, String value2) {
            addCriterion("is_deal between", value1, value2, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotBetween(String value1, String value2) {
            addCriterion("is_deal not between", value1, value2, "isDeal");
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