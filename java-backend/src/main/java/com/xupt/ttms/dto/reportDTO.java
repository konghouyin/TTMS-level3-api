package com.xupt.ttms.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class reportDTO {
    private int commentId;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date reportTime;
    private String reportText;
}
