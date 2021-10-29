package com.face.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IgcsIEquipmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IgcsIEquipmentExample() {
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusParaIsNull() {
            addCriterion("status_para is null");
            return (Criteria) this;
        }

        public Criteria andStatusParaIsNotNull() {
            addCriterion("status_para is not null");
            return (Criteria) this;
        }

        public Criteria andStatusParaEqualTo(Integer value) {
            addCriterion("status_para =", value, "statusPara");
            return (Criteria) this;
        }

        public Criteria andStatusParaNotEqualTo(Integer value) {
            addCriterion("status_para <>", value, "statusPara");
            return (Criteria) this;
        }

        public Criteria andStatusParaGreaterThan(Integer value) {
            addCriterion("status_para >", value, "statusPara");
            return (Criteria) this;
        }

        public Criteria andStatusParaGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_para >=", value, "statusPara");
            return (Criteria) this;
        }

        public Criteria andStatusParaLessThan(Integer value) {
            addCriterion("status_para <", value, "statusPara");
            return (Criteria) this;
        }

        public Criteria andStatusParaLessThanOrEqualTo(Integer value) {
            addCriterion("status_para <=", value, "statusPara");
            return (Criteria) this;
        }

        public Criteria andStatusParaIn(List<Integer> values) {
            addCriterion("status_para in", values, "statusPara");
            return (Criteria) this;
        }

        public Criteria andStatusParaNotIn(List<Integer> values) {
            addCriterion("status_para not in", values, "statusPara");
            return (Criteria) this;
        }

        public Criteria andStatusParaBetween(Integer value1, Integer value2) {
            addCriterion("status_para between", value1, value2, "statusPara");
            return (Criteria) this;
        }

        public Criteria andStatusParaNotBetween(Integer value1, Integer value2) {
            addCriterion("status_para not between", value1, value2, "statusPara");
            return (Criteria) this;
        }

        public Criteria andParameterIsNull() {
            addCriterion("parameter is null");
            return (Criteria) this;
        }

        public Criteria andParameterIsNotNull() {
            addCriterion("parameter is not null");
            return (Criteria) this;
        }

        public Criteria andParameterEqualTo(Integer value) {
            addCriterion("parameter =", value, "parameter");
            return (Criteria) this;
        }

        public Criteria andParameterNotEqualTo(Integer value) {
            addCriterion("parameter <>", value, "parameter");
            return (Criteria) this;
        }

        public Criteria andParameterGreaterThan(Integer value) {
            addCriterion("parameter >", value, "parameter");
            return (Criteria) this;
        }

        public Criteria andParameterGreaterThanOrEqualTo(Integer value) {
            addCriterion("parameter >=", value, "parameter");
            return (Criteria) this;
        }

        public Criteria andParameterLessThan(Integer value) {
            addCriterion("parameter <", value, "parameter");
            return (Criteria) this;
        }

        public Criteria andParameterLessThanOrEqualTo(Integer value) {
            addCriterion("parameter <=", value, "parameter");
            return (Criteria) this;
        }

        public Criteria andParameterIn(List<Integer> values) {
            addCriterion("parameter in", values, "parameter");
            return (Criteria) this;
        }

        public Criteria andParameterNotIn(List<Integer> values) {
            addCriterion("parameter not in", values, "parameter");
            return (Criteria) this;
        }

        public Criteria andParameterBetween(Integer value1, Integer value2) {
            addCriterion("parameter between", value1, value2, "parameter");
            return (Criteria) this;
        }

        public Criteria andParameterNotBetween(Integer value1, Integer value2) {
            addCriterion("parameter not between", value1, value2, "parameter");
            return (Criteria) this;
        }

        public Criteria andLocateIsNull() {
            addCriterion("locate is null");
            return (Criteria) this;
        }

        public Criteria andLocateIsNotNull() {
            addCriterion("locate is not null");
            return (Criteria) this;
        }

        public Criteria andLocateEqualTo(Float value) {
            addCriterion("locate =", value, "locate");
            return (Criteria) this;
        }

        public Criteria andLocateNotEqualTo(Float value) {
            addCriterion("locate <>", value, "locate");
            return (Criteria) this;
        }

        public Criteria andLocateGreaterThan(Float value) {
            addCriterion("locate >", value, "locate");
            return (Criteria) this;
        }

        public Criteria andLocateGreaterThanOrEqualTo(Float value) {
            addCriterion("locate >=", value, "locate");
            return (Criteria) this;
        }

        public Criteria andLocateLessThan(Float value) {
            addCriterion("locate <", value, "locate");
            return (Criteria) this;
        }

        public Criteria andLocateLessThanOrEqualTo(Float value) {
            addCriterion("locate <=", value, "locate");
            return (Criteria) this;
        }

        public Criteria andLocateIn(List<Float> values) {
            addCriterion("locate in", values, "locate");
            return (Criteria) this;
        }

        public Criteria andLocateNotIn(List<Float> values) {
            addCriterion("locate not in", values, "locate");
            return (Criteria) this;
        }

        public Criteria andLocateBetween(Float value1, Float value2) {
            addCriterion("locate between", value1, value2, "locate");
            return (Criteria) this;
        }

        public Criteria andLocateNotBetween(Float value1, Float value2) {
            addCriterion("locate not between", value1, value2, "locate");
            return (Criteria) this;
        }

        public Criteria andPara1IsNull() {
            addCriterion("para_1 is null");
            return (Criteria) this;
        }

        public Criteria andPara1IsNotNull() {
            addCriterion("para_1 is not null");
            return (Criteria) this;
        }

        public Criteria andPara1EqualTo(Integer value) {
            addCriterion("para_1 =", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1NotEqualTo(Integer value) {
            addCriterion("para_1 <>", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1GreaterThan(Integer value) {
            addCriterion("para_1 >", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1GreaterThanOrEqualTo(Integer value) {
            addCriterion("para_1 >=", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1LessThan(Integer value) {
            addCriterion("para_1 <", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1LessThanOrEqualTo(Integer value) {
            addCriterion("para_1 <=", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1In(List<Integer> values) {
            addCriterion("para_1 in", values, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1NotIn(List<Integer> values) {
            addCriterion("para_1 not in", values, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1Between(Integer value1, Integer value2) {
            addCriterion("para_1 between", value1, value2, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1NotBetween(Integer value1, Integer value2) {
            addCriterion("para_1 not between", value1, value2, "para1");
            return (Criteria) this;
        }

        public Criteria andPara2IsNull() {
            addCriterion("para_2 is null");
            return (Criteria) this;
        }

        public Criteria andPara2IsNotNull() {
            addCriterion("para_2 is not null");
            return (Criteria) this;
        }

        public Criteria andPara2EqualTo(Integer value) {
            addCriterion("para_2 =", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2NotEqualTo(Integer value) {
            addCriterion("para_2 <>", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2GreaterThan(Integer value) {
            addCriterion("para_2 >", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2GreaterThanOrEqualTo(Integer value) {
            addCriterion("para_2 >=", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2LessThan(Integer value) {
            addCriterion("para_2 <", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2LessThanOrEqualTo(Integer value) {
            addCriterion("para_2 <=", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2In(List<Integer> values) {
            addCriterion("para_2 in", values, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2NotIn(List<Integer> values) {
            addCriterion("para_2 not in", values, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2Between(Integer value1, Integer value2) {
            addCriterion("para_2 between", value1, value2, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2NotBetween(Integer value1, Integer value2) {
            addCriterion("para_2 not between", value1, value2, "para2");
            return (Criteria) this;
        }

        public Criteria andPara3IsNull() {
            addCriterion("para_3 is null");
            return (Criteria) this;
        }

        public Criteria andPara3IsNotNull() {
            addCriterion("para_3 is not null");
            return (Criteria) this;
        }

        public Criteria andPara3EqualTo(Integer value) {
            addCriterion("para_3 =", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3NotEqualTo(Integer value) {
            addCriterion("para_3 <>", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3GreaterThan(Integer value) {
            addCriterion("para_3 >", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3GreaterThanOrEqualTo(Integer value) {
            addCriterion("para_3 >=", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3LessThan(Integer value) {
            addCriterion("para_3 <", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3LessThanOrEqualTo(Integer value) {
            addCriterion("para_3 <=", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3In(List<Integer> values) {
            addCriterion("para_3 in", values, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3NotIn(List<Integer> values) {
            addCriterion("para_3 not in", values, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3Between(Integer value1, Integer value2) {
            addCriterion("para_3 between", value1, value2, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3NotBetween(Integer value1, Integer value2) {
            addCriterion("para_3 not between", value1, value2, "para3");
            return (Criteria) this;
        }

        public Criteria andLastConnectTimeIsNull() {
            addCriterion("last_connect_time is null");
            return (Criteria) this;
        }

        public Criteria andLastConnectTimeIsNotNull() {
            addCriterion("last_connect_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastConnectTimeEqualTo(Date value) {
            addCriterion("last_connect_time =", value, "lastConnectTime");
            return (Criteria) this;
        }

        public Criteria andLastConnectTimeNotEqualTo(Date value) {
            addCriterion("last_connect_time <>", value, "lastConnectTime");
            return (Criteria) this;
        }

        public Criteria andLastConnectTimeGreaterThan(Date value) {
            addCriterion("last_connect_time >", value, "lastConnectTime");
            return (Criteria) this;
        }

        public Criteria andLastConnectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_connect_time >=", value, "lastConnectTime");
            return (Criteria) this;
        }

        public Criteria andLastConnectTimeLessThan(Date value) {
            addCriterion("last_connect_time <", value, "lastConnectTime");
            return (Criteria) this;
        }

        public Criteria andLastConnectTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_connect_time <=", value, "lastConnectTime");
            return (Criteria) this;
        }

        public Criteria andLastConnectTimeIn(List<Date> values) {
            addCriterion("last_connect_time in", values, "lastConnectTime");
            return (Criteria) this;
        }

        public Criteria andLastConnectTimeNotIn(List<Date> values) {
            addCriterion("last_connect_time not in", values, "lastConnectTime");
            return (Criteria) this;
        }

        public Criteria andLastConnectTimeBetween(Date value1, Date value2) {
            addCriterion("last_connect_time between", value1, value2, "lastConnectTime");
            return (Criteria) this;
        }

        public Criteria andLastConnectTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_connect_time not between", value1, value2, "lastConnectTime");
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