package com.xupt.ttms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andPlayIdIsNull() {
            addCriterion("play_id is null");
            return (Criteria) this;
        }

        public Criteria andPlayIdIsNotNull() {
            addCriterion("play_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlayIdEqualTo(Integer value) {
            addCriterion("play_id =", value, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdNotEqualTo(Integer value) {
            addCriterion("play_id <>", value, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdGreaterThan(Integer value) {
            addCriterion("play_id >", value, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("play_id >=", value, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdLessThan(Integer value) {
            addCriterion("play_id <", value, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdLessThanOrEqualTo(Integer value) {
            addCriterion("play_id <=", value, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdIn(List<Integer> values) {
            addCriterion("play_id in", values, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdNotIn(List<Integer> values) {
            addCriterion("play_id not in", values, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdBetween(Integer value1, Integer value2) {
            addCriterion("play_id between", value1, value2, "playId");
            return (Criteria) this;
        }

        public Criteria andPlayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("play_id not between", value1, value2, "playId");
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCommentTextIsNull() {
            addCriterion("comment_text is null");
            return (Criteria) this;
        }

        public Criteria andCommentTextIsNotNull() {
            addCriterion("comment_text is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTextEqualTo(String value) {
            addCriterion("comment_text =", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextNotEqualTo(String value) {
            addCriterion("comment_text <>", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextGreaterThan(String value) {
            addCriterion("comment_text >", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextGreaterThanOrEqualTo(String value) {
            addCriterion("comment_text >=", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextLessThan(String value) {
            addCriterion("comment_text <", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextLessThanOrEqualTo(String value) {
            addCriterion("comment_text <=", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextLike(String value) {
            addCriterion("comment_text like", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextNotLike(String value) {
            addCriterion("comment_text not like", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextIn(List<String> values) {
            addCriterion("comment_text in", values, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextNotIn(List<String> values) {
            addCriterion("comment_text not in", values, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextBetween(String value1, String value2) {
            addCriterion("comment_text between", value1, value2, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextNotBetween(String value1, String value2) {
            addCriterion("comment_text not between", value1, value2, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNull() {
            addCriterion("comment_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNotNull() {
            addCriterion("comment_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeEqualTo(Date value) {
            addCriterion("comment_time =", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotEqualTo(Date value) {
            addCriterion("comment_time <>", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThan(Date value) {
            addCriterion("comment_time >", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_time >=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThan(Date value) {
            addCriterion("comment_time <", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_time <=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIn(List<Date> values) {
            addCriterion("comment_time in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotIn(List<Date> values) {
            addCriterion("comment_time not in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeBetween(Date value1, Date value2) {
            addCriterion("comment_time between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_time not between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentLevelIsNull() {
            addCriterion("comment_level is null");
            return (Criteria) this;
        }

        public Criteria andCommentLevelIsNotNull() {
            addCriterion("comment_level is not null");
            return (Criteria) this;
        }

        public Criteria andCommentLevelEqualTo(Short value) {
            addCriterion("comment_level =", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelNotEqualTo(Short value) {
            addCriterion("comment_level <>", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelGreaterThan(Short value) {
            addCriterion("comment_level >", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("comment_level >=", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelLessThan(Short value) {
            addCriterion("comment_level <", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelLessThanOrEqualTo(Short value) {
            addCriterion("comment_level <=", value, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelIn(List<Short> values) {
            addCriterion("comment_level in", values, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelNotIn(List<Short> values) {
            addCriterion("comment_level not in", values, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelBetween(Short value1, Short value2) {
            addCriterion("comment_level between", value1, value2, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentLevelNotBetween(Short value1, Short value2) {
            addCriterion("comment_level not between", value1, value2, "commentLevel");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNull() {
            addCriterion("comment_status is null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNotNull() {
            addCriterion("comment_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusEqualTo(Short value) {
            addCriterion("comment_status =", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotEqualTo(Short value) {
            addCriterion("comment_status <>", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThan(Short value) {
            addCriterion("comment_status >", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("comment_status >=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThan(Short value) {
            addCriterion("comment_status <", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThanOrEqualTo(Short value) {
            addCriterion("comment_status <=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIn(List<Short> values) {
            addCriterion("comment_status in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotIn(List<Short> values) {
            addCriterion("comment_status not in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusBetween(Short value1, Short value2) {
            addCriterion("comment_status between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotBetween(Short value1, Short value2) {
            addCriterion("comment_status not between", value1, value2, "commentStatus");
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