package com.xupt.ttms.enums;

public enum PlayEnum {

    RECOMM(1,"recommend"),
    Link(2,"link")
    ;

    private int type;
    private String msg;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    PlayEnum(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }
}
