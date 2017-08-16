package com.cxc.course.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PartExample() {
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

        public Criteria andChapterIdIsNull() {
            addCriterion("chapter_id is null");
            return (Criteria) this;
        }

        public Criteria andChapterIdIsNotNull() {
            addCriterion("chapter_id is not null");
            return (Criteria) this;
        }

        public Criteria andChapterIdEqualTo(Long value) {
            addCriterion("chapter_id =", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotEqualTo(Long value) {
            addCriterion("chapter_id <>", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdGreaterThan(Long value) {
            addCriterion("chapter_id >", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("chapter_id >=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdLessThan(Long value) {
            addCriterion("chapter_id <", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdLessThanOrEqualTo(Long value) {
            addCriterion("chapter_id <=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdIn(List<Long> values) {
            addCriterion("chapter_id in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotIn(List<Long> values) {
            addCriterion("chapter_id not in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdBetween(Long value1, Long value2) {
            addCriterion("chapter_id between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotBetween(Long value1, Long value2) {
            addCriterion("chapter_id not between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andSectionIdIsNull() {
            addCriterion("section_id is null");
            return (Criteria) this;
        }

        public Criteria andSectionIdIsNotNull() {
            addCriterion("section_id is not null");
            return (Criteria) this;
        }

        public Criteria andSectionIdEqualTo(Long value) {
            addCriterion("section_id =", value, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdNotEqualTo(Long value) {
            addCriterion("section_id <>", value, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdGreaterThan(Long value) {
            addCriterion("section_id >", value, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("section_id >=", value, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdLessThan(Long value) {
            addCriterion("section_id <", value, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdLessThanOrEqualTo(Long value) {
            addCriterion("section_id <=", value, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdIn(List<Long> values) {
            addCriterion("section_id in", values, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdNotIn(List<Long> values) {
            addCriterion("section_id not in", values, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdBetween(Long value1, Long value2) {
            addCriterion("section_id between", value1, value2, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdNotBetween(Long value1, Long value2) {
            addCriterion("section_id not between", value1, value2, "sectionId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNull() {
            addCriterion("unit_id is null");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNotNull() {
            addCriterion("unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIdEqualTo(Long value) {
            addCriterion("unit_id =", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotEqualTo(Long value) {
            addCriterion("unit_id <>", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThan(Long value) {
            addCriterion("unit_id >", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("unit_id >=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThan(Long value) {
            addCriterion("unit_id <", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThanOrEqualTo(Long value) {
            addCriterion("unit_id <=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIn(List<Long> values) {
            addCriterion("unit_id in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotIn(List<Long> values) {
            addCriterion("unit_id not in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdBetween(Long value1, Long value2) {
            addCriterion("unit_id between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotBetween(Long value1, Long value2) {
            addCriterion("unit_id not between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andPartNameIsNull() {
            addCriterion("part_name is null");
            return (Criteria) this;
        }

        public Criteria andPartNameIsNotNull() {
            addCriterion("part_name is not null");
            return (Criteria) this;
        }

        public Criteria andPartNameEqualTo(String value) {
            addCriterion("part_name =", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameNotEqualTo(String value) {
            addCriterion("part_name <>", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameGreaterThan(String value) {
            addCriterion("part_name >", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameGreaterThanOrEqualTo(String value) {
            addCriterion("part_name >=", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameLessThan(String value) {
            addCriterion("part_name <", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameLessThanOrEqualTo(String value) {
            addCriterion("part_name <=", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameLike(String value) {
            addCriterion("part_name like", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameNotLike(String value) {
            addCriterion("part_name not like", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameIn(List<String> values) {
            addCriterion("part_name in", values, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameNotIn(List<String> values) {
            addCriterion("part_name not in", values, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameBetween(String value1, String value2) {
            addCriterion("part_name between", value1, value2, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameNotBetween(String value1, String value2) {
            addCriterion("part_name not between", value1, value2, "partName");
            return (Criteria) this;
        }

        public Criteria andPartTypeIsNull() {
            addCriterion("part_type is null");
            return (Criteria) this;
        }

        public Criteria andPartTypeIsNotNull() {
            addCriterion("part_type is not null");
            return (Criteria) this;
        }

        public Criteria andPartTypeEqualTo(Short value) {
            addCriterion("part_type =", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotEqualTo(Short value) {
            addCriterion("part_type <>", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeGreaterThan(Short value) {
            addCriterion("part_type >", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("part_type >=", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeLessThan(Short value) {
            addCriterion("part_type <", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeLessThanOrEqualTo(Short value) {
            addCriterion("part_type <=", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeIn(List<Short> values) {
            addCriterion("part_type in", values, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotIn(List<Short> values) {
            addCriterion("part_type not in", values, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeBetween(Short value1, Short value2) {
            addCriterion("part_type between", value1, value2, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotBetween(Short value1, Short value2) {
            addCriterion("part_type not between", value1, value2, "partType");
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

        public Criteria andResourceIdIsNull() {
            addCriterion("resource_id is null");
            return (Criteria) this;
        }

        public Criteria andResourceIdIsNotNull() {
            addCriterion("resource_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIdEqualTo(Long value) {
            addCriterion("resource_id =", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotEqualTo(Long value) {
            addCriterion("resource_id <>", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThan(Long value) {
            addCriterion("resource_id >", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("resource_id >=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThan(Long value) {
            addCriterion("resource_id <", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThanOrEqualTo(Long value) {
            addCriterion("resource_id <=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdIn(List<Long> values) {
            addCriterion("resource_id in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotIn(List<Long> values) {
            addCriterion("resource_id not in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdBetween(Long value1, Long value2) {
            addCriterion("resource_id between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotBetween(Long value1, Long value2) {
            addCriterion("resource_id not between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListIsNull() {
            addCriterion("objective_test_list is null");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListIsNotNull() {
            addCriterion("objective_test_list is not null");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListEqualTo(String value) {
            addCriterion("objective_test_list =", value, "objectiveTestList");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListNotEqualTo(String value) {
            addCriterion("objective_test_list <>", value, "objectiveTestList");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListGreaterThan(String value) {
            addCriterion("objective_test_list >", value, "objectiveTestList");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListGreaterThanOrEqualTo(String value) {
            addCriterion("objective_test_list >=", value, "objectiveTestList");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListLessThan(String value) {
            addCriterion("objective_test_list <", value, "objectiveTestList");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListLessThanOrEqualTo(String value) {
            addCriterion("objective_test_list <=", value, "objectiveTestList");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListLike(String value) {
            addCriterion("objective_test_list like", value, "objectiveTestList");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListNotLike(String value) {
            addCriterion("objective_test_list not like", value, "objectiveTestList");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListIn(List<String> values) {
            addCriterion("objective_test_list in", values, "objectiveTestList");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListNotIn(List<String> values) {
            addCriterion("objective_test_list not in", values, "objectiveTestList");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListBetween(String value1, String value2) {
            addCriterion("objective_test_list between", value1, value2, "objectiveTestList");
            return (Criteria) this;
        }

        public Criteria andObjectiveTestListNotBetween(String value1, String value2) {
            addCriterion("objective_test_list not between", value1, value2, "objectiveTestList");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListIsNull() {
            addCriterion("objective_right_key_list is null");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListIsNotNull() {
            addCriterion("objective_right_key_list is not null");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListEqualTo(String value) {
            addCriterion("objective_right_key_list =", value, "objectiveRightKeyList");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListNotEqualTo(String value) {
            addCriterion("objective_right_key_list <>", value, "objectiveRightKeyList");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListGreaterThan(String value) {
            addCriterion("objective_right_key_list >", value, "objectiveRightKeyList");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListGreaterThanOrEqualTo(String value) {
            addCriterion("objective_right_key_list >=", value, "objectiveRightKeyList");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListLessThan(String value) {
            addCriterion("objective_right_key_list <", value, "objectiveRightKeyList");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListLessThanOrEqualTo(String value) {
            addCriterion("objective_right_key_list <=", value, "objectiveRightKeyList");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListLike(String value) {
            addCriterion("objective_right_key_list like", value, "objectiveRightKeyList");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListNotLike(String value) {
            addCriterion("objective_right_key_list not like", value, "objectiveRightKeyList");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListIn(List<String> values) {
            addCriterion("objective_right_key_list in", values, "objectiveRightKeyList");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListNotIn(List<String> values) {
            addCriterion("objective_right_key_list not in", values, "objectiveRightKeyList");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListBetween(String value1, String value2) {
            addCriterion("objective_right_key_list between", value1, value2, "objectiveRightKeyList");
            return (Criteria) this;
        }

        public Criteria andObjectiveRightKeyListNotBetween(String value1, String value2) {
            addCriterion("objective_right_key_list not between", value1, value2, "objectiveRightKeyList");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListIsNull() {
            addCriterion("subjective_test_list is null");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListIsNotNull() {
            addCriterion("subjective_test_list is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListEqualTo(String value) {
            addCriterion("subjective_test_list =", value, "subjectiveTestList");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListNotEqualTo(String value) {
            addCriterion("subjective_test_list <>", value, "subjectiveTestList");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListGreaterThan(String value) {
            addCriterion("subjective_test_list >", value, "subjectiveTestList");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListGreaterThanOrEqualTo(String value) {
            addCriterion("subjective_test_list >=", value, "subjectiveTestList");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListLessThan(String value) {
            addCriterion("subjective_test_list <", value, "subjectiveTestList");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListLessThanOrEqualTo(String value) {
            addCriterion("subjective_test_list <=", value, "subjectiveTestList");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListLike(String value) {
            addCriterion("subjective_test_list like", value, "subjectiveTestList");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListNotLike(String value) {
            addCriterion("subjective_test_list not like", value, "subjectiveTestList");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListIn(List<String> values) {
            addCriterion("subjective_test_list in", values, "subjectiveTestList");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListNotIn(List<String> values) {
            addCriterion("subjective_test_list not in", values, "subjectiveTestList");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListBetween(String value1, String value2) {
            addCriterion("subjective_test_list between", value1, value2, "subjectiveTestList");
            return (Criteria) this;
        }

        public Criteria andSubjectiveTestListNotBetween(String value1, String value2) {
            addCriterion("subjective_test_list not between", value1, value2, "subjectiveTestList");
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