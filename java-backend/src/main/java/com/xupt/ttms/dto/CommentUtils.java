package com.xupt.ttms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CommentUtils {
    private int playId;
    private String playName;
    private String userName;
    private String targetUserName;
    private String commentText;
    private String reportType;
    private String reportText;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date commentTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date reportTime;
}
