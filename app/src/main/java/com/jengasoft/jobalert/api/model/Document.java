package com.jengasoft.jobalert.api.model;

/**
 * Created by MoCoder#1956# on 9/23/2017.
 */

public class Document {
    private String title;
    private String fileUrl;
    private String thumbnail;

    public Document(String title, String fileUrl, String thumbnail) {
        this.title = title;
        this.fileUrl = fileUrl;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getThumbnaill() {
        return thumbnail;
    }

    public void setThumbnaill(String thumbnaill) {
        this.thumbnail = thumbnaill;
    }
}

