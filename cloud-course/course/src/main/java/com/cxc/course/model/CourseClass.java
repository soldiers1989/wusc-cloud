package com.cxc.course.model;

import java.util.Date;

public class CourseClass {
	
    private Integer classId;

    private String className;

    private String pictureUrl;

    private String depict;

    private Date sn;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict == null ? null : depict.trim();
    }

    public Date getSn() {
        return sn;
    }

    public void setSn(Date sn) {
        this.sn = sn;
    }
}