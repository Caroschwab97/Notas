package com.Note.app.dtos;

public class TagDto {
    private String name;

    public TagDto() {
    }

    public TagDto(String nombre) {
        this.name = nombre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

