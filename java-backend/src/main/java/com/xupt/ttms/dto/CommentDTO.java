package com.xupt.ttms.dto;

import com.xupt.ttms.model.*;
import lombok.Data;

@Data
public class CommentDTO {
    private Comment comment;
    private User user;
}
