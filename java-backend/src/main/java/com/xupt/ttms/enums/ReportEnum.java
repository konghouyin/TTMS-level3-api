package com.xupt.ttms.enums;

public enum ReportEnum {

    Processing("审核中",2),
    Processed("已删除",-1),
    WELL("评论正常",1)
    ;

    private String msg;
    private int status;

    ReportEnum(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
