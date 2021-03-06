package com.xdj.www.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingHomeAddentionExample extends BaseEntity{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShoppingHomeAddentionExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addTime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addTime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addTime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addTime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addTime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addTime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addTime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addTime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addTime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addTime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addTime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andDeletestatusIsNull() {
            addCriterion("deleteStatus is null");
            return (Criteria) this;
        }

        public Criteria andDeletestatusIsNotNull() {
            addCriterion("deleteStatus is not null");
            return (Criteria) this;
        }

        public Criteria andDeletestatusEqualTo(Boolean value) {
            addCriterion("deleteStatus =", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusNotEqualTo(Boolean value) {
            addCriterion("deleteStatus <>", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusGreaterThan(Boolean value) {
            addCriterion("deleteStatus >", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleteStatus >=", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusLessThan(Boolean value) {
            addCriterion("deleteStatus <", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusLessThanOrEqualTo(Boolean value) {
            addCriterion("deleteStatus <=", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusIn(List<Boolean> values) {
            addCriterion("deleteStatus in", values, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusNotIn(List<Boolean> values) {
            addCriterion("deleteStatus not in", values, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusBetween(Boolean value1, Boolean value2) {
            addCriterion("deleteStatus between", value1, value2, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleteStatus not between", value1, value2, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andAttentionHomepageIdIsNull() {
            addCriterion("attention_homepage_id is null");
            return (Criteria) this;
        }

        public Criteria andAttentionHomepageIdIsNotNull() {
            addCriterion("attention_homepage_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionHomepageIdEqualTo(Long value) {
            addCriterion("attention_homepage_id =", value, "attentionHomepageId");
            return (Criteria) this;
        }

        public Criteria andAttentionHomepageIdNotEqualTo(Long value) {
            addCriterion("attention_homepage_id <>", value, "attentionHomepageId");
            return (Criteria) this;
        }

        public Criteria andAttentionHomepageIdGreaterThan(Long value) {
            addCriterion("attention_homepage_id >", value, "attentionHomepageId");
            return (Criteria) this;
        }

        public Criteria andAttentionHomepageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("attention_homepage_id >=", value, "attentionHomepageId");
            return (Criteria) this;
        }

        public Criteria andAttentionHomepageIdLessThan(Long value) {
            addCriterion("attention_homepage_id <", value, "attentionHomepageId");
            return (Criteria) this;
        }

        public Criteria andAttentionHomepageIdLessThanOrEqualTo(Long value) {
            addCriterion("attention_homepage_id <=", value, "attentionHomepageId");
            return (Criteria) this;
        }

        public Criteria andAttentionHomepageIdIn(List<Long> values) {
            addCriterion("attention_homepage_id in", values, "attentionHomepageId");
            return (Criteria) this;
        }

        public Criteria andAttentionHomepageIdNotIn(List<Long> values) {
            addCriterion("attention_homepage_id not in", values, "attentionHomepageId");
            return (Criteria) this;
        }

        public Criteria andAttentionHomepageIdBetween(Long value1, Long value2) {
            addCriterion("attention_homepage_id between", value1, value2, "attentionHomepageId");
            return (Criteria) this;
        }

        public Criteria andAttentionHomepageIdNotBetween(Long value1, Long value2) {
            addCriterion("attention_homepage_id not between", value1, value2, "attentionHomepageId");
            return (Criteria) this;
        }

        public Criteria andAttentionedIdIsNull() {
            addCriterion("attentioned_id is null");
            return (Criteria) this;
        }

        public Criteria andAttentionedIdIsNotNull() {
            addCriterion("attentioned_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionedIdEqualTo(Long value) {
            addCriterion("attentioned_id =", value, "attentionedId");
            return (Criteria) this;
        }

        public Criteria andAttentionedIdNotEqualTo(Long value) {
            addCriterion("attentioned_id <>", value, "attentionedId");
            return (Criteria) this;
        }

        public Criteria andAttentionedIdGreaterThan(Long value) {
            addCriterion("attentioned_id >", value, "attentionedId");
            return (Criteria) this;
        }

        public Criteria andAttentionedIdGreaterThanOrEqualTo(Long value) {
            addCriterion("attentioned_id >=", value, "attentionedId");
            return (Criteria) this;
        }

        public Criteria andAttentionedIdLessThan(Long value) {
            addCriterion("attentioned_id <", value, "attentionedId");
            return (Criteria) this;
        }

        public Criteria andAttentionedIdLessThanOrEqualTo(Long value) {
            addCriterion("attentioned_id <=", value, "attentionedId");
            return (Criteria) this;
        }

        public Criteria andAttentionedIdIn(List<Long> values) {
            addCriterion("attentioned_id in", values, "attentionedId");
            return (Criteria) this;
        }

        public Criteria andAttentionedIdNotIn(List<Long> values) {
            addCriterion("attentioned_id not in", values, "attentionedId");
            return (Criteria) this;
        }

        public Criteria andAttentionedIdBetween(Long value1, Long value2) {
            addCriterion("attentioned_id between", value1, value2, "attentionedId");
            return (Criteria) this;
        }

        public Criteria andAttentionedIdNotBetween(Long value1, Long value2) {
            addCriterion("attentioned_id not between", value1, value2, "attentionedId");
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