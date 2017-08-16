package com.cxc.course.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectiveTestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ObjectiveTestExample() {
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

        public Criteria andQuestionIdIsNull() {
            addCriterion("question_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("question_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(Long value) {
            addCriterion("question_id =", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(Long value) {
            addCriterion("question_id <>", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThan(Long value) {
            addCriterion("question_id >", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("question_id >=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(Long value) {
            addCriterion("question_id <", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(Long value) {
            addCriterion("question_id <=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<Long> values) {
            addCriterion("question_id in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<Long> values) {
            addCriterion("question_id not in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(Long value1, Long value2) {
            addCriterion("question_id between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(Long value1, Long value2) {
            addCriterion("question_id not between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andPartIdIsNull() {
            addCriterion("part_id is null");
            return (Criteria) this;
        }

        public Criteria andPartIdIsNotNull() {
            addCriterion("part_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartIdEqualTo(Long value) {
            addCriterion("part_id =", value, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdNotEqualTo(Long value) {
            addCriterion("part_id <>", value, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdGreaterThan(Long value) {
            addCriterion("part_id >", value, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdGreaterThanOrEqualTo(Long value) {
            addCriterion("part_id >=", value, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdLessThan(Long value) {
            addCriterion("part_id <", value, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdLessThanOrEqualTo(Long value) {
            addCriterion("part_id <=", value, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdIn(List<Long> values) {
            addCriterion("part_id in", values, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdNotIn(List<Long> values) {
            addCriterion("part_id not in", values, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdBetween(Long value1, Long value2) {
            addCriterion("part_id between", value1, value2, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdNotBetween(Long value1, Long value2) {
            addCriterion("part_id not between", value1, value2, "partId");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNull() {
            addCriterion("question_type is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNotNull() {
            addCriterion("question_type is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeEqualTo(Short value) {
            addCriterion("question_type =", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotEqualTo(Short value) {
            addCriterion("question_type <>", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThan(Short value) {
            addCriterion("question_type >", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("question_type >=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThan(Short value) {
            addCriterion("question_type <", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThanOrEqualTo(Short value) {
            addCriterion("question_type <=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIn(List<Short> values) {
            addCriterion("question_type in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotIn(List<Short> values) {
            addCriterion("question_type not in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeBetween(Short value1, Short value2) {
            addCriterion("question_type between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotBetween(Short value1, Short value2) {
            addCriterion("question_type not between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNull() {
            addCriterion("question is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNotNull() {
            addCriterion("question is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionEqualTo(String value) {
            addCriterion("question =", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotEqualTo(String value) {
            addCriterion("question <>", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThan(String value) {
            addCriterion("question >", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("question >=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThan(String value) {
            addCriterion("question <", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThanOrEqualTo(String value) {
            addCriterion("question <=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLike(String value) {
            addCriterion("question like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotLike(String value) {
            addCriterion("question not like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionIn(List<String> values) {
            addCriterion("question in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotIn(List<String> values) {
            addCriterion("question not in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionBetween(String value1, String value2) {
            addCriterion("question between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotBetween(String value1, String value2) {
            addCriterion("question not between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andChoicesIsNull() {
            addCriterion("choices is null");
            return (Criteria) this;
        }

        public Criteria andChoicesIsNotNull() {
            addCriterion("choices is not null");
            return (Criteria) this;
        }

        public Criteria andChoicesEqualTo(String value) {
            addCriterion("choices =", value, "choices");
            return (Criteria) this;
        }

        public Criteria andChoicesNotEqualTo(String value) {
            addCriterion("choices <>", value, "choices");
            return (Criteria) this;
        }

        public Criteria andChoicesGreaterThan(String value) {
            addCriterion("choices >", value, "choices");
            return (Criteria) this;
        }

        public Criteria andChoicesGreaterThanOrEqualTo(String value) {
            addCriterion("choices >=", value, "choices");
            return (Criteria) this;
        }

        public Criteria andChoicesLessThan(String value) {
            addCriterion("choices <", value, "choices");
            return (Criteria) this;
        }

        public Criteria andChoicesLessThanOrEqualTo(String value) {
            addCriterion("choices <=", value, "choices");
            return (Criteria) this;
        }

        public Criteria andChoicesLike(String value) {
            addCriterion("choices like", value, "choices");
            return (Criteria) this;
        }

        public Criteria andChoicesNotLike(String value) {
            addCriterion("choices not like", value, "choices");
            return (Criteria) this;
        }

        public Criteria andChoicesIn(List<String> values) {
            addCriterion("choices in", values, "choices");
            return (Criteria) this;
        }

        public Criteria andChoicesNotIn(List<String> values) {
            addCriterion("choices not in", values, "choices");
            return (Criteria) this;
        }

        public Criteria andChoicesBetween(String value1, String value2) {
            addCriterion("choices between", value1, value2, "choices");
            return (Criteria) this;
        }

        public Criteria andChoicesNotBetween(String value1, String value2) {
            addCriterion("choices not between", value1, value2, "choices");
            return (Criteria) this;
        }

        public Criteria andRightKeyIsNull() {
            addCriterion("right_key is null");
            return (Criteria) this;
        }

        public Criteria andRightKeyIsNotNull() {
            addCriterion("right_key is not null");
            return (Criteria) this;
        }

        public Criteria andRightKeyEqualTo(String value) {
            addCriterion("right_key =", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyNotEqualTo(String value) {
            addCriterion("right_key <>", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyGreaterThan(String value) {
            addCriterion("right_key >", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyGreaterThanOrEqualTo(String value) {
            addCriterion("right_key >=", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyLessThan(String value) {
            addCriterion("right_key <", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyLessThanOrEqualTo(String value) {
            addCriterion("right_key <=", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyLike(String value) {
            addCriterion("right_key like", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyNotLike(String value) {
            addCriterion("right_key not like", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyIn(List<String> values) {
            addCriterion("right_key in", values, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyNotIn(List<String> values) {
            addCriterion("right_key not in", values, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyBetween(String value1, String value2) {
            addCriterion("right_key between", value1, value2, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyNotBetween(String value1, String value2) {
            addCriterion("right_key not between", value1, value2, "rightKey");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Short value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Short value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Short value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Short value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Short value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Short value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Short> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Short> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Short value1, Short value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Short value1, Short value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andCommentOnIsNull() {
            addCriterion("comment_on is null");
            return (Criteria) this;
        }

        public Criteria andCommentOnIsNotNull() {
            addCriterion("comment_on is not null");
            return (Criteria) this;
        }

        public Criteria andCommentOnEqualTo(String value) {
            addCriterion("comment_on =", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnNotEqualTo(String value) {
            addCriterion("comment_on <>", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnGreaterThan(String value) {
            addCriterion("comment_on >", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnGreaterThanOrEqualTo(String value) {
            addCriterion("comment_on >=", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnLessThan(String value) {
            addCriterion("comment_on <", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnLessThanOrEqualTo(String value) {
            addCriterion("comment_on <=", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnLike(String value) {
            addCriterion("comment_on like", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnNotLike(String value) {
            addCriterion("comment_on not like", value, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnIn(List<String> values) {
            addCriterion("comment_on in", values, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnNotIn(List<String> values) {
            addCriterion("comment_on not in", values, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnBetween(String value1, String value2) {
            addCriterion("comment_on between", value1, value2, "commentOn");
            return (Criteria) this;
        }

        public Criteria andCommentOnNotBetween(String value1, String value2) {
            addCriterion("comment_on not between", value1, value2, "commentOn");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("sn is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("sn is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(Date value) {
            addCriterion("sn =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(Date value) {
            addCriterion("sn <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(Date value) {
            addCriterion("sn >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(Date value) {
            addCriterion("sn >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(Date value) {
            addCriterion("sn <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(Date value) {
            addCriterion("sn <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<Date> values) {
            addCriterion("sn in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<Date> values) {
            addCriterion("sn not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(Date value1, Date value2) {
            addCriterion("sn between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(Date value1, Date value2) {
            addCriterion("sn not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Long value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Long value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Long value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Long value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Long> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Long> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Long value1, Long value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
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