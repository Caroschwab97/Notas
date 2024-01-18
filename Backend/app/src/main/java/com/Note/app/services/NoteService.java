package com.Note.app.services;

import com.Note.app.dtos.NoteDto;
import com.Note.app.dtos.ResponseDto;
import com.Note.app.model.Note;
import com.Note.app.repositories.NoteRepository;
import com.Note.app.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class NoteService {

    private NoteRepository noteRepository;
    private TagRepository tagRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(NoteDto noteDto){
        Note note= new Note(noteDto.getTitle(), noteDto.getText(), noteDto.getTags());
        tagRepository.saveAll(noteDto.getTags());
        return noteRepository.save(note);
    }

    public List<Note> getNote(){
        return (List<Note>) noteRepository.findAll();
    }

    public Optional<Note> getNoteId(Long id){
        return noteRepository.findById(id);
    }

    public void deleteNoteID (Long id){
        noteRepository.deleteById(id);
    }

    public void deleteAllNotes(){
        noteRepository.deleteAll();
    }

    public Note putNote(ResponseDto responseNoteDto, Optional<Note> optionalNote){
        Note note= optionalNote.get();
        note.setTitle(responseNoteDto.getTitle());
        note.setText(responseNoteDto.getText());
        note.setTags(responseNoteDto.getTags());
        noteRepository.save(note);
        return note;
    }
}
