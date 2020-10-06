package com.xdj.www.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingGoodsrecommendExample extends BaseEntity{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShoppingGoodsrecommendExample() {
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

        public Criteria andBrowsenumIsNull() {
            addCriterion("browseNum is null");
            return (Criteria) this;
        }

        public Criteria andBrowsenumIsNotNull() {
            addCriterion("browseNum is not null");
            return (Criteria) this;
        }

        public Criteria andBrowsenumEqualTo(Integer value) {
            addCriterion("browseNum =", value, "browsenum");
            return (Criteria) this;
        }

        public Criteria andBrowsenumNotEqualTo(Integer value) {
            addCriterion("browseNum <>", value, "browsenum");
            return (Criteria) this;
        }

        public Criteria andBrowsenumGreaterThan(Integer value) {
            addCriterion("browseNum >", value, "browsenum");
            return (Criteria) this;
        }

        public Criteria andBrowsenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("browseNum >=", value, "browsenum");
            return (Criteria) this;
        }

        public Criteria andBrowsenumLessThan(Integer value) {
            addCriterion("browseNum <", value, "browsenum");
            return (Criteria) this;
        }

        public Criteria andBrowsenumLessThanOrEqualTo(Integer value) {
            addCriterion("browseNum <=", value, "browsenum");
            return (Criteria) this;
        }

        public Criteria andBrowsenumIn(List<Integer> values) {
            addCriterion("browseNum in", values, "browsenum");
            return (Criteria) this;
        }

        public Criteria andBrowsenumNotIn(List<Integer> values) {
            addCriterion("browseNum not in", values, "browsenum");
            return (Criteria) this;
        }

        public Criteria andBrowsenumBetween(Integer value1, Integer value2) {
            addCriterion("browseNum between", value1, value2, "browsenum");
            return (Criteria) this;
        }

        public Criteria andBrowsenumNotBetween(Integer value1, Integer value2) {
            addCriterion("browseNum not between", value1, value2, "browsenum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumIsNull() {
            addCriterion("goodsNum is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnumIsNotNull() {
            addCriterion("goodsNum is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnumEqualTo(Integer value) {
            addCriterion("goodsNum =", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumNotEqualTo(Integer value) {
            addCriterion("goodsNum <>", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumGreaterThan(Integer value) {
            addCriterion("goodsNum >", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsNum >=", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumLessThan(Integer value) {
            addCriterion("goodsNum <", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumLessThanOrEqualTo(Integer value) {
            addCriterion("goodsNum <=", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumIn(List<Integer> values) {
            addCriterion("goodsNum in", values, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumNotIn(List<Integer> values) {
            addCriterion("goodsNum not in", values, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumBetween(Integer value1, Integer value2) {
            addCriterion("goodsNum between", value1, value2, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsNum not between", value1, value2, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andImageheightIsNull() {
            addCriterion("imageHeight is null");
            return (Criteria) this;
        }

        public Criteria andImageheightIsNotNull() {
            addCriterion("imageHeight is not null");
            return (Criteria) this;
        }

        public Criteria andImageheightEqualTo(Integer value) {
            addCriterion("imageHeight =", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightNotEqualTo(Integer value) {
            addCriterion("imageHeight <>", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightGreaterThan(Integer value) {
            addCriterion("imageHeight >", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightGreaterThanOrEqualTo(Integer value) {
            addCriterion("imageHeight >=", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightLessThan(Integer value) {
            addCriterion("imageHeight <", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightLessThanOrEqualTo(Integer value) {
            addCriterion("imageHeight <=", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightIn(List<Integer> values) {
            addCriterion("imageHeight in", values, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightNotIn(List<Integer> values) {
            addCriterion("imageHeight not in", values, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightBetween(Integer value1, Integer value2) {
            addCriterion("imageHeight between", value1, value2, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightNotBetween(Integer value1, Integer value2) {
            addCriterion("imageHeight not between", value1, value2, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImagewidthIsNull() {
            addCriterion("imageWidth is null");
            return (Criteria) this;
        }

        public Criteria andImagewidthIsNotNull() {
            addCriterion("imageWidth is not null");
            return (Criteria) this;
        }

        public Criteria andImagewidthEqualTo(Integer value) {
            addCriterion("imageWidth =", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthNotEqualTo(Integer value) {
            addCriterion("imageWidth <>", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthGreaterThan(Integer value) {
            addCriterion("imageWidth >", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("imageWidth >=", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthLessThan(Integer value) {
            addCriterion("imageWidth <", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthLessThanOrEqualTo(Integer value) {
            addCriterion("imageWidth <=", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthIn(List<Integer> values) {
            addCriterion("imageWidth in", values, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthNotIn(List<Integer> values) {
            addCriterion("imageWidth not in", values, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthBetween(Integer value1, Integer value2) {
            addCriterion("imageWidth between", value1, value2, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthNotBetween(Integer value1, Integer value2) {
            addCriterion("imageWidth not between", value1, value2, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoIsNull() {
            addCriterion("remarkInfo is null");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoIsNotNull() {
            addCriterion("remarkInfo is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoEqualTo(String value) {
            addCriterion("remarkInfo =", value, "remarkinfo");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoNotEqualTo(String value) {
            addCriterion("remarkInfo <>", value, "remarkinfo");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoGreaterThan(String value) {
            addCriterion("remarkInfo >", value, "remarkinfo");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoGreaterThanOrEqualTo(String value) {
            addCriterion("remarkInfo >=", value, "remarkinfo");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoLessThan(String value) {
            addCriterion("remarkInfo <", value, "remarkinfo");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoLessThanOrEqualTo(String value) {
            addCriterion("remarkInfo <=", value, "remarkinfo");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoLike(String value) {
            addCriterion("remarkInfo like", value, "remarkinfo");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoNotLike(String value) {
            addCriterion("remarkInfo not like", value, "remarkinfo");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoIn(List<String> values) {
            addCriterion("remarkInfo in", values, "remarkinfo");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoNotIn(List<String> values) {
            addCriterion("remarkInfo not in", values, "remarkinfo");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoBetween(String value1, String value2) {
            addCriterion("remarkInfo between", value1, value2, "remarkinfo");
            return (Criteria) this;
        }

        public Criteria andRemarkinfoNotBetween(String value1, String value2) {
            addCriterion("remarkInfo not between", value1, value2, "remarkinfo");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNull() {
            addCriterion("sequence is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNotNull() {
            addCriterion("sequence is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceEqualTo(Integer value) {
            addCriterion("sequence =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(Integer value) {
            addCriterion("sequence <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(Integer value) {
            addCriterion("sequence >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(Integer value) {
            addCriterion("sequence <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("sequence <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<Integer> values) {
            addCriterion("sequence in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<Integer> values) {
            addCriterion("sequence not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(Integer value1, Integer value2) {
            addCriterion("sequence between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence not between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andShownumIsNull() {
            addCriterion("showNum is null");
            return (Criteria) this;
        }

        public Criteria andShownumIsNotNull() {
            addCriterion("showNum is not null");
            return (Criteria) this;
        }

        public Criteria andShownumEqualTo(Integer value) {
            addCriterion("showNum =", value, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumNotEqualTo(Integer value) {
            addCriterion("showNum <>", value, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumGreaterThan(Integer value) {
            addCriterion("showNum >", value, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("showNum >=", value, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumLessThan(Integer value) {
            addCriterion("showNum <", value, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumLessThanOrEqualTo(Integer value) {
            addCriterion("showNum <=", value, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumIn(List<Integer> values) {
            addCriterion("showNum in", values, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumNotIn(List<Integer> values) {
            addCriterion("showNum not in", values, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumBetween(Integer value1, Integer value2) {
            addCriterion("showNum between", value1, value2, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumNotBetween(Integer value1, Integer value2) {
            addCriterion("showNum not between", value1, value2, "shownum");
            return (Criteria) this;
        }

        public Criteria andStylenameIsNull() {
            addCriterion("styleName is null");
            return (Criteria) this;
        }

        public Criteria andStylenameIsNotNull() {
            addCriterion("styleName is not null");
            return (Criteria) this;
        }

        public Criteria andStylenameEqualTo(String value) {
            addCriterion("styleName =", value, "stylename");
            return (Criteria) this;
        }

        public Criteria andStylenameNotEqualTo(String value) {
            addCriterion("styleName <>", value, "stylename");
            return (Criteria) this;
        }

        public Criteria andStylenameGreaterThan(String value) {
            addCriterion("styleName >", value, "stylename");
            return (Criteria) this;
        }

        public Criteria andStylenameGreaterThanOrEqualTo(String value) {
            addCriterion("styleName >=", value, "stylename");
            return (Criteria) this;
        }

        public Criteria andStylenameLessThan(String value) {
            addCriterion("styleName <", value, "stylename");
            return (Criteria) this;
        }

        public Criteria andStylenameLessThanOrEqualTo(String value) {
            addCriterion("styleName <=", value, "stylename");
            return (Criteria) this;
        }

        public Criteria andStylenameLike(String value) {
            addCriterion("styleName like", value, "stylename");
            return (Criteria) this;
        }

        public Criteria andStylenameNotLike(String value) {
            addCriterion("styleName not like", value, "stylename");
            return (Criteria) this;
        }

        public Criteria andStylenameIn(List<String> values) {
            addCriterion("styleName in", values, "stylename");
            return (Criteria) this;
        }

        public Criteria andStylenameNotIn(List<String> values) {
            addCriterion("styleName not in", values, "stylename");
            return (Criteria) this;
        }

        public Criteria andStylenameBetween(String value1, String value2) {
            addCriterion("styleName between", value1, value2, "stylename");
            return (Criteria) this;
        }

        public Criteria andStylenameNotBetween(String value1, String value2) {
            addCriterion("styleName not between", value1, value2, "stylename");
            return (Criteria) this;
        }

        public Criteria andTypenameIsNull() {
            addCriterion("typeName is null");
            return (Criteria) this;
        }

        public Criteria andTypenameIsNotNull() {
            addCriterion("typeName is not null");
            return (Criteria) this;
        }

        public Criteria andTypenameEqualTo(String value) {
            addCriterion("typeName =", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotEqualTo(String value) {
            addCriterion("typeName <>", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameGreaterThan(String value) {
            addCriterion("typeName >", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameGreaterThanOrEqualTo(String value) {
            addCriterion("typeName >=", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLessThan(String value) {
            addCriterion("typeName <", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLessThanOrEqualTo(String value) {
            addCriterion("typeName <=", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLike(String value) {
            addCriterion("typeName like", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotLike(String value) {
            addCriterion("typeName not like", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameIn(List<String> values) {
            addCriterion("typeName in", values, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotIn(List<String> values) {
            addCriterion("typeName not in", values, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameBetween(String value1, String value2) {
            addCriterion("typeName between", value1, value2, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotBetween(String value1, String value2) {
            addCriterion("typeName not between", value1, value2, "typename");
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