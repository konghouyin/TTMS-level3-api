package com.xupt.ttms.model;

public class Play {
    private Integer playId;

    private String playName;

    private String playDirector;

    private String playPerformer;

    private String playType;

    private String playLength;

    private String playCountry;

    private String playLanguage;

    private String playStatus;

    private String playPic;

    private String playLink;

    private String playPath;

    private String playMessage;

    public String getPlayRecommend() {
        return playRecommend;
    }

    public void setPlayRecommend(String playRecommend) {
        this.playRecommend = playRecommend;
    }

    private String playRecommend;

    public Integer getPlayId() {
        return playId;
    }

    public void setPlayId(Integer playId) {
        this.playId = playId;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName == null ? null : playName.trim();
    }

    public String getPlayDirector() {
        return playDirector;
    }

    public void setPlayDirector(String playDirector) {
        this.playDirector = playDirector == null ? null : playDirector.trim();
    }

    public String getPlayPerformer() {
        return playPerformer;
    }

    public void setPlayPerformer(String playPerformer) {
        this.playPerformer = playPerformer == null ? null : playPerformer.trim();
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType == null ? null : playType.trim();
    }

    public String getPlayLength() {
        return playLength;
    }

    public void setPlayLength(String playLength) {
        this.playLength = playLength == null ? null : playLength.trim();
    }

    public String getPlayCountry() {
        return playCountry;
    }

    public void setPlayCountry(String playCountry) {
        this.playCountry = playCountry == null ? null : playCountry.trim();
    }

    public String getPlayLanguage() {
        return playLanguage;
    }

    public void setPlayLanguage(String playLanguage) {
        this.playLanguage = playLanguage == null ? null : playLanguage.trim();
    }

    public String getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(String playStatus) {
        this.playStatus = playStatus == null ? null : playStatus.trim();
    }

    public String getPlayPic() {
        return playPic;
    }

    public void setPlayPic(String playPic) {
        this.playPic = playPic == null ? null : playPic.trim();
    }

    public String getPlayLink() {
        return playLink;
    }

    public void setPlayLink(String playLink) {
        this.playLink = playLink == null ? null : playLink.trim();
    }

    public String getPlayPath() {
        return playPath;
    }

    public void setPlayPath(String playPath) {
        this.playPath = playPath == null ? null : playPath.trim();
    }

    public String getPlayMessage() {
        return playMessage;
    }

    public void setPlayMessage(String playMessage) {
        this.playMessage = playMessage == null ? null : playMessage.trim();
    }
}