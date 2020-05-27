package com.xupt.ttms.model;

public class ReportType {
    private Integer reporttypeId;

    private String reporttypeName;

    private Short reporttypeStatus;

    public Integer getReporttypeId() {
        return reporttypeId;
    }

    public void setReporttypeId(Integer reporttypeId) {
        this.reporttypeId = reporttypeId;
    }

    public String getReporttypeName() {
        return reporttypeName;
    }

    public void setReporttypeName(String reporttypeName) {
        this.reporttypeName = reporttypeName == null ? null : reporttypeName.trim();
    }

    public Short getReporttypeStatus() {
        return reporttypeStatus;
    }

    public void setReporttypeStatus(Short reporttypeStatus) {
        this.reporttypeStatus = reporttypeStatus;
    }
}