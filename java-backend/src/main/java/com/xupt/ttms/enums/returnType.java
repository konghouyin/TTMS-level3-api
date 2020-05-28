package com.xupt.ttms.enums;

public enum returnType {

    SUCCESS("成功",1),
    LOGICERR("逻辑错误",0),
    DATABASEERR("数据库错误",-2)
    ;

    private String msg;
    private int style;

    returnType(String msg, int style) {
        this.msg = msg;
        this.style = style;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}
