package com.face.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IgcsASensorTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IgcsASensorTypeExample() {
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

        public Criteria andSensorTypeNameIsNull() {
            addCriterion("sensor_type_name is null");
            return (Criteria) this;
        }

        public Criteria andSensorTypeNameIsNotNull() {
            addCriterion("sensor_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andSensorTypeNameEqualTo(String value) {
            addCriterion("sensor_type_name =", value, "sensorTypeName");
            return (Criteria) this;
        }

        public Criteria andSensorTypeNameNotEqualTo(String value) {
            addCriterion("sensor_type_name <>", value, "sensorTypeName");
            return (Criteria) this;
        }

        public Criteria andSensorTypeNameGreaterThan(String value) {
            addCriterion("sensor_type_name >", value, "sensorTypeName");
            return (Criteria) this;
        }

        public Criteria andSensorTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_type_name >=", value, "sensorTypeName");
            return (Criteria) this;
        }

        public Criteria andSensorTypeNameLessThan(String value) {
            addCriterion("sensor_type_name <", value, "sensorTypeName");
            return (Criteria) this;
        }

        public Criteria andSensorTypeNameLessThanOrEqualTo(String value) {
            addCriterion("sensor_type_name <=", value, "sensorTypeName");
            return (Criteria) this;
        }

        public Criteria andSensorTypeNameLike(String value) {
            addCriterion("sensor_type_name like", value, "sensorTypeName");
            return (Criteria) this;
        }

        public Criteria andSensorTypeNameNotLike(String value) {
            addCriterion("sensor_type_name not like", value, "sensorTypeName");
            return (Criteria) this;
        }

        public Criteria andSensorTypeNameIn(List<String> values) {
            addCriterion("sensor_type_name in", values, "sensorTypeName");
            return (Criteria) this;
        }

        public Criteria andSensorTypeNameNotIn(List<String> values) {
            addCriterion("sensor_type_name not in", values, "sensorTypeName");
            return (Criteria) this;
        }

        public Criteria andSensorTypeNameBetween(String value1, String value2) {
            addCriterion("sensor_type_name between", value1, value2, "sensorTypeName");
            return (Criteria) this;
        }

        public Criteria andSensorTypeNameNotBetween(String value1, String value2) {
            addCriterion("sensor_type_name not between", value1, value2, "sensorTypeName");
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andSensorUnitIsNull() {
            addCriterion("sensor_unit is null");
            return (Criteria) this;
        }

        public Criteria andSensorUnitIsNotNull() {
            addCriterion("sensor_unit is not null");
            return (Criteria) this;
        }

        public Criteria andSensorUnitEqualTo(String value) {
            addCriterion("sensor_unit =", value, "sensorUnit");
            return (Criteria) this;
        }

        public Criteria andSensorUnitNotEqualTo(String value) {
            addCriterion("sensor_unit <>", value, "sensorUnit");
            return (Criteria) this;
        }

        public Criteria andSensorUnitGreaterThan(String value) {
            addCriterion("sensor_unit >", value, "sensorUnit");
            return (Criteria) this;
        }

        public Criteria andSensorUnitGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_unit >=", value, "sensorUnit");
            return (Criteria) this;
        }

        public Criteria andSensorUnitLessThan(String value) {
            addCriterion("sensor_unit <", value, "sensorUnit");
            return (Criteria) this;
        }

        public Criteria andSensorUnitLessThanOrEqualTo(String value) {
            addCriterion("sensor_unit <=", value, "sensorUnit");
            return (Criteria) this;
        }

        public Criteria andSensorUnitLike(String value) {
            addCriterion("sensor_unit like", value, "sensorUnit");
            return (Criteria) this;
        }

        public Criteria andSensorUnitNotLike(String value) {
            addCriterion("sensor_unit not like", value, "sensorUnit");
            return (Criteria) this;
        }

        public Criteria andSensorUnitIn(List<String> values) {
            addCriterion("sensor_unit in", values, "sensorUnit");
            return (Criteria) this;
        }

        public Criteria andSensorUnitNotIn(List<String> values) {
            addCriterion("sensor_unit not in", values, "sensorUnit");
            return (Criteria) this;
        }

        public Criteria andSensorUnitBetween(String value1, String value2) {
            addCriterion("sensor_unit between", value1, value2, "sensorUnit");
            return (Criteria) this;
        }

        public Criteria andSensorUnitNotBetween(String value1, String value2) {
            addCriterion("sensor_unit not between", value1, value2, "sensorUnit");
            return (Criteria) this;
        }

        public Criteria andArmSensorTypeIdIsNull() {
            addCriterion("arm_sensor_type_id is null");
            return (Criteria) this;
        }

        public Criteria andArmSensorTypeIdIsNotNull() {
            addCriterion("arm_sensor_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andArmSensorTypeIdEqualTo(Integer value) {
            addCriterion("arm_sensor_type_id =", value, "armSensorTypeId");
            return (Criteria) this;
        }

        public Criteria andArmSensorTypeIdNotEqualTo(Integer value) {
            addCriterion("arm_sensor_type_id <>", value, "armSensorTypeId");
            return (Criteria) this;
        }

        public Criteria andArmSensorTypeIdGreaterThan(Integer value) {
            addCriterion("arm_sensor_type_id >", value, "armSensorTypeId");
            return (Criteria) this;
        }

        public Criteria andArmSensorTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("arm_sensor_type_id >=", value, "armSensorTypeId");
            return (Criteria) this;
        }

        public Criteria andArmSensorTypeIdLessThan(Integer value) {
            addCriterion("arm_sensor_type_id <", value, "armSensorTypeId");
            return (Criteria) this;
        }

        public Criteria andArmSensorTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("arm_sensor_type_id <=", value, "armSensorTypeId");
            return (Criteria) this;
        }

        public Criteria andArmSensorTypeIdIn(List<Integer> values) {
            addCriterion("arm_sensor_type_id in", values, "armSensorTypeId");
            return (Criteria) this;
        }

        public Criteria andArmSensorTypeIdNotIn(List<Integer> values) {
            addCriterion("arm_sensor_type_id not in", values, "armSensorTypeId");
            return (Criteria) this;
        }

        public Criteria andArmSensorTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("arm_sensor_type_id between", value1, value2, "armSensorTypeId");
            return (Criteria) this;
        }

        public Criteria andArmSensorTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("arm_sensor_type_id not between", value1, value2, "armSensorTypeId");
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