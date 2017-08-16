package com.cxc.course.model;

import java.util.ArrayList;
import java.util.List;

public class TutorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TutorExample() {
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

        public Criteria andTutorIdIsNull() {
            addCriterion("tutor_id is null");
            return (Criteria) this;
        }

        public Criteria andTutorIdIsNotNull() {
            addCriterion("tutor_id is not null");
            return (Criteria) this;
        }

        public Criteria andTutorIdEqualTo(Long value) {
            addCriterion("tutor_id =", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdNotEqualTo(Long value) {
            addCriterion("tutor_id <>", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdGreaterThan(Long value) {
            addCriterion("tutor_id >", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tutor_id >=", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdLessThan(Long value) {
            addCriterion("tutor_id <", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdLessThanOrEqualTo(Long value) {
            addCriterion("tutor_id <=", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdIn(List<Long> values) {
            addCriterion("tutor_id in", values, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdNotIn(List<Long> values) {
            addCriterion("tutor_id not in", values, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdBetween(Long value1, Long value2) {
            addCriterion("tutor_id between", value1, value2, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdNotBetween(Long value1, Long value2) {
            addCriterion("tutor_id not between", value1, value2, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorNameIsNull() {
            addCriterion("tutor_name is null");
            return (Criteria) this;
        }

        public Criteria andTutorNameIsNotNull() {
            addCriterion("tutor_name is not null");
            return (Criteria) this;
        }

        public Criteria andTutorNameEqualTo(String value) {
            addCriterion("tutor_name =", value, "tutorName");
            return (Criteria) this;
        }

        public Criteria andTutorNameNotEqualTo(String value) {
            addCriterion("tutor_name <>", value, "tutorName");
            return (Criteria) this;
        }

        public Criteria andTutorNameGreaterThan(String value) {
            addCriterion("tutor_name >", value, "tutorName");
            return (Criteria) this;
        }

        public Criteria andTutorNameGreaterThanOrEqualTo(String value) {
            addCriterion("tutor_name >=", value, "tutorName");
            return (Criteria) this;
        }

        public Criteria andTutorNameLessThan(String value) {
            addCriterion("tutor_name <", value, "tutorName");
            return (Criteria) this;
        }

        public Criteria andTutorNameLessThanOrEqualTo(String value) {
            addCriterion("tutor_name <=", value, "tutorName");
            return (Criteria) this;
        }

        public Criteria andTutorNameLike(String value) {
            addCriterion("tutor_name like", value, "tutorName");
            return (Criteria) this;
        }

        public Criteria andTutorNameNotLike(String value) {
            addCriterion("tutor_name not like", value, "tutorName");
            return (Criteria) this;
        }

        public Criteria andTutorNameIn(List<String> values) {
            addCriterion("tutor_name in", values, "tutorName");
            return (Criteria) this;
        }

        public Criteria andTutorNameNotIn(List<String> values) {
            addCriterion("tutor_name not in", values, "tutorName");
            return (Criteria) this;
        }

        public Criteria andTutorNameBetween(String value1, String value2) {
            addCriterion("tutor_name between", value1, value2, "tutorName");
            return (Criteria) this;
        }

        public Criteria andTutorNameNotBetween(String value1, String value2) {
            addCriterion("tutor_name not between", value1, value2, "tutorName");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIsNull() {
            addCriterion("photo_url is null");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIsNotNull() {
            addCriterion("photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlEqualTo(String value) {
            addCriterion("photo_url =", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotEqualTo(String value) {
            addCriterion("photo_url <>", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThan(String value) {
            addCriterion("photo_url >", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("photo_url >=", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThan(String value) {
            addCriterion("photo_url <", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("photo_url <=", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLike(String value) {
            addCriterion("photo_url like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotLike(String value) {
            addCriterion("photo_url not like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIn(List<String> values) {
            addCriterion("photo_url in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotIn(List<String> values) {
            addCriterion("photo_url not in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlBetween(String value1, String value2) {
            addCriterion("photo_url between", value1, value2, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("photo_url not between", value1, value2, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andResumeIsNull() {
            addCriterion("resume is null");
            return (Criteria) this;
        }

        public Criteria andResumeIsNotNull() {
            addCriterion("resume is not null");
            return (Criteria) this;
        }

        public Criteria andResumeEqualTo(String value) {
            addCriterion("resume =", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotEqualTo(String value) {
            addCriterion("resume <>", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeGreaterThan(String value) {
            addCriterion("resume >", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeGreaterThanOrEqualTo(String value) {
            addCriterion("resume >=", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeLessThan(String value) {
            addCriterion("resume <", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeLessThanOrEqualTo(String value) {
            addCriterion("resume <=", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeLike(String value) {
            addCriterion("resume like", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotLike(String value) {
            addCriterion("resume not like", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeIn(List<String> values) {
            addCriterion("resume in", values, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotIn(List<String> values) {
            addCriterion("resume not in", values, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeBetween(String value1, String value2) {
            addCriterion("resume between", value1, value2, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotBetween(String value1, String value2) {
            addCriterion("resume not between", value1, value2, "resume");
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