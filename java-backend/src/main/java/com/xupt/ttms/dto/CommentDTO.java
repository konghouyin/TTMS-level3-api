package com.xupt.ttms.dto;

import com.xupt.ttms.model.Comment;
import com.xupt.ttms.model.Play;
import com.xupt.ttms.model.Report;
import com.xupt.ttms.model.User;
import lombok.Data;

@Data
public class CommentDTO {
    private Comment comment;
    private Report report;
    private Play play;
    private User user;
}
