package com.xupt.ttms.Service;

import com.xupt.ttms.mapper.CommentMapper;
import com.xupt.ttms.model.Comment;
import com.xupt.ttms.model.CommentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper mapper;

    public List<Comment> getByPlay(Integer playId){
        CommentExample example = new CommentExample();
        example.createCriteria().andPlayIdEqualTo(playId);

        List<Comment> comments = mapper.selectByExample(example);
        return comments;
    }
}
