package com.xupt.ttms.Service;

import com.xupt.ttms.enums.CommentEnum;
import com.xupt.ttms.enums.ReportEnum;
import com.xupt.ttms.mapper.ReportMapper;
import com.xupt.ttms.model.Comment;
import com.xupt.ttms.model.Report;
import com.xupt.ttms.model.ReportExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    ReportMapper mapper;
    @Autowired
    CommentService service;

    @Transactional
    public int reportAdd(Report report){

        ReportExample example = new ReportExample();
        example.createCriteria().andCommentIdEqualTo(report.getCommentId())
                .andReporttypeIdEqualTo(report.getReporttypeId())
                .andReportStatusNotEqualTo((short) ReportEnum.WELL.getStatus());
        List<Report> reports = mapper.selectByExample(example);

        int insert=0;
        if(reports.size()==0){

            insert = mapper.insert(report);
            Comment comment = new Comment();
            comment.setCommentId(report.getCommentId());
            comment.setCommentStatus((short) CommentEnum.EXAMING.getType());

            service.updateComment(comment);
        }else {
            insert=-2;
        }

        return insert;
    }
}
