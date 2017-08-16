package com.cxc.system.model;

import java.util.Date;

public class System {
    private Long systemId;

    private String systemName;

    private String systemSummary;

    private Date created;

    private Short status;

    private Date updated;

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public String getSystemSummary() {
        return systemSummary;
    }

    public void setSystemSummary(String systemSummary) {
        this.systemSummary = systemSummary == null ? null : systemSummary.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}