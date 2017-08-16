package com.cxc.system.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemVersionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemVersionExample() {
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

        public Criteria andSystemVersionIdIsNull() {
            addCriterion("system_version_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIdIsNotNull() {
            addCriterion("system_version_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIdEqualTo(Long value) {
            addCriterion("system_version_id =", value, "systemVersionId");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIdNotEqualTo(Long value) {
            addCriterion("system_version_id <>", value, "systemVersionId");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIdGreaterThan(Long value) {
            addCriterion("system_version_id >", value, "systemVersionId");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("system_version_id >=", value, "systemVersionId");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIdLessThan(Long value) {
            addCriterion("system_version_id <", value, "systemVersionId");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIdLessThanOrEqualTo(Long value) {
            addCriterion("system_version_id <=", value, "systemVersionId");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIdIn(List<Long> values) {
            addCriterion("system_version_id in", values, "systemVersionId");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIdNotIn(List<Long> values) {
            addCriterion("system_version_id not in", values, "systemVersionId");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIdBetween(Long value1, Long value2) {
            addCriterion("system_version_id between", value1, value2, "systemVersionId");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIdNotBetween(Long value1, Long value2) {
            addCriterion("system_version_id not between", value1, value2, "systemVersionId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNull() {
            addCriterion("system_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("system_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(Long value) {
            addCriterion("system_id =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(Long value) {
            addCriterion("system_id <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(Long value) {
            addCriterion("system_id >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("system_id >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(Long value) {
            addCriterion("system_id <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(Long value) {
            addCriterion("system_id <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<Long> values) {
            addCriterion("system_id in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<Long> values) {
            addCriterion("system_id not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(Long value1, Long value2) {
            addCriterion("system_id between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(Long value1, Long value2) {
            addCriterion("system_id not between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andCompatibleNoIsNull() {
            addCriterion("compatible_no is null");
            return (Criteria) this;
        }

        public Criteria andCompatibleNoIsNotNull() {
            addCriterion("compatible_no is not null");
            return (Criteria) this;
        }

        public Criteria andCompatibleNoEqualTo(Integer value) {
            addCriterion("compatible_no =", value, "compatibleNo");
            return (Criteria) this;
        }

        public Criteria andCompatibleNoNotEqualTo(Integer value) {
            addCriterion("compatible_no <>", value, "compatibleNo");
            return (Criteria) this;
        }

        public Criteria andCompatibleNoGreaterThan(Integer value) {
            addCriterion("compatible_no >", value, "compatibleNo");
            return (Criteria) this;
        }

        public Criteria andCompatibleNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("compatible_no >=", value, "compatibleNo");
            return (Criteria) this;
        }

        public Criteria andCompatibleNoLessThan(Integer value) {
            addCriterion("compatible_no <", value, "compatibleNo");
            return (Criteria) this;
        }

        public Criteria andCompatibleNoLessThanOrEqualTo(Integer value) {
            addCriterion("compatible_no <=", value, "compatibleNo");
            return (Criteria) this;
        }

        public Criteria andCompatibleNoIn(List<Integer> values) {
            addCriterion("compatible_no in", values, "compatibleNo");
            return (Criteria) this;
        }

        public Criteria andCompatibleNoNotIn(List<Integer> values) {
            addCriterion("compatible_no not in", values, "compatibleNo");
            return (Criteria) this;
        }

        public Criteria andCompatibleNoBetween(Integer value1, Integer value2) {
            addCriterion("compatible_no between", value1, value2, "compatibleNo");
            return (Criteria) this;
        }

        public Criteria andCompatibleNoNotBetween(Integer value1, Integer value2) {
            addCriterion("compatible_no not between", value1, value2, "compatibleNo");
            return (Criteria) this;
        }

        public Criteria andMainVersionIsNull() {
            addCriterion("main_version is null");
            return (Criteria) this;
        }

        public Criteria andMainVersionIsNotNull() {
            addCriterion("main_version is not null");
            return (Criteria) this;
        }

        public Criteria andMainVersionEqualTo(Integer value) {
            addCriterion("main_version =", value, "mainVersion");
            return (Criteria) this;
        }

        public Criteria andMainVersionNotEqualTo(Integer value) {
            addCriterion("main_version <>", value, "mainVersion");
            return (Criteria) this;
        }

        public Criteria andMainVersionGreaterThan(Integer value) {
            addCriterion("main_version >", value, "mainVersion");
            return (Criteria) this;
        }

        public Criteria andMainVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("main_version >=", value, "mainVersion");
            return (Criteria) this;
        }

        public Criteria andMainVersionLessThan(Integer value) {
            addCriterion("main_version <", value, "mainVersion");
            return (Criteria) this;
        }

        public Criteria andMainVersionLessThanOrEqualTo(Integer value) {
            addCriterion("main_version <=", value, "mainVersion");
            return (Criteria) this;
        }

        public Criteria andMainVersionIn(List<Integer> values) {
            addCriterion("main_version in", values, "mainVersion");
            return (Criteria) this;
        }

        public Criteria andMainVersionNotIn(List<Integer> values) {
            addCriterion("main_version not in", values, "mainVersion");
            return (Criteria) this;
        }

        public Criteria andMainVersionBetween(Integer value1, Integer value2) {
            addCriterion("main_version between", value1, value2, "mainVersion");
            return (Criteria) this;
        }

        public Criteria andMainVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("main_version not between", value1, value2, "mainVersion");
            return (Criteria) this;
        }

        public Criteria andMinorVersionIsNull() {
            addCriterion("minor_version is null");
            return (Criteria) this;
        }

        public Criteria andMinorVersionIsNotNull() {
            addCriterion("minor_version is not null");
            return (Criteria) this;
        }

        public Criteria andMinorVersionEqualTo(Integer value) {
            addCriterion("minor_version =", value, "minorVersion");
            return (Criteria) this;
        }

        public Criteria andMinorVersionNotEqualTo(Integer value) {
            addCriterion("minor_version <>", value, "minorVersion");
            return (Criteria) this;
        }

        public Criteria andMinorVersionGreaterThan(Integer value) {
            addCriterion("minor_version >", value, "minorVersion");
            return (Criteria) this;
        }

        public Criteria andMinorVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("minor_version >=", value, "minorVersion");
            return (Criteria) this;
        }

        public Criteria andMinorVersionLessThan(Integer value) {
            addCriterion("minor_version <", value, "minorVersion");
            return (Criteria) this;
        }

        public Criteria andMinorVersionLessThanOrEqualTo(Integer value) {
            addCriterion("minor_version <=", value, "minorVersion");
            return (Criteria) this;
        }

        public Criteria andMinorVersionIn(List<Integer> values) {
            addCriterion("minor_version in", values, "minorVersion");
            return (Criteria) this;
        }

        public Criteria andMinorVersionNotIn(List<Integer> values) {
            addCriterion("minor_version not in", values, "minorVersion");
            return (Criteria) this;
        }

        public Criteria andMinorVersionBetween(Integer value1, Integer value2) {
            addCriterion("minor_version between", value1, value2, "minorVersion");
            return (Criteria) this;
        }

        public Criteria andMinorVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("minor_version not between", value1, value2, "minorVersion");
            return (Criteria) this;
        }

        public Criteria andVersionDescIsNull() {
            addCriterion("version_desc is null");
            return (Criteria) this;
        }

        public Criteria andVersionDescIsNotNull() {
            addCriterion("version_desc is not null");
            return (Criteria) this;
        }

        public Criteria andVersionDescEqualTo(String value) {
            addCriterion("version_desc =", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescNotEqualTo(String value) {
            addCriterion("version_desc <>", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescGreaterThan(String value) {
            addCriterion("version_desc >", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescGreaterThanOrEqualTo(String value) {
            addCriterion("version_desc >=", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescLessThan(String value) {
            addCriterion("version_desc <", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescLessThanOrEqualTo(String value) {
            addCriterion("version_desc <=", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescLike(String value) {
            addCriterion("version_desc like", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescNotLike(String value) {
            addCriterion("version_desc not like", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescIn(List<String> values) {
            addCriterion("version_desc in", values, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescNotIn(List<String> values) {
            addCriterion("version_desc not in", values, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescBetween(String value1, String value2) {
            addCriterion("version_desc between", value1, value2, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescNotBetween(String value1, String value2) {
            addCriterion("version_desc not between", value1, value2, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlIsNull() {
            addCriterion("download_url is null");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlIsNotNull() {
            addCriterion("download_url is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlEqualTo(String value) {
            addCriterion("download_url =", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotEqualTo(String value) {
            addCriterion("download_url <>", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlGreaterThan(String value) {
            addCriterion("download_url >", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("download_url >=", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlLessThan(String value) {
            addCriterion("download_url <", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlLessThanOrEqualTo(String value) {
            addCriterion("download_url <=", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlLike(String value) {
            addCriterion("download_url like", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotLike(String value) {
            addCriterion("download_url not like", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlIn(List<String> values) {
            addCriterion("download_url in", values, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotIn(List<String> values) {
            addCriterion("download_url not in", values, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlBetween(String value1, String value2) {
            addCriterion("download_url between", value1, value2, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotBetween(String value1, String value2) {
            addCriterion("download_url not between", value1, value2, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlIsNull() {
            addCriterion("QR_code_url is null");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlIsNotNull() {
            addCriterion("QR_code_url is not null");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlEqualTo(String value) {
            addCriterion("QR_code_url =", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlNotEqualTo(String value) {
            addCriterion("QR_code_url <>", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlGreaterThan(String value) {
            addCriterion("QR_code_url >", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("QR_code_url >=", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlLessThan(String value) {
            addCriterion("QR_code_url <", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlLessThanOrEqualTo(String value) {
            addCriterion("QR_code_url <=", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlLike(String value) {
            addCriterion("QR_code_url like", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlNotLike(String value) {
            addCriterion("QR_code_url not like", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlIn(List<String> values) {
            addCriterion("QR_code_url in", values, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlNotIn(List<String> values) {
            addCriterion("QR_code_url not in", values, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlBetween(String value1, String value2) {
            addCriterion("QR_code_url between", value1, value2, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlNotBetween(String value1, String value2) {
            addCriterion("QR_code_url not between", value1, value2, "qrCodeUrl");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(String value) {
            addCriterion("platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(String value) {
            addCriterion("platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(String value) {
            addCriterion("platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(String value) {
            addCriterion("platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(String value) {
            addCriterion("platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLike(String value) {
            addCriterion("platform like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotLike(String value) {
            addCriterion("platform not like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<String> values) {
            addCriterion("platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<String> values) {
            addCriterion("platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(String value1, String value2) {
            addCriterion("platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(String value1, String value2) {
            addCriterion("platform not between", value1, value2, "platform");
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