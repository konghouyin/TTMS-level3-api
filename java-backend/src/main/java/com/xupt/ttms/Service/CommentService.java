package com.xupt.ttms.Service;

import com.xupt.ttms.dto.CommentDTO;
import com.xupt.ttms.enums.CommentEnum;
import com.xupt.ttms.enums.ReportEnum;
import com.xupt.ttms.mapper.CommentMapper;
import com.xupt.ttms.mapper.PlayMapper;
import com.xupt.ttms.mapper.ReportMapper;
import com.xupt.ttms.mapper.UserMapper;
import com.xupt.ttms.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper mapper;
    @Autowired
    PlayMapper playMapper;
    @Autowired
    ReportMapper reportMapper;
    @Autowired
    UserMapper userMapper;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List getByPlay(Integer playId){
        CommentExample example = new CommentExample();
        example.createCriteria().andPlayIdEqualTo(playId)
                .andCommentStatusEqualTo((short) CommentEnum.GOOD.getType());

        List<Object> list = new ArrayList<>();

        List<Comment> comments = mapper.selectByExample(example);
        for (Comment comment:comments){
            Play play = playMapper.selectByPrimaryKey(playId);
            if(play.getPlayStatus().equals("-1")){
                break;
            }
            User user = userMapper.selectByPrimaryKey(comment.getUserId());

            CommentDTO dto = new CommentDTO();
            dto.setUser(user);
            dto.setComment(comment);

            list.add(dto);
        }
        return list;
    }

    @Transactional
    public int commentAdd(Comment comment){
        try{
            Play play = playMapper.selectByPrimaryKey(comment.getPlayId());
            if(play==null){
                return -2;
            }else{
                CommentExample example = new CommentExample();
                example.createCriteria().andPlayIdEqualTo(comment.getPlayId())
                        .andUserIdEqualTo(comment.getUserId());
                //.andCommentStatusEqualTo((short) CommentEnum.GOOD.getType());
                Comment comments = mapper.selectByExample(example).get(0);
                if(comments!=null&& comments.getCommentStatus()==CommentEnum.GOOD.getType()){

                    comment.setCommentTime(new Date());
                    mapper.updateByExampleSelective(comment,example);
                    return 2;
                }else if(comments!=null&& comments.getCommentStatus()!=CommentEnum.GOOD.getType()){
                    return -3;
                }
                else{
                    int insert = mapper.insert(comment);
                    if(0 == insert){
                        return 0;
                    }
                    return 1;
                }
            }
        }catch (Exception e){
            return 0;
        }
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

    @Transactional()
    public List getByStatus() {

        ReportExample example = new ReportExample();
        example.createCriteria().andReportStatusEqualTo((short) ReportEnum.Processing.getStatus());

        List<CommentDTO> comments= new ArrayList<>();
        List<Report> reports = reportMapper.selectByExample(example);
        for (Report report:reports
             ) {
            Comment comment = mapper.selectByPrimaryKey(report.getCommentId());
            User user = userMapper.selectByPrimaryKey(report.getUserId());
            Play play = playMapper.selectByPrimaryKey(comment.getPlayId());
            if(play.getPlayStatus().equals("-1")){
                continue;
            }
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setComment(comment);
            commentDTO.setPlay(play);
            commentDTO.setReport(report);
            commentDTO.setUser(user);

            comments.add(commentDTO);
        }

        //List<Comment> comments = mapper.selectByExample(example);
        return comments;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int delComment(Comment comment){
        int id = comment.getCommentId();
        Comment comment3 = mapper.selectByPrimaryKey(comment.getCommentId());
        if (comment3.getCommentStatus()==CommentEnum.EXAMING.getType()) {
            try {
                ReportExample example = new ReportExample();
                example.createCriteria().andCommentIdEqualTo(id);
                List<Report> reports = reportMapper.selectByExample(example);

                //修改Comment
                Comment comment2 = mapper.selectByPrimaryKey(id);
                CommentExample commentExample = new CommentExample();
                commentExample.createCriteria().andCommentIdEqualTo(id);


                Comment comment1 = new Comment();
                comment1.setCommentTime(comment2.getCommentTime());
                comment1.setCommentStatus((short) CommentEnum.DELED.getType());
                comment1.setCommentLevel(comment2.getCommentLevel());
                mapper.updateByExampleSelective(comment1, commentExample);
                //修改report

                for (int i = 0; i < reports.size(); i++) {
                    Report report = new Report();
                    report.setReportStatus((short) ReportEnum.Processed.getStatus());

                    reportMapper.updateByExampleSelective(report, example);
                }
            } catch (Exception e) {
                return -1;
            }
            return 0;
        }else {
            return -2;
        }
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int rejectComment(Comment comment) {
        int id = comment.getCommentId();
        Comment comment3 = mapper.selectByPrimaryKey(comment.getCommentId());
        if (comment3.getCommentStatus()==CommentEnum.EXAMING.getType()) {
            try {
                ReportExample example = new ReportExample();
                example.createCriteria().andCommentIdEqualTo(id);
                List<Report> reports = reportMapper.selectByExample(example);

                //修改Comment
                Comment comment2 = mapper.selectByPrimaryKey(id);
                CommentExample commentExample = new CommentExample();
                commentExample.createCriteria().andCommentIdEqualTo(id);


                Comment comment1 = new Comment();
                comment1.setCommentTime(comment2.getCommentTime());
                comment1.setCommentStatus((short) CommentEnum.GOOD.getType());
                comment1.setCommentLevel(comment2.getCommentLevel());
                mapper.updateByExampleSelective(comment1, commentExample);
                //修改report

                for (int i = 0; i < reports.size(); i++) {
                    Report report = new Report();
                    report.setReportStatus((short) ReportEnum.WELL.getStatus());

                    reportMapper.updateByExampleSelective(report, example);
                }
            } catch (Exception e) {
                return -1;
            }
            return 0;
        }else {
            return -2;
        }
    }
}

