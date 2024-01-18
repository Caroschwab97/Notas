package com.Note.app.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Tag {
    @Id
    @GeneratedValue
    private Long ID;
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

