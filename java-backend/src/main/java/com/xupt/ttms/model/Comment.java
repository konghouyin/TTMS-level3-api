package com.xupt.ttms.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private Integer playId;

    private Integer userId;

    private String commentText;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date commentTime;

    private Short commentLevel;//评论分数

    private Short commentStatus;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getPlayId() {
        return playId;
    }

    public void setPlayId(Integer playId) {
        this.playId = playId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText == null ? null : commentText.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Short getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Short commentLevel) {
        this.commentLevel = commentLevel;
    }

    public Short getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Short commentStatus) {
        this.commentStatus = commentStatus;
    }
}