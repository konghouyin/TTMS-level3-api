package com.xupt.ttms.model;

import java.util.ArrayList;
import java.util.List;

public class PlayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlayExample() {
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

        public Criteria andPlayNameIsNull() {
            addCriterion("play_name is null");
            return (Criteria) this;
        }

        public Criteria andPlayNameIsNotNull() {
            addCriterion("play_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlayNameEqualTo(String value) {
            addCriterion("play_name =", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameNotEqualTo(String value) {
            addCriterion("play_name <>", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameGreaterThan(String value) {
            addCriterion("play_name >", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameGreaterThanOrEqualTo(String value) {
            addCriterion("play_name >=", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameLessThan(String value) {
            addCriterion("play_name <", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameLessThanOrEqualTo(String value) {
            addCriterion("play_name <=", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameLike(String value) {
            addCriterion("play_name like", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameNotLike(String value) {
            addCriterion("play_name not like", value, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameIn(List<String> values) {
            addCriterion("play_name in", values, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameNotIn(List<String> values) {
            addCriterion("play_name not in", values, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameBetween(String value1, String value2) {
            addCriterion("play_name between", value1, value2, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayNameNotBetween(String value1, String value2) {
            addCriterion("play_name not between", value1, value2, "playName");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorIsNull() {
            addCriterion("play_director is null");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorIsNotNull() {
            addCriterion("play_director is not null");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorEqualTo(String value) {
            addCriterion("play_director =", value, "playDirector");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorNotEqualTo(String value) {
            addCriterion("play_director <>", value, "playDirector");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorGreaterThan(String value) {
            addCriterion("play_director >", value, "playDirector");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorGreaterThanOrEqualTo(String value) {
            addCriterion("play_director >=", value, "playDirector");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorLessThan(String value) {
            addCriterion("play_director <", value, "playDirector");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorLessThanOrEqualTo(String value) {
            addCriterion("play_director <=", value, "playDirector");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorLike(String value) {
            addCriterion("play_director like", value, "playDirector");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorNotLike(String value) {
            addCriterion("play_director not like", value, "playDirector");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorIn(List<String> values) {
            addCriterion("play_director in", values, "playDirector");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorNotIn(List<String> values) {
            addCriterion("play_director not in", values, "playDirector");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorBetween(String value1, String value2) {
            addCriterion("play_director between", value1, value2, "playDirector");
            return (Criteria) this;
        }

        public Criteria andPlayDirectorNotBetween(String value1, String value2) {
            addCriterion("play_director not between", value1, value2, "playDirector");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerIsNull() {
            addCriterion("play_performer is null");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerIsNotNull() {
            addCriterion("play_performer is not null");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerEqualTo(String value) {
            addCriterion("play_performer =", value, "playPerformer");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerNotEqualTo(String value) {
            addCriterion("play_performer <>", value, "playPerformer");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerGreaterThan(String value) {
            addCriterion("play_performer >", value, "playPerformer");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerGreaterThanOrEqualTo(String value) {
            addCriterion("play_performer >=", value, "playPerformer");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerLessThan(String value) {
            addCriterion("play_performer <", value, "playPerformer");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerLessThanOrEqualTo(String value) {
            addCriterion("play_performer <=", value, "playPerformer");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerLike(String value) {
            addCriterion("play_performer like", value, "playPerformer");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerNotLike(String value) {
            addCriterion("play_performer not like", value, "playPerformer");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerIn(List<String> values) {
            addCriterion("play_performer in", values, "playPerformer");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerNotIn(List<String> values) {
            addCriterion("play_performer not in", values, "playPerformer");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerBetween(String value1, String value2) {
            addCriterion("play_performer between", value1, value2, "playPerformer");
            return (Criteria) this;
        }

        public Criteria andPlayPerformerNotBetween(String value1, String value2) {
            addCriterion("play_performer not between", value1, value2, "playPerformer");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNull() {
            addCriterion("play_type is null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNotNull() {
            addCriterion("play_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeEqualTo(String value) {
            addCriterion("play_type =", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotEqualTo(String value) {
            addCriterion("play_type <>", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThan(String value) {
            addCriterion("play_type >", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("play_type >=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThan(String value) {
            addCriterion("play_type <", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThanOrEqualTo(String value) {
            addCriterion("play_type <=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLike(String value) {
            addCriterion("play_type like", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotLike(String value) {
            addCriterion("play_type not like", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIn(List<String> values) {
            addCriterion("play_type in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotIn(List<String> values) {
            addCriterion("play_type not in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeBetween(String value1, String value2) {
            addCriterion("play_type between", value1, value2, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotBetween(String value1, String value2) {
            addCriterion("play_type not between", value1, value2, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayLengthIsNull() {
            addCriterion("play_length is null");
            return (Criteria) this;
        }

        public Criteria andPlayLengthIsNotNull() {
            addCriterion("play_length is not null");
            return (Criteria) this;
        }

        public Criteria andPlayLengthEqualTo(String value) {
            addCriterion("play_length =", value, "playLength");
            return (Criteria) this;
        }

        public Criteria andPlayLengthNotEqualTo(String value) {
            addCriterion("play_length <>", value, "playLength");
            return (Criteria) this;
        }

        public Criteria andPlayLengthGreaterThan(String value) {
            addCriterion("play_length >", value, "playLength");
            return (Criteria) this;
        }

        public Criteria andPlayLengthGreaterThanOrEqualTo(String value) {
            addCriterion("play_length >=", value, "playLength");
            return (Criteria) this;
        }

        public Criteria andPlayLengthLessThan(String value) {
            addCriterion("play_length <", value, "playLength");
            return (Criteria) this;
        }

        public Criteria andPlayLengthLessThanOrEqualTo(String value) {
            addCriterion("play_length <=", value, "playLength");
            return (Criteria) this;
        }

        public Criteria andPlayLengthLike(String value) {
            addCriterion("play_length like", value, "playLength");
            return (Criteria) this;
        }

        public Criteria andPlayLengthNotLike(String value) {
            addCriterion("play_length not like", value, "playLength");
            return (Criteria) this;
        }

        public Criteria andPlayLengthIn(List<String> values) {
            addCriterion("play_length in", values, "playLength");
            return (Criteria) this;
        }

        public Criteria andPlayLengthNotIn(List<String> values) {
            addCriterion("play_length not in", values, "playLength");
            return (Criteria) this;
        }

        public Criteria andPlayLengthBetween(String value1, String value2) {
            addCriterion("play_length between", value1, value2, "playLength");
            return (Criteria) this;
        }

        public Criteria andPlayLengthNotBetween(String value1, String value2) {
            addCriterion("play_length not between", value1, value2, "playLength");
            return (Criteria) this;
        }

        public Criteria andPlayCountryIsNull() {
            addCriterion("play_country is null");
            return (Criteria) this;
        }

        public Criteria andPlayCountryIsNotNull() {
            addCriterion("play_country is not null");
            return (Criteria) this;
        }

        public Criteria andPlayCountryEqualTo(String value) {
            addCriterion("play_country =", value, "playCountry");
            return (Criteria) this;
        }

        public Criteria andPlayCountryNotEqualTo(String value) {
            addCriterion("play_country <>", value, "playCountry");
            return (Criteria) this;
        }

        public Criteria andPlayCountryGreaterThan(String value) {
            addCriterion("play_country >", value, "playCountry");
            return (Criteria) this;
        }

        public Criteria andPlayCountryGreaterThanOrEqualTo(String value) {
            addCriterion("play_country >=", value, "playCountry");
            return (Criteria) this;
        }

        public Criteria andPlayCountryLessThan(String value) {
            addCriterion("play_country <", value, "playCountry");
            return (Criteria) this;
        }

        public Criteria andPlayCountryLessThanOrEqualTo(String value) {
            addCriterion("play_country <=", value, "playCountry");
            return (Criteria) this;
        }

        public Criteria andPlayCountryLike(String value) {
            addCriterion("play_country like", value, "playCountry");
            return (Criteria) this;
        }

        public Criteria andPlayCountryNotLike(String value) {
            addCriterion("play_country not like", value, "playCountry");
            return (Criteria) this;
        }

        public Criteria andPlayCountryIn(List<String> values) {
            addCriterion("play_country in", values, "playCountry");
            return (Criteria) this;
        }

        public Criteria andPlayCountryNotIn(List<String> values) {
            addCriterion("play_country not in", values, "playCountry");
            return (Criteria) this;
        }

        public Criteria andPlayCountryBetween(String value1, String value2) {
            addCriterion("play_country between", value1, value2, "playCountry");
            return (Criteria) this;
        }

        public Criteria andPlayCountryNotBetween(String value1, String value2) {
            addCriterion("play_country not between", value1, value2, "playCountry");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageIsNull() {
            addCriterion("play_language is null");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageIsNotNull() {
            addCriterion("play_language is not null");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageEqualTo(String value) {
            addCriterion("play_language =", value, "playLanguage");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageNotEqualTo(String value) {
            addCriterion("play_language <>", value, "playLanguage");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageGreaterThan(String value) {
            addCriterion("play_language >", value, "playLanguage");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("play_language >=", value, "playLanguage");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageLessThan(String value) {
            addCriterion("play_language <", value, "playLanguage");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageLessThanOrEqualTo(String value) {
            addCriterion("play_language <=", value, "playLanguage");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageLike(String value) {
            addCriterion("play_language like", value, "playLanguage");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageNotLike(String value) {
            addCriterion("play_language not like", value, "playLanguage");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageIn(List<String> values) {
            addCriterion("play_language in", values, "playLanguage");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageNotIn(List<String> values) {
            addCriterion("play_language not in", values, "playLanguage");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageBetween(String value1, String value2) {
            addCriterion("play_language between", value1, value2, "playLanguage");
            return (Criteria) this;
        }

        public Criteria andPlayLanguageNotBetween(String value1, String value2) {
            addCriterion("play_language not between", value1, value2, "playLanguage");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIsNull() {
            addCriterion("play_status is null");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIsNotNull() {
            addCriterion("play_status is not null");
            return (Criteria) this;
        }

        public Criteria andPlayStatusEqualTo(String value) {
            addCriterion("play_status =", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusNotEqualTo(String value) {
            addCriterion("play_status <>", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusGreaterThan(String value) {
            addCriterion("play_status >", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("play_status >=", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusLessThan(String value) {
            addCriterion("play_status <", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusLessThanOrEqualTo(String value) {
            addCriterion("play_status <=", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusLike(String value) {
            addCriterion("play_status like", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusNotLike(String value) {
            addCriterion("play_status not like", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIn(List<String> values) {
            addCriterion("play_status in", values, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusNotIn(List<String> values) {
            addCriterion("play_status not in", values, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusBetween(String value1, String value2) {
            addCriterion("play_status between", value1, value2, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusNotBetween(String value1, String value2) {
            addCriterion("play_status not between", value1, value2, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayPicIsNull() {
            addCriterion("play_pic is null");
            return (Criteria) this;
        }

        public Criteria andPlayPicIsNotNull() {
            addCriterion("play_pic is not null");
            return (Criteria) this;
        }

        public Criteria andPlayPicEqualTo(String value) {
            addCriterion("play_pic =", value, "playPic");
            return (Criteria) this;
        }

        public Criteria andPlayPicNotEqualTo(String value) {
            addCriterion("play_pic <>", value, "playPic");
            return (Criteria) this;
        }

        public Criteria andPlayPicGreaterThan(String value) {
            addCriterion("play_pic >", value, "playPic");
            return (Criteria) this;
        }

        public Criteria andPlayPicGreaterThanOrEqualTo(String value) {
            addCriterion("play_pic >=", value, "playPic");
            return (Criteria) this;
        }

        public Criteria andPlayPicLessThan(String value) {
            addCriterion("play_pic <", value, "playPic");
            return (Criteria) this;
        }

        public Criteria andPlayPicLessThanOrEqualTo(String value) {
            addCriterion("play_pic <=", value, "playPic");
            return (Criteria) this;
        }

        public Criteria andPlayPicLike(String value) {
            addCriterion("play_pic like", value, "playPic");
            return (Criteria) this;
        }

        public Criteria andPlayPicNotLike(String value) {
            addCriterion("play_pic not like", value, "playPic");
            return (Criteria) this;
        }

        public Criteria andPlayPicIn(List<String> values) {
            addCriterion("play_pic in", values, "playPic");
            return (Criteria) this;
        }

        public Criteria andPlayPicNotIn(List<String> values) {
            addCriterion("play_pic not in", values, "playPic");
            return (Criteria) this;
        }

        public Criteria andPlayPicBetween(String value1, String value2) {
            addCriterion("play_pic between", value1, value2, "playPic");
            return (Criteria) this;
        }

        public Criteria andPlayPicNotBetween(String value1, String value2) {
            addCriterion("play_pic not between", value1, value2, "playPic");
            return (Criteria) this;
        }

        public Criteria andPlayLinkIsNull() {
            addCriterion("play_link is null");
            return (Criteria) this;
        }

        public Criteria andPlayLinkIsNotNull() {
            addCriterion("play_link is not null");
            return (Criteria) this;
        }

        public Criteria andPlayLinkEqualTo(String value) {
            addCriterion("play_link =", value, "playLink");
            return (Criteria) this;
        }

        public Criteria andPlayLinkNotEqualTo(String value) {
            addCriterion("play_link <>", value, "playLink");
            return (Criteria) this;
        }

        public Criteria andPlayLinkGreaterThan(String value) {
            addCriterion("play_link >", value, "playLink");
            return (Criteria) this;
        }

        public Criteria andPlayLinkGreaterThanOrEqualTo(String value) {
            addCriterion("play_link >=", value, "playLink");
            return (Criteria) this;
        }

        public Criteria andPlayLinkLessThan(String value) {
            addCriterion("play_link <", value, "playLink");
            return (Criteria) this;
        }

        public Criteria andPlayLinkLessThanOrEqualTo(String value) {
            addCriterion("play_link <=", value, "playLink");
            return (Criteria) this;
        }

        public Criteria andPlayLinkLike(String value) {
            addCriterion("play_link like", value, "playLink");
            return (Criteria) this;
        }

        public Criteria andPlayLinkNotLike(String value) {
            addCriterion("play_link not like", value, "playLink");
            return (Criteria) this;
        }

        public Criteria andPlayLinkIn(List<String> values) {
            addCriterion("play_link in", values, "playLink");
            return (Criteria) this;
        }

        public Criteria andPlayLinkNotIn(List<String> values) {
            addCriterion("play_link not in", values, "playLink");
            return (Criteria) this;
        }

        public Criteria andPlayLinkBetween(String value1, String value2) {
            addCriterion("play_link between", value1, value2, "playLink");
            return (Criteria) this;
        }

        public Criteria andPlayLinkNotBetween(String value1, String value2) {
            addCriterion("play_link not between", value1, value2, "playLink");
            return (Criteria) this;
        }

        public Criteria andPlayPathIsNull() {
            addCriterion("play_path is null");
            return (Criteria) this;
        }

        public Criteria andPlayPathIsNotNull() {
            addCriterion("play_path is not null");
            return (Criteria) this;
        }

        public Criteria andPlayPathEqualTo(String value) {
            addCriterion("play_path =", value, "playPath");
            return (Criteria) this;
        }

        public Criteria andPlayPathNotEqualTo(String value) {
            addCriterion("play_path <>", value, "playPath");
            return (Criteria) this;
        }

        public Criteria andPlayPathGreaterThan(String value) {
            addCriterion("play_path >", value, "playPath");
            return (Criteria) this;
        }

        public Criteria andPlayPathGreaterThanOrEqualTo(String value) {
            addCriterion("play_path >=", value, "playPath");
            return (Criteria) this;
        }

        public Criteria andPlayPathLessThan(String value) {
            addCriterion("play_path <", value, "playPath");
            return (Criteria) this;
        }

        public Criteria andPlayPathLessThanOrEqualTo(String value) {
            addCriterion("play_path <=", value, "playPath");
            return (Criteria) this;
        }

        public Criteria andPlayPathLike(String value) {
            addCriterion("play_path like", value, "playPath");
            return (Criteria) this;
        }

        public Criteria andPlayPathNotLike(String value) {
            addCriterion("play_path not like", value, "playPath");
            return (Criteria) this;
        }

        public Criteria andPlayPathIn(List<String> values) {
            addCriterion("play_path in", values, "playPath");
            return (Criteria) this;
        }

        public Criteria andPlayPathNotIn(List<String> values) {
            addCriterion("play_path not in", values, "playPath");
            return (Criteria) this;
        }

        public Criteria andPlayPathBetween(String value1, String value2) {
            addCriterion("play_path between", value1, value2, "playPath");
            return (Criteria) this;
        }

        public Criteria andPlayPathNotBetween(String value1, String value2) {
            addCriterion("play_path not between", value1, value2, "playPath");
            return (Criteria) this;
        }

        public Criteria andPlayRecommendIsNull() {
            addCriterion("play_recommend is null");
            return (Criteria) this;
        }

        public Criteria andPlayRecommendIsNotNull() {
            addCriterion("play_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andPlayRecommendEqualTo(String value) {
            addCriterion("play_recommend =", value, "playRecommend");
            return (Criteria) this;
        }

        public Criteria andPlayRecommendNotEqualTo(String value) {
            addCriterion("play_recommend <>", value, "playRecommend");
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