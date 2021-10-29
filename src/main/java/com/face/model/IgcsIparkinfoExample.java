package com.face.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IgcsIparkinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IgcsIparkinfoExample() {
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

        public Criteria andParkNameIsNull() {
            addCriterion("park_name is null");
            return (Criteria) this;
        }

        public Criteria andParkNameIsNotNull() {
            addCriterion("park_name is not null");
            return (Criteria) this;
        }

        public Criteria andParkNameEqualTo(String value) {
            addCriterion("park_name =", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameNotEqualTo(String value) {
            addCriterion("park_name <>", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameGreaterThan(String value) {
            addCriterion("park_name >", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameGreaterThanOrEqualTo(String value) {
            addCriterion("park_name >=", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameLessThan(String value) {
            addCriterion("park_name <", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameLessThanOrEqualTo(String value) {
            addCriterion("park_name <=", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameLike(String value) {
            addCriterion("park_name like", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameNotLike(String value) {
            addCriterion("park_name not like", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameIn(List<String> values) {
            addCriterion("park_name in", values, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameNotIn(List<String> values) {
            addCriterion("park_name not in", values, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameBetween(String value1, String value2) {
            addCriterion("park_name between", value1, value2, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameNotBetween(String value1, String value2) {
            addCriterion("park_name not between", value1, value2, "parkName");
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

        public Criteria andParkAddrIsNull() {
            addCriterion("park_addr is null");
            return (Criteria) this;
        }

        public Criteria andParkAddrIsNotNull() {
            addCriterion("park_addr is not null");
            return (Criteria) this;
        }

        public Criteria andParkAddrEqualTo(String value) {
            addCriterion("park_addr =", value, "parkAddr");
            return (Criteria) this;
        }

        public Criteria andParkAddrNotEqualTo(String value) {
            addCriterion("park_addr <>", value, "parkAddr");
            return (Criteria) this;
        }

        public Criteria andParkAddrGreaterThan(String value) {
            addCriterion("park_addr >", value, "parkAddr");
            return (Criteria) this;
        }

        public Criteria andParkAddrGreaterThanOrEqualTo(String value) {
            addCriterion("park_addr >=", value, "parkAddr");
            return (Criteria) this;
        }

        public Criteria andParkAddrLessThan(String value) {
            addCriterion("park_addr <", value, "parkAddr");
            return (Criteria) this;
        }

        public Criteria andParkAddrLessThanOrEqualTo(String value) {
            addCriterion("park_addr <=", value, "parkAddr");
            return (Criteria) this;
        }

        public Criteria andParkAddrLike(String value) {
            addCriterion("park_addr like", value, "parkAddr");
            return (Criteria) this;
        }

        public Criteria andParkAddrNotLike(String value) {
            addCriterion("park_addr not like", value, "parkAddr");
            return (Criteria) this;
        }

        public Criteria andParkAddrIn(List<String> values) {
            addCriterion("park_addr in", values, "parkAddr");
            return (Criteria) this;
        }

        public Criteria andParkAddrNotIn(List<String> values) {
            addCriterion("park_addr not in", values, "parkAddr");
            return (Criteria) this;
        }

        public Criteria andParkAddrBetween(String value1, String value2) {
            addCriterion("park_addr between", value1, value2, "parkAddr");
            return (Criteria) this;
        }

        public Criteria andParkAddrNotBetween(String value1, String value2) {
            addCriterion("park_addr not between", value1, value2, "parkAddr");
            return (Criteria) this;
        }

        public Criteria andParkPicIsNull() {
            addCriterion("park_pic is null");
            return (Criteria) this;
        }

        public Criteria andParkPicIsNotNull() {
            addCriterion("park_pic is not null");
            return (Criteria) this;
        }

        public Criteria andParkPicEqualTo(String value) {
            addCriterion("park_pic =", value, "parkPic");
            return (Criteria) this;
        }

        public Criteria andParkPicNotEqualTo(String value) {
            addCriterion("park_pic <>", value, "parkPic");
            return (Criteria) this;
        }

        public Criteria andParkPicGreaterThan(String value) {
            addCriterion("park_pic >", value, "parkPic");
            return (Criteria) this;
        }

        public Criteria andParkPicGreaterThanOrEqualTo(String value) {
            addCriterion("park_pic >=", value, "parkPic");
            return (Criteria) this;
        }

        public Criteria andParkPicLessThan(String value) {
            addCriterion("park_pic <", value, "parkPic");
            return (Criteria) this;
        }

        public Criteria andParkPicLessThanOrEqualTo(String value) {
            addCriterion("park_pic <=", value, "parkPic");
            return (Criteria) this;
        }

        public Criteria andParkPicLike(String value) {
            addCriterion("park_pic like", value, "parkPic");
            return (Criteria) this;
        }

        public Criteria andParkPicNotLike(String value) {
            addCriterion("park_pic not like", value, "parkPic");
            return (Criteria) this;
        }

        public Criteria andParkPicIn(List<String> values) {
            addCriterion("park_pic in", values, "parkPic");
            return (Criteria) this;
        }

        public Criteria andParkPicNotIn(List<String> values) {
            addCriterion("park_pic not in", values, "parkPic");
            return (Criteria) this;
        }

        public Criteria andParkPicBetween(String value1, String value2) {
            addCriterion("park_pic between", value1, value2, "parkPic");
            return (Criteria) this;
        }

        public Criteria andParkPicNotBetween(String value1, String value2) {
            addCriterion("park_pic not between", value1, value2, "parkPic");
            return (Criteria) this;
        }

        public Criteria andParkAreaIsNull() {
            addCriterion("park_area is null");
            return (Criteria) this;
        }

        public Criteria andParkAreaIsNotNull() {
            addCriterion("park_area is not null");
            return (Criteria) this;
        }

        public Criteria andParkAreaEqualTo(Integer value) {
            addCriterion("park_area =", value, "parkArea");
            return (Criteria) this;
        }

        public Criteria andParkAreaNotEqualTo(Integer value) {
            addCriterion("park_area <>", value, "parkArea");
            return (Criteria) this;
        }

        public Criteria andParkAreaGreaterThan(Integer value) {
            addCriterion("park_area >", value, "parkArea");
            return (Criteria) this;
        }

        public Criteria andParkAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("park_area >=", value, "parkArea");
            return (Criteria) this;
        }

        public Criteria andParkAreaLessThan(Integer value) {
            addCriterion("park_area <", value, "parkArea");
            return (Criteria) this;
        }

        public Criteria andParkAreaLessThanOrEqualTo(Integer value) {
            addCriterion("park_area <=", value, "parkArea");
            return (Criteria) this;
        }

        public Criteria andParkAreaIn(List<Integer> values) {
            addCriterion("park_area in", values, "parkArea");
            return (Criteria) this;
        }

        public Criteria andParkAreaNotIn(List<Integer> values) {
            addCriterion("park_area not in", values, "parkArea");
            return (Criteria) this;
        }

        public Criteria andParkAreaBetween(Integer value1, Integer value2) {
            addCriterion("park_area between", value1, value2, "parkArea");
            return (Criteria) this;
        }

        public Criteria andParkAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("park_area not between", value1, value2, "parkArea");
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