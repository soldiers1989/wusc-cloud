package com.cxc.course.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Long value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Long value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Long value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Long value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Long value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Long> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Long> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Long value1, Long value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Long value1, Long value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andTutorIdIsNull() {
            addCriterion("tutor_id is null");
            return (Criteria) this;
        }

        public Criteria andTutorIdIsNotNull() {
            addCriterion("tutor_id is not null");
            return (Criteria) this;
        }

        public Criteria andTutorIdEqualTo(String value) {
            addCriterion("tutor_id =", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdNotEqualTo(String value) {
            addCriterion("tutor_id <>", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdGreaterThan(String value) {
            addCriterion("tutor_id >", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdGreaterThanOrEqualTo(String value) {
            addCriterion("tutor_id >=", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdLessThan(String value) {
            addCriterion("tutor_id <", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdLessThanOrEqualTo(String value) {
            addCriterion("tutor_id <=", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdLike(String value) {
            addCriterion("tutor_id like", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdNotLike(String value) {
            addCriterion("tutor_id not like", value, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdIn(List<String> values) {
            addCriterion("tutor_id in", values, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdNotIn(List<String> values) {
            addCriterion("tutor_id not in", values, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdBetween(String value1, String value2) {
            addCriterion("tutor_id between", value1, value2, "tutorId");
            return (Criteria) this;
        }

        public Criteria andTutorIdNotBetween(String value1, String value2) {
            addCriterion("tutor_id not between", value1, value2, "tutorId");
            return (Criteria) this;
        }

        public Criteria andDepictIsNull() {
            addCriterion("depict is null");
            return (Criteria) this;
        }

        public Criteria andDepictIsNotNull() {
            addCriterion("depict is not null");
            return (Criteria) this;
        }

        public Criteria andDepictEqualTo(String value) {
            addCriterion("depict =", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictNotEqualTo(String value) {
            addCriterion("depict <>", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictGreaterThan(String value) {
            addCriterion("depict >", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictGreaterThanOrEqualTo(String value) {
            addCriterion("depict >=", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictLessThan(String value) {
            addCriterion("depict <", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictLessThanOrEqualTo(String value) {
            addCriterion("depict <=", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictLike(String value) {
            addCriterion("depict like", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictNotLike(String value) {
            addCriterion("depict not like", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictIn(List<String> values) {
            addCriterion("depict in", values, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictNotIn(List<String> values) {
            addCriterion("depict not in", values, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictBetween(String value1, String value2) {
            addCriterion("depict between", value1, value2, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictNotBetween(String value1, String value2) {
            addCriterion("depict not between", value1, value2, "depict");
            return (Criteria) this;
        }

        public Criteria andIconUrlIsNull() {
            addCriterion("icon_url is null");
            return (Criteria) this;
        }

        public Criteria andIconUrlIsNotNull() {
            addCriterion("icon_url is not null");
            return (Criteria) this;
        }

        public Criteria andIconUrlEqualTo(String value) {
            addCriterion("icon_url =", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlNotEqualTo(String value) {
            addCriterion("icon_url <>", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlGreaterThan(String value) {
            addCriterion("icon_url >", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlGreaterThanOrEqualTo(String value) {
            addCriterion("icon_url >=", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlLessThan(String value) {
            addCriterion("icon_url <", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlLessThanOrEqualTo(String value) {
            addCriterion("icon_url <=", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlLike(String value) {
            addCriterion("icon_url like", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlNotLike(String value) {
            addCriterion("icon_url not like", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlIn(List<String> values) {
            addCriterion("icon_url in", values, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlNotIn(List<String> values) {
            addCriterion("icon_url not in", values, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlBetween(String value1, String value2) {
            addCriterion("icon_url between", value1, value2, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlNotBetween(String value1, String value2) {
            addCriterion("icon_url not between", value1, value2, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIsNull() {
            addCriterion("picture_url is null");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIsNotNull() {
            addCriterion("picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andPictureUrlEqualTo(String value) {
            addCriterion("picture_url =", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotEqualTo(String value) {
            addCriterion("picture_url <>", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlGreaterThan(String value) {
            addCriterion("picture_url >", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("picture_url >=", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLessThan(String value) {
            addCriterion("picture_url <", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLessThanOrEqualTo(String value) {
            addCriterion("picture_url <=", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLike(String value) {
            addCriterion("picture_url like", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotLike(String value) {
            addCriterion("picture_url not like", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIn(List<String> values) {
            addCriterion("picture_url in", values, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotIn(List<String> values) {
            addCriterion("picture_url not in", values, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlBetween(String value1, String value2) {
            addCriterion("picture_url between", value1, value2, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotBetween(String value1, String value2) {
            addCriterion("picture_url not between", value1, value2, "pictureUrl");
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

        public Criteria andRecommendedLevelIsNull() {
            addCriterion("recommended_level is null");
            return (Criteria) this;
        }

        public Criteria andRecommendedLevelIsNotNull() {
            addCriterion("recommended_level is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendedLevelEqualTo(Short value) {
            addCriterion("recommended_level =", value, "recommendedLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendedLevelNotEqualTo(Short value) {
            addCriterion("recommended_level <>", value, "recommendedLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendedLevelGreaterThan(Short value) {
            addCriterion("recommended_level >", value, "recommendedLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendedLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("recommended_level >=", value, "recommendedLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendedLevelLessThan(Short value) {
            addCriterion("recommended_level <", value, "recommendedLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendedLevelLessThanOrEqualTo(Short value) {
            addCriterion("recommended_level <=", value, "recommendedLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendedLevelIn(List<Short> values) {
            addCriterion("recommended_level in", values, "recommendedLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendedLevelNotIn(List<Short> values) {
            addCriterion("recommended_level not in", values, "recommendedLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendedLevelBetween(Short value1, Short value2) {
            addCriterion("recommended_level between", value1, value2, "recommendedLevel");
            return (Criteria) this;
        }

        public Criteria andRecommendedLevelNotBetween(Short value1, Short value2) {
            addCriterion("recommended_level not between", value1, value2, "recommendedLevel");
            return (Criteria) this;
        }

        public Criteria andClickRateIsNull() {
            addCriterion("click_rate is null");
            return (Criteria) this;
        }

        public Criteria andClickRateIsNotNull() {
            addCriterion("click_rate is not null");
            return (Criteria) this;
        }

        public Criteria andClickRateEqualTo(Long value) {
            addCriterion("click_rate =", value, "clickRate");
            return (Criteria) this;
        }

        public Criteria andClickRateNotEqualTo(Long value) {
            addCriterion("click_rate <>", value, "clickRate");
            return (Criteria) this;
        }

        public Criteria andClickRateGreaterThan(Long value) {
            addCriterion("click_rate >", value, "clickRate");
            return (Criteria) this;
        }

        public Criteria andClickRateGreaterThanOrEqualTo(Long value) {
            addCriterion("click_rate >=", value, "clickRate");
            return (Criteria) this;
        }

        public Criteria andClickRateLessThan(Long value) {
            addCriterion("click_rate <", value, "clickRate");
            return (Criteria) this;
        }

        public Criteria andClickRateLessThanOrEqualTo(Long value) {
            addCriterion("click_rate <=", value, "clickRate");
            return (Criteria) this;
        }

        public Criteria andClickRateIn(List<Long> values) {
            addCriterion("click_rate in", values, "clickRate");
            return (Criteria) this;
        }

        public Criteria andClickRateNotIn(List<Long> values) {
            addCriterion("click_rate not in", values, "clickRate");
            return (Criteria) this;
        }

        public Criteria andClickRateBetween(Long value1, Long value2) {
            addCriterion("click_rate between", value1, value2, "clickRate");
            return (Criteria) this;
        }

        public Criteria andClickRateNotBetween(Long value1, Long value2) {
            addCriterion("click_rate not between", value1, value2, "clickRate");
            return (Criteria) this;
        }

        public Criteria andParticipantsNumIsNull() {
            addCriterion("participants_num is null");
            return (Criteria) this;
        }

        public Criteria andParticipantsNumIsNotNull() {
            addCriterion("participants_num is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantsNumEqualTo(Long value) {
            addCriterion("participants_num =", value, "participantsNum");
            return (Criteria) this;
        }

        public Criteria andParticipantsNumNotEqualTo(Long value) {
            addCriterion("participants_num <>", value, "participantsNum");
            return (Criteria) this;
        }

        public Criteria andParticipantsNumGreaterThan(Long value) {
            addCriterion("participants_num >", value, "participantsNum");
            return (Criteria) this;
        }

        public Criteria andParticipantsNumGreaterThanOrEqualTo(Long value) {
            addCriterion("participants_num >=", value, "participantsNum");
            return (Criteria) this;
        }

        public Criteria andParticipantsNumLessThan(Long value) {
            addCriterion("participants_num <", value, "participantsNum");
            return (Criteria) this;
        }

        public Criteria andParticipantsNumLessThanOrEqualTo(Long value) {
            addCriterion("participants_num <=", value, "participantsNum");
            return (Criteria) this;
        }

        public Criteria andParticipantsNumIn(List<Long> values) {
            addCriterion("participants_num in", values, "participantsNum");
            return (Criteria) this;
        }

        public Criteria andParticipantsNumNotIn(List<Long> values) {
            addCriterion("participants_num not in", values, "participantsNum");
            return (Criteria) this;
        }

        public Criteria andParticipantsNumBetween(Long value1, Long value2) {
            addCriterion("participants_num between", value1, value2, "participantsNum");
            return (Criteria) this;
        }

        public Criteria andParticipantsNumNotBetween(Long value1, Long value2) {
            addCriterion("participants_num not between", value1, value2, "participantsNum");
            return (Criteria) this;
        }

        public Criteria andAttendanceGradeIsNull() {
            addCriterion("attendance_grade is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceGradeIsNotNull() {
            addCriterion("attendance_grade is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceGradeEqualTo(Short value) {
            addCriterion("attendance_grade =", value, "attendanceGrade");
            return (Criteria) this;
        }

        public Criteria andAttendanceGradeNotEqualTo(Short value) {
            addCriterion("attendance_grade <>", value, "attendanceGrade");
            return (Criteria) this;
        }

        public Criteria andAttendanceGradeGreaterThan(Short value) {
            addCriterion("attendance_grade >", value, "attendanceGrade");
            return (Criteria) this;
        }

        public Criteria andAttendanceGradeGreaterThanOrEqualTo(Short value) {
            addCriterion("attendance_grade >=", value, "attendanceGrade");
            return (Criteria) this;
        }

        public Criteria andAttendanceGradeLessThan(Short value) {
            addCriterion("attendance_grade <", value, "attendanceGrade");
            return (Criteria) this;
        }

        public Criteria andAttendanceGradeLessThanOrEqualTo(Short value) {
            addCriterion("attendance_grade <=", value, "attendanceGrade");
            return (Criteria) this;
        }

        public Criteria andAttendanceGradeIn(List<Short> values) {
            addCriterion("attendance_grade in", values, "attendanceGrade");
            return (Criteria) this;
        }

        public Criteria andAttendanceGradeNotIn(List<Short> values) {
            addCriterion("attendance_grade not in", values, "attendanceGrade");
            return (Criteria) this;
        }

        public Criteria andAttendanceGradeBetween(Short value1, Short value2) {
            addCriterion("attendance_grade between", value1, value2, "attendanceGrade");
            return (Criteria) this;
        }

        public Criteria andAttendanceGradeNotBetween(Short value1, Short value2) {
            addCriterion("attendance_grade not between", value1, value2, "attendanceGrade");
            return (Criteria) this;
        }

        public Criteria andExercisesGradeIsNull() {
            addCriterion("exercises_grade is null");
            return (Criteria) this;
        }

        public Criteria andExercisesGradeIsNotNull() {
            addCriterion("exercises_grade is not null");
            return (Criteria) this;
        }

        public Criteria andExercisesGradeEqualTo(Short value) {
            addCriterion("exercises_grade =", value, "exercisesGrade");
            return (Criteria) this;
        }

        public Criteria andExercisesGradeNotEqualTo(Short value) {
            addCriterion("exercises_grade <>", value, "exercisesGrade");
            return (Criteria) this;
        }

        public Criteria andExercisesGradeGreaterThan(Short value) {
            addCriterion("exercises_grade >", value, "exercisesGrade");
            return (Criteria) this;
        }

        public Criteria andExercisesGradeGreaterThanOrEqualTo(Short value) {
            addCriterion("exercises_grade >=", value, "exercisesGrade");
            return (Criteria) this;
        }

        public Criteria andExercisesGradeLessThan(Short value) {
            addCriterion("exercises_grade <", value, "exercisesGrade");
            return (Criteria) this;
        }

        public Criteria andExercisesGradeLessThanOrEqualTo(Short value) {
            addCriterion("exercises_grade <=", value, "exercisesGrade");
            return (Criteria) this;
        }

        public Criteria andExercisesGradeIn(List<Short> values) {
            addCriterion("exercises_grade in", values, "exercisesGrade");
            return (Criteria) this;
        }

        public Criteria andExercisesGradeNotIn(List<Short> values) {
            addCriterion("exercises_grade not in", values, "exercisesGrade");
            return (Criteria) this;
        }

        public Criteria andExercisesGradeBetween(Short value1, Short value2) {
            addCriterion("exercises_grade between", value1, value2, "exercisesGrade");
            return (Criteria) this;
        }

        public Criteria andExercisesGradeNotBetween(Short value1, Short value2) {
            addCriterion("exercises_grade not between", value1, value2, "exercisesGrade");
            return (Criteria) this;
        }

        public Criteria andExamineGradeIsNull() {
            addCriterion("examine_grade is null");
            return (Criteria) this;
        }

        public Criteria andExamineGradeIsNotNull() {
            addCriterion("examine_grade is not null");
            return (Criteria) this;
        }

        public Criteria andExamineGradeEqualTo(Short value) {
            addCriterion("examine_grade =", value, "examineGrade");
            return (Criteria) this;
        }

        public Criteria andExamineGradeNotEqualTo(Short value) {
            addCriterion("examine_grade <>", value, "examineGrade");
            return (Criteria) this;
        }

        public Criteria andExamineGradeGreaterThan(Short value) {
            addCriterion("examine_grade >", value, "examineGrade");
            return (Criteria) this;
        }

        public Criteria andExamineGradeGreaterThanOrEqualTo(Short value) {
            addCriterion("examine_grade >=", value, "examineGrade");
            return (Criteria) this;
        }

        public Criteria andExamineGradeLessThan(Short value) {
            addCriterion("examine_grade <", value, "examineGrade");
            return (Criteria) this;
        }

        public Criteria andExamineGradeLessThanOrEqualTo(Short value) {
            addCriterion("examine_grade <=", value, "examineGrade");
            return (Criteria) this;
        }

        public Criteria andExamineGradeIn(List<Short> values) {
            addCriterion("examine_grade in", values, "examineGrade");
            return (Criteria) this;
        }

        public Criteria andExamineGradeNotIn(List<Short> values) {
            addCriterion("examine_grade not in", values, "examineGrade");
            return (Criteria) this;
        }

        public Criteria andExamineGradeBetween(Short value1, Short value2) {
            addCriterion("examine_grade between", value1, value2, "examineGrade");
            return (Criteria) this;
        }

        public Criteria andExamineGradeNotBetween(Short value1, Short value2) {
            addCriterion("examine_grade not between", value1, value2, "examineGrade");
            return (Criteria) this;
        }

        public Criteria andPassingGradeIsNull() {
            addCriterion("passing_grade is null");
            return (Criteria) this;
        }

        public Criteria andPassingGradeIsNotNull() {
            addCriterion("passing_grade is not null");
            return (Criteria) this;
        }

        public Criteria andPassingGradeEqualTo(Short value) {
            addCriterion("passing_grade =", value, "passingGrade");
            return (Criteria) this;
        }

        public Criteria andPassingGradeNotEqualTo(Short value) {
            addCriterion("passing_grade <>", value, "passingGrade");
            return (Criteria) this;
        }

        public Criteria andPassingGradeGreaterThan(Short value) {
            addCriterion("passing_grade >", value, "passingGrade");
            return (Criteria) this;
        }

        public Criteria andPassingGradeGreaterThanOrEqualTo(Short value) {
            addCriterion("passing_grade >=", value, "passingGrade");
            return (Criteria) this;
        }

        public Criteria andPassingGradeLessThan(Short value) {
            addCriterion("passing_grade <", value, "passingGrade");
            return (Criteria) this;
        }

        public Criteria andPassingGradeLessThanOrEqualTo(Short value) {
            addCriterion("passing_grade <=", value, "passingGrade");
            return (Criteria) this;
        }

        public Criteria andPassingGradeIn(List<Short> values) {
            addCriterion("passing_grade in", values, "passingGrade");
            return (Criteria) this;
        }

        public Criteria andPassingGradeNotIn(List<Short> values) {
            addCriterion("passing_grade not in", values, "passingGrade");
            return (Criteria) this;
        }

        public Criteria andPassingGradeBetween(Short value1, Short value2) {
            addCriterion("passing_grade between", value1, value2, "passingGrade");
            return (Criteria) this;
        }

        public Criteria andPassingGradeNotBetween(Short value1, Short value2) {
            addCriterion("passing_grade not between", value1, value2, "passingGrade");
            return (Criteria) this;
        }

        public Criteria andIsLeafNodeIsNull() {
            addCriterion("is_leaf_node is null");
            return (Criteria) this;
        }

        public Criteria andIsLeafNodeIsNotNull() {
            addCriterion("is_leaf_node is not null");
            return (Criteria) this;
        }

        public Criteria andIsLeafNodeEqualTo(Boolean value) {
            addCriterion("is_leaf_node =", value, "isLeafNode");
            return (Criteria) this;
        }

        public Criteria andIsLeafNodeNotEqualTo(Boolean value) {
            addCriterion("is_leaf_node <>", value, "isLeafNode");
            return (Criteria) this;
        }

        public Criteria andIsLeafNodeGreaterThan(Boolean value) {
            addCriterion("is_leaf_node >", value, "isLeafNode");
            return (Criteria) this;
        }

        public Criteria andIsLeafNodeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_leaf_node >=", value, "isLeafNode");
            return (Criteria) this;
        }

        public Criteria andIsLeafNodeLessThan(Boolean value) {
            addCriterion("is_leaf_node <", value, "isLeafNode");
            return (Criteria) this;
        }

        public Criteria andIsLeafNodeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_leaf_node <=", value, "isLeafNode");
            return (Criteria) this;
        }

        public Criteria andIsLeafNodeIn(List<Boolean> values) {
            addCriterion("is_leaf_node in", values, "isLeafNode");
            return (Criteria) this;
        }

        public Criteria andIsLeafNodeNotIn(List<Boolean> values) {
            addCriterion("is_leaf_node not in", values, "isLeafNode");
            return (Criteria) this;
        }

        public Criteria andIsLeafNodeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_leaf_node between", value1, value2, "isLeafNode");
            return (Criteria) this;
        }

        public Criteria andIsLeafNodeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_leaf_node not between", value1, value2, "isLeafNode");
            return (Criteria) this;
        }

        public Criteria andPartIdListIsNull() {
            addCriterion("part_id_list is null");
            return (Criteria) this;
        }

        public Criteria andPartIdListIsNotNull() {
            addCriterion("part_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andPartIdListEqualTo(String value) {
            addCriterion("part_id_list =", value, "partIdList");
            return (Criteria) this;
        }

        public Criteria andPartIdListNotEqualTo(String value) {
            addCriterion("part_id_list <>", value, "partIdList");
            return (Criteria) this;
        }

        public Criteria andPartIdListGreaterThan(String value) {
            addCriterion("part_id_list >", value, "partIdList");
            return (Criteria) this;
        }

        public Criteria andPartIdListGreaterThanOrEqualTo(String value) {
            addCriterion("part_id_list >=", value, "partIdList");
            return (Criteria) this;
        }

        public Criteria andPartIdListLessThan(String value) {
            addCriterion("part_id_list <", value, "partIdList");
            return (Criteria) this;
        }

        public Criteria andPartIdListLessThanOrEqualTo(String value) {
            addCriterion("part_id_list <=", value, "partIdList");
            return (Criteria) this;
        }

        public Criteria andPartIdListLike(String value) {
            addCriterion("part_id_list like", value, "partIdList");
            return (Criteria) this;
        }

        public Criteria andPartIdListNotLike(String value) {
            addCriterion("part_id_list not like", value, "partIdList");
            return (Criteria) this;
        }

        public Criteria andPartIdListIn(List<String> values) {
            addCriterion("part_id_list in", values, "partIdList");
            return (Criteria) this;
        }

        public Criteria andPartIdListNotIn(List<String> values) {
            addCriterion("part_id_list not in", values, "partIdList");
            return (Criteria) this;
        }

        public Criteria andPartIdListBetween(String value1, String value2) {
            addCriterion("part_id_list between", value1, value2, "partIdList");
            return (Criteria) this;
        }

        public Criteria andPartIdListNotBetween(String value1, String value2) {
            addCriterion("part_id_list not between", value1, value2, "partIdList");
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

        public Criteria andLearningTargetNumberIsNull() {
            addCriterion("learning_target_number is null");
            return (Criteria) this;
        }

        public Criteria andLearningTargetNumberIsNotNull() {
            addCriterion("learning_target_number is not null");
            return (Criteria) this;
        }

        public Criteria andLearningTargetNumberEqualTo(Short value) {
            addCriterion("learning_target_number =", value, "learningTargetNumber");
            return (Criteria) this;
        }

        public Criteria andLearningTargetNumberNotEqualTo(Short value) {
            addCriterion("learning_target_number <>", value, "learningTargetNumber");
            return (Criteria) this;
        }

        public Criteria andLearningTargetNumberGreaterThan(Short value) {
            addCriterion("learning_target_number >", value, "learningTargetNumber");
            return (Criteria) this;
        }

        public Criteria andLearningTargetNumberGreaterThanOrEqualTo(Short value) {
            addCriterion("learning_target_number >=", value, "learningTargetNumber");
            return (Criteria) this;
        }

        public Criteria andLearningTargetNumberLessThan(Short value) {
            addCriterion("learning_target_number <", value, "learningTargetNumber");
            return (Criteria) this;
        }

        public Criteria andLearningTargetNumberLessThanOrEqualTo(Short value) {
            addCriterion("learning_target_number <=", value, "learningTargetNumber");
            return (Criteria) this;
        }

        public Criteria andLearningTargetNumberIn(List<Short> values) {
            addCriterion("learning_target_number in", values, "learningTargetNumber");
            return (Criteria) this;
        }

        public Criteria andLearningTargetNumberNotIn(List<Short> values) {
            addCriterion("learning_target_number not in", values, "learningTargetNumber");
            return (Criteria) this;
        }

        public Criteria andLearningTargetNumberBetween(Short value1, Short value2) {
            addCriterion("learning_target_number between", value1, value2, "learningTargetNumber");
            return (Criteria) this;
        }

        public Criteria andLearningTargetNumberNotBetween(Short value1, Short value2) {
            addCriterion("learning_target_number not between", value1, value2, "learningTargetNumber");
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