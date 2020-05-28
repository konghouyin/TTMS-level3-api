package com.xupt.ttms.model;



public enum ReportTypeEnum {

    WELL("正常",1),
    DELED("已删除",2);

    private String status;
    private int type;

    private ReportTypeEnum(String status, int type) {
        this.status = status;
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
