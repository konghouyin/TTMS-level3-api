package com.xupt.ttms.enums;

public enum CommentEnum {

    GOOD("正常",1),
    EXAMING("审核中",2),
    DELED("已删除",-1)
    ;

    private String msg;
    private int type;

    CommentEnum(String msg, int type) {
        this.msg = msg;
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
