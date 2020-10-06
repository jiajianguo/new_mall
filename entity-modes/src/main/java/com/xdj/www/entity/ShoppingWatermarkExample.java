package com.xdj.www.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingWatermarkExample extends BaseEntity{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShoppingWatermarkExample() {
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

        public Criteria andWmImageAlphaIsNull() {
            addCriterion("wm_image_alpha is null");
            return (Criteria) this;
        }

        public Criteria andWmImageAlphaIsNotNull() {
            addCriterion("wm_image_alpha is not null");
            return (Criteria) this;
        }

        public Criteria andWmImageAlphaEqualTo(Float value) {
            addCriterion("wm_image_alpha =", value, "wmImageAlpha");
            return (Criteria) this;
        }

        public Criteria andWmImageAlphaNotEqualTo(Float value) {
            addCriterion("wm_image_alpha <>", value, "wmImageAlpha");
            return (Criteria) this;
        }

        public Criteria andWmImageAlphaGreaterThan(Float value) {
            addCriterion("wm_image_alpha >", value, "wmImageAlpha");
            return (Criteria) this;
        }

        public Criteria andWmImageAlphaGreaterThanOrEqualTo(Float value) {
            addCriterion("wm_image_alpha >=", value, "wmImageAlpha");
            return (Criteria) this;
        }

        public Criteria andWmImageAlphaLessThan(Float value) {
            addCriterion("wm_image_alpha <", value, "wmImageAlpha");
            return (Criteria) this;
        }

        public Criteria andWmImageAlphaLessThanOrEqualTo(Float value) {
            addCriterion("wm_image_alpha <=", value, "wmImageAlpha");
            return (Criteria) this;
        }

        public Criteria andWmImageAlphaIn(List<Float> values) {
            addCriterion("wm_image_alpha in", values, "wmImageAlpha");
            return (Criteria) this;
        }

        public Criteria andWmImageAlphaNotIn(List<Float> values) {
            addCriterion("wm_image_alpha not in", values, "wmImageAlpha");
            return (Criteria) this;
        }

        public Criteria andWmImageAlphaBetween(Float value1, Float value2) {
            addCriterion("wm_image_alpha between", value1, value2, "wmImageAlpha");
            return (Criteria) this;
        }

        public Criteria andWmImageAlphaNotBetween(Float value1, Float value2) {
            addCriterion("wm_image_alpha not between", value1, value2, "wmImageAlpha");
            return (Criteria) this;
        }

        public Criteria andWmImageOpenIsNull() {
            addCriterion("wm_image_open is null");
            return (Criteria) this;
        }

        public Criteria andWmImageOpenIsNotNull() {
            addCriterion("wm_image_open is not null");
            return (Criteria) this;
        }

        public Criteria andWmImageOpenEqualTo(Boolean value) {
            addCriterion("wm_image_open =", value, "wmImageOpen");
            return (Criteria) this;
        }

        public Criteria andWmImageOpenNotEqualTo(Boolean value) {
            addCriterion("wm_image_open <>", value, "wmImageOpen");
            return (Criteria) this;
        }

        public Criteria andWmImageOpenGreaterThan(Boolean value) {
            addCriterion("wm_image_open >", value, "wmImageOpen");
            return (Criteria) this;
        }

        public Criteria andWmImageOpenGreaterThanOrEqualTo(Boolean value) {
            addCriterion("wm_image_open >=", value, "wmImageOpen");
            return (Criteria) this;
        }

        public Criteria andWmImageOpenLessThan(Boolean value) {
            addCriterion("wm_image_open <", value, "wmImageOpen");
            return (Criteria) this;
        }

        public Criteria andWmImageOpenLessThanOrEqualTo(Boolean value) {
            addCriterion("wm_image_open <=", value, "wmImageOpen");
            return (Criteria) this;
        }

        public Criteria andWmImageOpenIn(List<Boolean> values) {
            addCriterion("wm_image_open in", values, "wmImageOpen");
            return (Criteria) this;
        }

        public Criteria andWmImageOpenNotIn(List<Boolean> values) {
            addCriterion("wm_image_open not in", values, "wmImageOpen");
            return (Criteria) this;
        }

        public Criteria andWmImageOpenBetween(Boolean value1, Boolean value2) {
            addCriterion("wm_image_open between", value1, value2, "wmImageOpen");
            return (Criteria) this;
        }

        public Criteria andWmImageOpenNotBetween(Boolean value1, Boolean value2) {
            addCriterion("wm_image_open not between", value1, value2, "wmImageOpen");
            return (Criteria) this;
        }

        public Criteria andWmImagePosIsNull() {
            addCriterion("wm_image_pos is null");
            return (Criteria) this;
        }

        public Criteria andWmImagePosIsNotNull() {
            addCriterion("wm_image_pos is not null");
            return (Criteria) this;
        }

        public Criteria andWmImagePosEqualTo(Integer value) {
            addCriterion("wm_image_pos =", value, "wmImagePos");
            return (Criteria) this;
        }

        public Criteria andWmImagePosNotEqualTo(Integer value) {
            addCriterion("wm_image_pos <>", value, "wmImagePos");
            return (Criteria) this;
        }

        public Criteria andWmImagePosGreaterThan(Integer value) {
            addCriterion("wm_image_pos >", value, "wmImagePos");
            return (Criteria) this;
        }

        public Criteria andWmImagePosGreaterThanOrEqualTo(Integer value) {
            addCriterion("wm_image_pos >=", value, "wmImagePos");
            return (Criteria) this;
        }

        public Criteria andWmImagePosLessThan(Integer value) {
            addCriterion("wm_image_pos <", value, "wmImagePos");
            return (Criteria) this;
        }

        public Criteria andWmImagePosLessThanOrEqualTo(Integer value) {
            addCriterion("wm_image_pos <=", value, "wmImagePos");
            return (Criteria) this;
        }

        public Criteria andWmImagePosIn(List<Integer> values) {
            addCriterion("wm_image_pos in", values, "wmImagePos");
            return (Criteria) this;
        }

        public Criteria andWmImagePosNotIn(List<Integer> values) {
            addCriterion("wm_image_pos not in", values, "wmImagePos");
            return (Criteria) this;
        }

        public Criteria andWmImagePosBetween(Integer value1, Integer value2) {
            addCriterion("wm_image_pos between", value1, value2, "wmImagePos");
            return (Criteria) this;
        }

        public Criteria andWmImagePosNotBetween(Integer value1, Integer value2) {
            addCriterion("wm_image_pos not between", value1, value2, "wmImagePos");
            return (Criteria) this;
        }

        public Criteria andWmTextIsNull() {
            addCriterion("wm_text is null");
            return (Criteria) this;
        }

        public Criteria andWmTextIsNotNull() {
            addCriterion("wm_text is not null");
            return (Criteria) this;
        }

        public Criteria andWmTextEqualTo(String value) {
            addCriterion("wm_text =", value, "wmText");
            return (Criteria) this;
        }

        public Criteria andWmTextNotEqualTo(String value) {
            addCriterion("wm_text <>", value, "wmText");
            return (Criteria) this;
        }

        public Criteria andWmTextGreaterThan(String value) {
            addCriterion("wm_text >", value, "wmText");
            return (Criteria) this;
        }

        public Criteria andWmTextGreaterThanOrEqualTo(String value) {
            addCriterion("wm_text >=", value, "wmText");
            return (Criteria) this;
        }

        public Criteria andWmTextLessThan(String value) {
            addCriterion("wm_text <", value, "wmText");
            return (Criteria) this;
        }

        public Criteria andWmTextLessThanOrEqualTo(String value) {
            addCriterion("wm_text <=", value, "wmText");
            return (Criteria) this;
        }

        public Criteria andWmTextLike(String value) {
            addCriterion("wm_text like", value, "wmText");
            return (Criteria) this;
        }

        public Criteria andWmTextNotLike(String value) {
            addCriterion("wm_text not like", value, "wmText");
            return (Criteria) this;
        }

        public Criteria andWmTextIn(List<String> values) {
            addCriterion("wm_text in", values, "wmText");
            return (Criteria) this;
        }

        public Criteria andWmTextNotIn(List<String> values) {
            addCriterion("wm_text not in", values, "wmText");
            return (Criteria) this;
        }

        public Criteria andWmTextBetween(String value1, String value2) {
            addCriterion("wm_text between", value1, value2, "wmText");
            return (Criteria) this;
        }

        public Criteria andWmTextNotBetween(String value1, String value2) {
            addCriterion("wm_text not between", value1, value2, "wmText");
            return (Criteria) this;
        }

        public Criteria andWmTextColorIsNull() {
            addCriterion("wm_text_color is null");
            return (Criteria) this;
        }

        public Criteria andWmTextColorIsNotNull() {
            addCriterion("wm_text_color is not null");
            return (Criteria) this;
        }

        public Criteria andWmTextColorEqualTo(String value) {
            addCriterion("wm_text_color =", value, "wmTextColor");
            return (Criteria) this;
        }

        public Criteria andWmTextColorNotEqualTo(String value) {
            addCriterion("wm_text_color <>", value, "wmTextColor");
            return (Criteria) this;
        }

        public Criteria andWmTextColorGreaterThan(String value) {
            addCriterion("wm_text_color >", value, "wmTextColor");
            return (Criteria) this;
        }

        public Criteria andWmTextColorGreaterThanOrEqualTo(String value) {
            addCriterion("wm_text_color >=", value, "wmTextColor");
            return (Criteria) this;
        }

        public Criteria andWmTextColorLessThan(String value) {
            addCriterion("wm_text_color <", value, "wmTextColor");
            return (Criteria) this;
        }

        public Criteria andWmTextColorLessThanOrEqualTo(String value) {
            addCriterion("wm_text_color <=", value, "wmTextColor");
            return (Criteria) this;
        }

        public Criteria andWmTextColorLike(String value) {
            addCriterion("wm_text_color like", value, "wmTextColor");
            return (Criteria) this;
        }

        public Criteria andWmTextColorNotLike(String value) {
            addCriterion("wm_text_color not like", value, "wmTextColor");
            return (Criteria) this;
        }

        public Criteria andWmTextColorIn(List<String> values) {
            addCriterion("wm_text_color in", values, "wmTextColor");
            return (Criteria) this;
        }

        public Criteria andWmTextColorNotIn(List<String> values) {
            addCriterion("wm_text_color not in", values, "wmTextColor");
            return (Criteria) this;
        }

        public Criteria andWmTextColorBetween(String value1, String value2) {
            addCriterion("wm_text_color between", value1, value2, "wmTextColor");
            return (Criteria) this;
        }

        public Criteria andWmTextColorNotBetween(String value1, String value2) {
            addCriterion("wm_text_color not between", value1, value2, "wmTextColor");
            return (Criteria) this;
        }

        public Criteria andWmTextFontIsNull() {
            addCriterion("wm_text_font is null");
            return (Criteria) this;
        }

        public Criteria andWmTextFontIsNotNull() {
            addCriterion("wm_text_font is not null");
            return (Criteria) this;
        }

        public Criteria andWmTextFontEqualTo(String value) {
            addCriterion("wm_text_font =", value, "wmTextFont");
            return (Criteria) this;
        }

        public Criteria andWmTextFontNotEqualTo(String value) {
            addCriterion("wm_text_font <>", value, "wmTextFont");
            return (Criteria) this;
        }

        public Criteria andWmTextFontGreaterThan(String value) {
            addCriterion("wm_text_font >", value, "wmTextFont");
            return (Criteria) this;
        }

        public Criteria andWmTextFontGreaterThanOrEqualTo(String value) {
            addCriterion("wm_text_font >=", value, "wmTextFont");
            return (Criteria) this;
        }

        public Criteria andWmTextFontLessThan(String value) {
            addCriterion("wm_text_font <", value, "wmTextFont");
            return (Criteria) this;
        }

        public Criteria andWmTextFontLessThanOrEqualTo(String value) {
            addCriterion("wm_text_font <=", value, "wmTextFont");
            return (Criteria) this;
        }

        public Criteria andWmTextFontLike(String value) {
            addCriterion("wm_text_font like", value, "wmTextFont");
            return (Criteria) this;
        }

        public Criteria andWmTextFontNotLike(String value) {
            addCriterion("wm_text_font not like", value, "wmTextFont");
            return (Criteria) this;
        }

        public Criteria andWmTextFontIn(List<String> values) {
            addCriterion("wm_text_font in", values, "wmTextFont");
            return (Criteria) this;
        }

        public Criteria andWmTextFontNotIn(List<String> values) {
            addCriterion("wm_text_font not in", values, "wmTextFont");
            return (Criteria) this;
        }

        public Criteria andWmTextFontBetween(String value1, String value2) {
            addCriterion("wm_text_font between", value1, value2, "wmTextFont");
            return (Criteria) this;
        }

        public Criteria andWmTextFontNotBetween(String value1, String value2) {
            addCriterion("wm_text_font not between", value1, value2, "wmTextFont");
            return (Criteria) this;
        }

        public Criteria andWmTextFontSizeIsNull() {
            addCriterion("wm_text_font_size is null");
            return (Criteria) this;
        }

        public Criteria andWmTextFontSizeIsNotNull() {
            addCriterion("wm_text_font_size is not null");
            return (Criteria) this;
        }

        public Criteria andWmTextFontSizeEqualTo(Integer value) {
            addCriterion("wm_text_font_size =", value, "wmTextFontSize");
            return (Criteria) this;
        }

        public Criteria andWmTextFontSizeNotEqualTo(Integer value) {
            addCriterion("wm_text_font_size <>", value, "wmTextFontSize");
            return (Criteria) this;
        }

        public Criteria andWmTextFontSizeGreaterThan(Integer value) {
            addCriterion("wm_text_font_size >", value, "wmTextFontSize");
            return (Criteria) this;
        }

        public Criteria andWmTextFontSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wm_text_font_size >=", value, "wmTextFontSize");
            return (Criteria) this;
        }

        public Criteria andWmTextFontSizeLessThan(Integer value) {
            addCriterion("wm_text_font_size <", value, "wmTextFontSize");
            return (Criteria) this;
        }

        public Criteria andWmTextFontSizeLessThanOrEqualTo(Integer value) {
            addCriterion("wm_text_font_size <=", value, "wmTextFontSize");
            return (Criteria) this;
        }

        public Criteria andWmTextFontSizeIn(List<Integer> values) {
            addCriterion("wm_text_font_size in", values, "wmTextFontSize");
            return (Criteria) this;
        }

        public Criteria andWmTextFontSizeNotIn(List<Integer> values) {
            addCriterion("wm_text_font_size not in", values, "wmTextFontSize");
            return (Criteria) this;
        }

        public Criteria andWmTextFontSizeBetween(Integer value1, Integer value2) {
            addCriterion("wm_text_font_size between", value1, value2, "wmTextFontSize");
            return (Criteria) this;
        }

        public Criteria andWmTextFontSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("wm_text_font_size not between", value1, value2, "wmTextFontSize");
            return (Criteria) this;
        }

        public Criteria andWmTextOpenIsNull() {
            addCriterion("wm_text_open is null");
            return (Criteria) this;
        }

        public Criteria andWmTextOpenIsNotNull() {
            addCriterion("wm_text_open is not null");
            return (Criteria) this;
        }

        public Criteria andWmTextOpenEqualTo(Boolean value) {
            addCriterion("wm_text_open =", value, "wmTextOpen");
            return (Criteria) this;
        }

        public Criteria andWmTextOpenNotEqualTo(Boolean value) {
            addCriterion("wm_text_open <>", value, "wmTextOpen");
            return (Criteria) this;
        }

        public Criteria andWmTextOpenGreaterThan(Boolean value) {
            addCriterion("wm_text_open >", value, "wmTextOpen");
            return (Criteria) this;
        }

        public Criteria andWmTextOpenGreaterThanOrEqualTo(Boolean value) {
            addCriterion("wm_text_open >=", value, "wmTextOpen");
            return (Criteria) this;
        }

        public Criteria andWmTextOpenLessThan(Boolean value) {
            addCriterion("wm_text_open <", value, "wmTextOpen");
            return (Criteria) this;
        }

        public Criteria andWmTextOpenLessThanOrEqualTo(Boolean value) {
            addCriterion("wm_text_open <=", value, "wmTextOpen");
            return (Criteria) this;
        }

        public Criteria andWmTextOpenIn(List<Boolean> values) {
            addCriterion("wm_text_open in", values, "wmTextOpen");
            return (Criteria) this;
        }

        public Criteria andWmTextOpenNotIn(List<Boolean> values) {
            addCriterion("wm_text_open not in", values, "wmTextOpen");
            return (Criteria) this;
        }

        public Criteria andWmTextOpenBetween(Boolean value1, Boolean value2) {
            addCriterion("wm_text_open between", value1, value2, "wmTextOpen");
            return (Criteria) this;
        }

        public Criteria andWmTextOpenNotBetween(Boolean value1, Boolean value2) {
            addCriterion("wm_text_open not between", value1, value2, "wmTextOpen");
            return (Criteria) this;
        }

        public Criteria andWmTextPosIsNull() {
            addCriterion("wm_text_pos is null");
            return (Criteria) this;
        }

        public Criteria andWmTextPosIsNotNull() {
            addCriterion("wm_text_pos is not null");
            return (Criteria) this;
        }

        public Criteria andWmTextPosEqualTo(Integer value) {
            addCriterion("wm_text_pos =", value, "wmTextPos");
            return (Criteria) this;
        }

        public Criteria andWmTextPosNotEqualTo(Integer value) {
            addCriterion("wm_text_pos <>", value, "wmTextPos");
            return (Criteria) this;
        }

        public Criteria andWmTextPosGreaterThan(Integer value) {
            addCriterion("wm_text_pos >", value, "wmTextPos");
            return (Criteria) this;
        }

        public Criteria andWmTextPosGreaterThanOrEqualTo(Integer value) {
            addCriterion("wm_text_pos >=", value, "wmTextPos");
            return (Criteria) this;
        }

        public Criteria andWmTextPosLessThan(Integer value) {
            addCriterion("wm_text_pos <", value, "wmTextPos");
            return (Criteria) this;
        }

        public Criteria andWmTextPosLessThanOrEqualTo(Integer value) {
            addCriterion("wm_text_pos <=", value, "wmTextPos");
            return (Criteria) this;
        }

        public Criteria andWmTextPosIn(List<Integer> values) {
            addCriterion("wm_text_pos in", values, "wmTextPos");
            return (Criteria) this;
        }

        public Criteria andWmTextPosNotIn(List<Integer> values) {
            addCriterion("wm_text_pos not in", values, "wmTextPos");
            return (Criteria) this;
        }

        public Criteria andWmTextPosBetween(Integer value1, Integer value2) {
            addCriterion("wm_text_pos between", value1, value2, "wmTextPos");
            return (Criteria) this;
        }

        public Criteria andWmTextPosNotBetween(Integer value1, Integer value2) {
            addCriterion("wm_text_pos not between", value1, value2, "wmTextPos");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Long value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Long value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Long value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Long value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Long value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Long> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Long> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Long value1, Long value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Long value1, Long value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andWmImageIdIsNull() {
            addCriterion("wm_image_id is null");
            return (Criteria) this;
        }

        public Criteria andWmImageIdIsNotNull() {
            addCriterion("wm_image_id is not null");
            return (Criteria) this;
        }

        public Criteria andWmImageIdEqualTo(Long value) {
            addCriterion("wm_image_id =", value, "wmImageId");
            return (Criteria) this;
        }

        public Criteria andWmImageIdNotEqualTo(Long value) {
            addCriterion("wm_image_id <>", value, "wmImageId");
            return (Criteria) this;
        }

        public Criteria andWmImageIdGreaterThan(Long value) {
            addCriterion("wm_image_id >", value, "wmImageId");
            return (Criteria) this;
        }

        public Criteria andWmImageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("wm_image_id >=", value, "wmImageId");
            return (Criteria) this;
        }

        public Criteria andWmImageIdLessThan(Long value) {
            addCriterion("wm_image_id <", value, "wmImageId");
            return (Criteria) this;
        }

        public Criteria andWmImageIdLessThanOrEqualTo(Long value) {
            addCriterion("wm_image_id <=", value, "wmImageId");
            return (Criteria) this;
        }

        public Criteria andWmImageIdIn(List<Long> values) {
            addCriterion("wm_image_id in", values, "wmImageId");
            return (Criteria) this;
        }

        public Criteria andWmImageIdNotIn(List<Long> values) {
            addCriterion("wm_image_id not in", values, "wmImageId");
            return (Criteria) this;
        }

        public Criteria andWmImageIdBetween(Long value1, Long value2) {
            addCriterion("wm_image_id between", value1, value2, "wmImageId");
            return (Criteria) this;
        }

        public Criteria andWmImageIdNotBetween(Long value1, Long value2) {
            addCriterion("wm_image_id not between", value1, value2, "wmImageId");
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