package com.xupt.ttms.Service;

import com.xupt.ttms.enums.CommentEnum;
import com.xupt.ttms.enums.ReportEnum;
import com.xupt.ttms.mapper.CommentMapper;
import com.xupt.ttms.mapper.ReportMapper;
import com.xupt.ttms.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper mapper;
    @Autowired
    ReportMapper reportMapper;
    public List<Comment> getByPlay(Integer playId){
        CommentExample example = new CommentExample();
        example.createCriteria().andPlayIdEqualTo(playId)
                .andCommentStatusEqualTo((short) CommentEnum.GOOD.getType());

        List<Comment> comments = mapper.selectByExample(example);
        return comments;
    }


    public int commentAdd(Comment comment){
        int insert = mapper.insert(comment);
        if(0 == insert){
            return 0;
        }
        return 1;
    }

    public boolean updateComment(Comment comment){
        Comment comment2 = mapper.selectByPrimaryKey(comment.getCommentId());
        CommentExample example = new CommentExample();
        example.createCriteria().andCommentIdEqualTo(comment.getCommentId());

        Comment comment1 = new Comment();
        comment1.setCommentLevel(comment2.getCommentLevel());
        comment1.setCommentStatus(comment.getCommentStatus());
        comment1.setCommentTime(comment2.getCommentTime());

        try{mapper.updateByExampleSelective(comment1,example);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<Comment> getByStatus() {

        CommentExample example = new CommentExample();
        example.createCriteria().andCommentStatusNotEqualTo((short) CommentEnum.GOOD.getType());

        List<Comment> comments = mapper.selectByExample(example);
        return comments;
    }

    @Transactional
    public boolean delComment(Comment comment){
        int id = comment.getCommentId();
        try{
            ReportExample example = new ReportExample();
            example.createCriteria().andCommentIdEqualTo(id);
            Report report = reportMapper.selectByExample(example).get(0);

            //修改Comment
            Comment comment2 = mapper.selectByPrimaryKey(id);
            CommentExample commentExample = new CommentExample();
            commentExample.createCriteria().andCommentIdEqualTo(id);


            Comment comment1 = new Comment();
            comment1.setCommentTime(comment2.getCommentTime());
            comment1.setCommentStatus((short) CommentEnum.DELED.getType());
            comment1.setCommentLevel(comment2.getCommentLevel());
            mapper.updateByExampleSelective(comment1,commentExample);
            //修改report

            report.setReportStatus((short) ReportEnum.Processed.getStatus());
            reportMapper.updateByExampleSelective(report,example);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Transactional
    public boolean rejectComment(Comment comment) {
        int id = comment.getCommentId();
        try{
            ReportExample example = new ReportExample();
            example.createCriteria().andCommentIdEqualTo(id);
            Report report = reportMapper.selectByExample(example).get(0);

            //修改Comment
            Comment comment2 = mapper.selectByPrimaryKey(id);
            CommentExample commentExample = new CommentExample();
            commentExample.createCriteria().andCommentIdEqualTo(id);


            Comment comment1 = new Comment();
            comment1.setCommentTime(comment2.getCommentTime());
            comment1.setCommentStatus((short) CommentEnum.GOOD.getType());
            comment1.setCommentLevel(comment2.getCommentLevel());
            mapper.updateByExampleSelective(comment1,commentExample);
            //修改report

            report.setReportStatus((short) ReportEnum.WELL.getStatus());
            reportMapper.updateByExampleSelective(report,example);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
