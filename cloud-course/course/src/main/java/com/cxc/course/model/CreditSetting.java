package com.cxc.course.model;

import java.util.Date;

public class CreditSetting {
    private Long creditSettingId;

    private Long schoolId;

    private Long courseId;

    private Float credit;

    private Date created;

    private Date updated;

    private Long updateUserId;

    private String depict;

    public Long getCreditSettingId() {
        return creditSettingId;
    }

    public void setCreditSettingId(Long creditSettingId) {
        this.creditSettingId = creditSettingId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict == null ? null : depict.trim();
    }
}