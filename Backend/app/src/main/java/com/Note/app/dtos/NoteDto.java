package com.Note.app.dtos;

import com.Note.app.model.Tag;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.stream.Collectors;

public class NoteDto {
    @NotBlank
    private String title;
    @NotBlank
    private String text;

    private List<Tag> tags;

    public NoteDto(String title, String text, List<TagDto> tagss) {
        this.title = title;
        this.text = text;
        this.tags = tagss.stream()
                .map(t -> new Tag(t.getName()))
                .collect(Collectors.toList());
    }

    public List<Tag> getTags() {

        return tags;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "NoteDto{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

