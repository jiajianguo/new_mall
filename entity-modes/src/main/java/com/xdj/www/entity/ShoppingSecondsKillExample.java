package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingSecondsKillExample extends BaseEntity{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShoppingSecondsKillExample() {
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

        public Criteria andSgGoodsIdIsNull() {
            addCriterion("sg_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andSgGoodsIdIsNotNull() {
            addCriterion("sg_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andSgGoodsIdEqualTo(Long value) {
            addCriterion("sg_goods_id =", value, "sgGoodsId");
            return (Criteria) this;
        }

        public Criteria andSgGoodsIdNotEqualTo(Long value) {
            addCriterion("sg_goods_id <>", value, "sgGoodsId");
            return (Criteria) this;
        }

        public Criteria andSgGoodsIdGreaterThan(Long value) {
            addCriterion("sg_goods_id >", value, "sgGoodsId");
            return (Criteria) this;
        }

        public Criteria andSgGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sg_goods_id >=", value, "sgGoodsId");
            return (Criteria) this;
        }

        public Criteria andSgGoodsIdLessThan(Long value) {
            addCriterion("sg_goods_id <", value, "sgGoodsId");
            return (Criteria) this;
        }

        public Criteria andSgGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("sg_goods_id <=", value, "sgGoodsId");
            return (Criteria) this;
        }

        public Criteria andSgGoodsIdIn(List<Long> values) {
            addCriterion("sg_goods_id in", values, "sgGoodsId");
            return (Criteria) this;
        }

        public Criteria andSgGoodsIdNotIn(List<Long> values) {
            addCriterion("sg_goods_id not in", values, "sgGoodsId");
            return (Criteria) this;
        }

        public Criteria andSgGoodsIdBetween(Long value1, Long value2) {
            addCriterion("sg_goods_id between", value1, value2, "sgGoodsId");
            return (Criteria) this;
        }

        public Criteria andSgGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("sg_goods_id not between", value1, value2, "sgGoodsId");
            return (Criteria) this;
        }

        public Criteria andSecondsPriceIsNull() {
            addCriterion("seconds_price is null");
            return (Criteria) this;
        }

        public Criteria andSecondsPriceIsNotNull() {
            addCriterion("seconds_price is not null");
            return (Criteria) this;
        }

        public Criteria andSecondsPriceEqualTo(BigDecimal value) {
            addCriterion("seconds_price =", value, "secondsPrice");
            return (Criteria) this;
        }

        public Criteria andSecondsPriceNotEqualTo(BigDecimal value) {
            addCriterion("seconds_price <>", value, "secondsPrice");
            return (Criteria) this;
        }

        public Criteria andSecondsPriceGreaterThan(BigDecimal value) {
            addCriterion("seconds_price >", value, "secondsPrice");
            return (Criteria) this;
        }

        public Criteria andSecondsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("seconds_price >=", value, "secondsPrice");
            return (Criteria) this;
        }

        public Criteria andSecondsPriceLessThan(BigDecimal value) {
            addCriterion("seconds_price <", value, "secondsPrice");
            return (Criteria) this;
        }

        public Criteria andSecondsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("seconds_price <=", value, "secondsPrice");
            return (Criteria) this;
        }

        public Criteria andSecondsPriceIn(List<BigDecimal> values) {
            addCriterion("seconds_price in", values, "secondsPrice");
            return (Criteria) this;
        }

        public Criteria andSecondsPriceNotIn(List<BigDecimal> values) {
            addCriterion("seconds_price not in", values, "secondsPrice");
            return (Criteria) this;
        }

        public Criteria andSecondsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("seconds_price between", value1, value2, "secondsPrice");
            return (Criteria) this;
        }

        public Criteria andSecondsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("seconds_price not between", value1, value2, "secondsPrice");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(String value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(String value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(String value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(String value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(String value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLike(String value) {
            addCriterion("begin_time like", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotLike(String value) {
            addCriterion("begin_time not like", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<String> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<String> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(String value1, String value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(String value1, String value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("end_time like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("end_time not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Long value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Long value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Long value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Long value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Long value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Long value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Long> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Long> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Long value1, Long value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Long value1, Long value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Long value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Long value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Long value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Long value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Long value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Long value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Long> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Long> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Long value1, Long value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Long value1, Long value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between", value1, value2, "version");
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andSgStatusIsNull() {
            addCriterion("sg_status is null");
            return (Criteria) this;
        }

        public Criteria andSgStatusIsNotNull() {
            addCriterion("sg_status is not null");
            return (Criteria) this;
        }

        public Criteria andSgStatusEqualTo(Integer value) {
            addCriterion("sg_status =", value, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusNotEqualTo(Integer value) {
            addCriterion("sg_status <>", value, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusGreaterThan(Integer value) {
            addCriterion("sg_status >", value, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sg_status >=", value, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusLessThan(Integer value) {
            addCriterion("sg_status <", value, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sg_status <=", value, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusIn(List<Integer> values) {
            addCriterion("sg_status in", values, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusNotIn(List<Integer> values) {
            addCriterion("sg_status not in", values, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusBetween(Integer value1, Integer value2) {
            addCriterion("sg_status between", value1, value2, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sg_status not between", value1, value2, "sgStatus");
            return (Criteria) this;
        }

        public Criteria andSgMaxCountIsNull() {
            addCriterion("sg_max_count is null");
            return (Criteria) this;
        }

        public Criteria andSgMaxCountIsNotNull() {
            addCriterion("sg_max_count is not null");
            return (Criteria) this;
        }

        public Criteria andSgMaxCountEqualTo(Integer value) {
            addCriterion("sg_max_count =", value, "sgMaxCount");
            return (Criteria) this;
        }

        public Criteria andSgMaxCountNotEqualTo(Integer value) {
            addCriterion("sg_max_count <>", value, "sgMaxCount");
            return (Criteria) this;
        }

        public Criteria andSgMaxCountGreaterThan(Integer value) {
            addCriterion("sg_max_count >", value, "sgMaxCount");
            return (Criteria) this;
        }

        public Criteria andSgMaxCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sg_max_count >=", value, "sgMaxCount");
            return (Criteria) this;
        }

        public Criteria andSgMaxCountLessThan(Integer value) {
            addCriterion("sg_max_count <", value, "sgMaxCount");
            return (Criteria) this;
        }

        public Criteria andSgMaxCountLessThanOrEqualTo(Integer value) {
            addCriterion("sg_max_count <=", value, "sgMaxCount");
            return (Criteria) this;
        }

        public Criteria andSgMaxCountIn(List<Integer> values) {
            addCriterion("sg_max_count in", values, "sgMaxCount");
            return (Criteria) this;
        }

        public Criteria andSgMaxCountNotIn(List<Integer> values) {
            addCriterion("sg_max_count not in", values, "sgMaxCount");
            return (Criteria) this;
        }

        public Criteria andSgMaxCountBetween(Integer value1, Integer value2) {
            addCriterion("sg_max_count between", value1, value2, "sgMaxCount");
            return (Criteria) this;
        }

        public Criteria andSgMaxCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sg_max_count not between", value1, value2, "sgMaxCount");
            return (Criteria) this;
        }

        public Criteria andSgImgIdIsNull() {
            addCriterion("sg_img_id is null");
            return (Criteria) this;
        }

        public Criteria andSgImgIdIsNotNull() {
            addCriterion("sg_img_id is not null");
            return (Criteria) this;
        }

        public Criteria andSgImgIdEqualTo(Long value) {
            addCriterion("sg_img_id =", value, "sgImgId");
            return (Criteria) this;
        }

        public Criteria andSgImgIdNotEqualTo(Long value) {
            addCriterion("sg_img_id <>", value, "sgImgId");
            return (Criteria) this;
        }

        public Criteria andSgImgIdGreaterThan(Long value) {
            addCriterion("sg_img_id >", value, "sgImgId");
            return (Criteria) this;
        }

        public Criteria andSgImgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sg_img_id >=", value, "sgImgId");
            return (Criteria) this;
        }

        public Criteria andSgImgIdLessThan(Long value) {
            addCriterion("sg_img_id <", value, "sgImgId");
            return (Criteria) this;
        }

        public Criteria andSgImgIdLessThanOrEqualTo(Long value) {
            addCriterion("sg_img_id <=", value, "sgImgId");
            return (Criteria) this;
        }

        public Criteria andSgImgIdIn(List<Long> values) {
            addCriterion("sg_img_id in", values, "sgImgId");
            return (Criteria) this;
        }

        public Criteria andSgImgIdNotIn(List<Long> values) {
            addCriterion("sg_img_id not in", values, "sgImgId");
            return (Criteria) this;
        }

        public Criteria andSgImgIdBetween(Long value1, Long value2) {
            addCriterion("sg_img_id between", value1, value2, "sgImgId");
            return (Criteria) this;
        }

        public Criteria andSgImgIdNotBetween(Long value1, Long value2) {
            addCriterion("sg_img_id not between", value1, value2, "sgImgId");
            return (Criteria) this;
        }

        public Criteria andSgNameIsNull() {
            addCriterion("sg_name is null");
            return (Criteria) this;
        }

        public Criteria andSgNameIsNotNull() {
            addCriterion("sg_name is not null");
            return (Criteria) this;
        }

        public Criteria andSgNameEqualTo(String value) {
            addCriterion("sg_name =", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameNotEqualTo(String value) {
            addCriterion("sg_name <>", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameGreaterThan(String value) {
            addCriterion("sg_name >", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameGreaterThanOrEqualTo(String value) {
            addCriterion("sg_name >=", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameLessThan(String value) {
            addCriterion("sg_name <", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameLessThanOrEqualTo(String value) {
            addCriterion("sg_name <=", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameLike(String value) {
            addCriterion("sg_name like", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameNotLike(String value) {
            addCriterion("sg_name not like", value, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameIn(List<String> values) {
            addCriterion("sg_name in", values, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameNotIn(List<String> values) {
            addCriterion("sg_name not in", values, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameBetween(String value1, String value2) {
            addCriterion("sg_name between", value1, value2, "sgName");
            return (Criteria) this;
        }

        public Criteria andSgNameNotBetween(String value1, String value2) {
            addCriterion("sg_name not between", value1, value2, "sgName");
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
