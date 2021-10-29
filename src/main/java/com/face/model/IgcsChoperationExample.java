package com.face.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IgcsChoperationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IgcsChoperationExample() {
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

        public Criteria andOperateIdIsNull() {
            addCriterion("operate_id is null");
            return (Criteria) this;
        }

        public Criteria andOperateIdIsNotNull() {
            addCriterion("operate_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperateIdEqualTo(String value) {
            addCriterion("operate_id =", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotEqualTo(String value) {
            addCriterion("operate_id <>", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdGreaterThan(String value) {
            addCriterion("operate_id >", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdGreaterThanOrEqualTo(String value) {
            addCriterion("operate_id >=", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLessThan(String value) {
            addCriterion("operate_id <", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLessThanOrEqualTo(String value) {
            addCriterion("operate_id <=", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLike(String value) {
            addCriterion("operate_id like", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotLike(String value) {
            addCriterion("operate_id not like", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdIn(List<String> values) {
            addCriterion("operate_id in", values, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotIn(List<String> values) {
            addCriterion("operate_id not in", values, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdBetween(String value1, String value2) {
            addCriterion("operate_id between", value1, value2, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotBetween(String value1, String value2) {
            addCriterion("operate_id not between", value1, value2, "operateId");
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