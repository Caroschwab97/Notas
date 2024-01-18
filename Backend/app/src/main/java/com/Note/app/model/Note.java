package com.Note.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Note {
    @Id
    @GeneratedValue
    private Long ID;
    private String title;
    private String text;
    @ManyToMany
    private List<Tag> tags;


    public Note(String title, String text, List<Tag> tags) {
        this.title = title;
        this.text = text;
        this.tags = tags;
    }

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Note() {
    }

    @Override
    public String toString() {
        return "Note{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", tags=" + tags +
                '}';
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
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
}


