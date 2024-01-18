package com.Note.app.dtos;

import com.Note.app.model.Tag;

import java.util.List;

public class ResponseDto {
    private Long ID;
    private String title;
    private String text;
    private List<Tag> tags;
    private boolean success;

    public ResponseDto(Long ID, String title, String text, List<Tag> tags, boolean success) {
        this.ID = ID;
        this.title = title;
        this.text = text;
        this.tags = tags;
        this.success = success;
    }

    public ResponseDto() {
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public boolean isSuccess() {
        return success;
    }


}

