package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingRefundLogExample extends BaseEntity{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShoppingRefundLogExample() {
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

        public Criteria andRefundIsNull() {
            addCriterion("refund is null");
            return (Criteria) this;
        }

        public Criteria andRefundIsNotNull() {
            addCriterion("refund is not null");
            return (Criteria) this;
        }

        public Criteria andRefundEqualTo(BigDecimal value) {
            addCriterion("refund =", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotEqualTo(BigDecimal value) {
            addCriterion("refund <>", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundGreaterThan(BigDecimal value) {
            addCriterion("refund >", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund >=", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundLessThan(BigDecimal value) {
            addCriterion("refund <", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund <=", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundIn(List<BigDecimal> values) {
            addCriterion("refund in", values, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotIn(List<BigDecimal> values) {
            addCriterion("refund not in", values, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund between", value1, value2, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund not between", value1, value2, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNull() {
            addCriterion("refund_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNotNull() {
            addCriterion("refund_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundIdEqualTo(String value) {
            addCriterion("refund_id =", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotEqualTo(String value) {
            addCriterion("refund_id <>", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThan(String value) {
            addCriterion("refund_id >", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThanOrEqualTo(String value) {
            addCriterion("refund_id >=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThan(String value) {
            addCriterion("refund_id <", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThanOrEqualTo(String value) {
            addCriterion("refund_id <=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLike(String value) {
            addCriterion("refund_id like", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotLike(String value) {
            addCriterion("refund_id not like", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdIn(List<String> values) {
            addCriterion("refund_id in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotIn(List<String> values) {
            addCriterion("refund_id not in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdBetween(String value1, String value2) {
            addCriterion("refund_id between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotBetween(String value1, String value2) {
            addCriterion("refund_id not between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundLogIsNull() {
            addCriterion("refund_log is null");
            return (Criteria) this;
        }

        public Criteria andRefundLogIsNotNull() {
            addCriterion("refund_log is not null");
            return (Criteria) this;
        }

        public Criteria andRefundLogEqualTo(String value) {
            addCriterion("refund_log =", value, "refundLog");
            return (Criteria) this;
        }

        public Criteria andRefundLogNotEqualTo(String value) {
            addCriterion("refund_log <>", value, "refundLog");
            return (Criteria) this;
        }

        public Criteria andRefundLogGreaterThan(String value) {
            addCriterion("refund_log >", value, "refundLog");
            return (Criteria) this;
        }

        public Criteria andRefundLogGreaterThanOrEqualTo(String value) {
            addCriterion("refund_log >=", value, "refundLog");
            return (Criteria) this;
        }

        public Criteria andRefundLogLessThan(String value) {
            addCriterion("refund_log <", value, "refundLog");
            return (Criteria) this;
        }

        public Criteria andRefundLogLessThanOrEqualTo(String value) {
            addCriterion("refund_log <=", value, "refundLog");
            return (Criteria) this;
        }

        public Criteria andRefundLogLike(String value) {
            addCriterion("refund_log like", value, "refundLog");
            return (Criteria) this;
        }

        public Criteria andRefundLogNotLike(String value) {
            addCriterion("refund_log not like", value, "refundLog");
            return (Criteria) this;
        }

        public Criteria andRefundLogIn(List<String> values) {
            addCriterion("refund_log in", values, "refundLog");
            return (Criteria) this;
        }

        public Criteria andRefundLogNotIn(List<String> values) {
            addCriterion("refund_log not in", values, "refundLog");
            return (Criteria) this;
        }

        public Criteria andRefundLogBetween(String value1, String value2) {
            addCriterion("refund_log between", value1, value2, "refundLog");
            return (Criteria) this;
        }

        public Criteria andRefundLogNotBetween(String value1, String value2) {
            addCriterion("refund_log not between", value1, value2, "refundLog");
            return (Criteria) this;
        }

        public Criteria andRefundTypeIsNull() {
            addCriterion("refund_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundTypeIsNotNull() {
            addCriterion("refund_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTypeEqualTo(String value) {
            addCriterion("refund_type =", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeNotEqualTo(String value) {
            addCriterion("refund_type <>", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeGreaterThan(String value) {
            addCriterion("refund_type >", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_type >=", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeLessThan(String value) {
            addCriterion("refund_type <", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeLessThanOrEqualTo(String value) {
            addCriterion("refund_type <=", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeLike(String value) {
            addCriterion("refund_type like", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeNotLike(String value) {
            addCriterion("refund_type not like", value, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeIn(List<String> values) {
            addCriterion("refund_type in", values, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeNotIn(List<String> values) {
            addCriterion("refund_type not in", values, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeBetween(String value1, String value2) {
            addCriterion("refund_type between", value1, value2, "refundType");
            return (Criteria) this;
        }

        public Criteria andRefundTypeNotBetween(String value1, String value2) {
            addCriterion("refund_type not between", value1, value2, "refundType");
            return (Criteria) this;
        }

        public Criteria andOfIdIsNull() {
            addCriterion("of_id is null");
            return (Criteria) this;
        }

        public Criteria andOfIdIsNotNull() {
            addCriterion("of_id is not null");
            return (Criteria) this;
        }

        public Criteria andOfIdEqualTo(Long value) {
            addCriterion("of_id =", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdNotEqualTo(Long value) {
            addCriterion("of_id <>", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdGreaterThan(Long value) {
            addCriterion("of_id >", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdGreaterThanOrEqualTo(Long value) {
            addCriterion("of_id >=", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdLessThan(Long value) {
            addCriterion("of_id <", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdLessThanOrEqualTo(Long value) {
            addCriterion("of_id <=", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdIn(List<Long> values) {
            addCriterion("of_id in", values, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdNotIn(List<Long> values) {
            addCriterion("of_id not in", values, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdBetween(Long value1, Long value2) {
            addCriterion("of_id between", value1, value2, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdNotBetween(Long value1, Long value2) {
            addCriterion("of_id not between", value1, value2, "ofId");
            return (Criteria) this;
        }

        public Criteria andRefundUserIdIsNull() {
            addCriterion("refund_user_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundUserIdIsNotNull() {
            addCriterion("refund_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundUserIdEqualTo(Long value) {
            addCriterion("refund_user_id =", value, "refundUserId");
            return (Criteria) this;
        }

        public Criteria andRefundUserIdNotEqualTo(Long value) {
            addCriterion("refund_user_id <>", value, "refundUserId");
            return (Criteria) this;
        }

        public Criteria andRefundUserIdGreaterThan(Long value) {
            addCriterion("refund_user_id >", value, "refundUserId");
            return (Criteria) this;
        }

        public Criteria andRefundUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_user_id >=", value, "refundUserId");
            return (Criteria) this;
        }

        public Criteria andRefundUserIdLessThan(Long value) {
            addCriterion("refund_user_id <", value, "refundUserId");
            return (Criteria) this;
        }

        public Criteria andRefundUserIdLessThanOrEqualTo(Long value) {
            addCriterion("refund_user_id <=", value, "refundUserId");
            return (Criteria) this;
        }

        public Criteria andRefundUserIdIn(List<Long> values) {
            addCriterion("refund_user_id in", values, "refundUserId");
            return (Criteria) this;
        }

        public Criteria andRefundUserIdNotIn(List<Long> values) {
            addCriterion("refund_user_id not in", values, "refundUserId");
            return (Criteria) this;
        }

        public Criteria andRefundUserIdBetween(Long value1, Long value2) {
            addCriterion("refund_user_id between", value1, value2, "refundUserId");
            return (Criteria) this;
        }

        public Criteria andRefundUserIdNotBetween(Long value1, Long value2) {
            addCriterion("refund_user_id not between", value1, value2, "refundUserId");
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