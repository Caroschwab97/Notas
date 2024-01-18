package com.Note.app.controllers;

import com.Note.app.dtos.NoteDto;
import com.Note.app.dtos.ResponseDto;
import com.Note.app.model.Note;
import com.Note.app.services.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public String createNote(@Valid @RequestBody NoteDto noteDto) {

        return noteService.createNote(noteDto).toString();
    }

    @GetMapping
    public ResponseEntity<List<Note>> getNote () {
        List<Note> ln = noteService.getNote();
        return ResponseEntity.ok().body(ln);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getNoteID (@PathVariable Long id){
        Optional<Note> optionalNote=noteService.getNoteId(id);
        if (optionalNote.isEmpty()){
            ResponseDto answer = new ResponseDto();
            answer.setSuccess(false);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(answer);
        }
        else {
            Note note = optionalNote.get();
            ResponseDto answer = new ResponseDto(note.getID(), note.getTitle(), note.getText(), note.getTags(), true);
            return ResponseEntity.ok().body(answer);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteNoteID (@PathVariable Long id){
        noteService.deleteNoteID(id);
    }


    @DeleteMapping
    public void deleteAllNotes(){
        noteService.deleteAllNotes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> putNote (@RequestBody ResponseDto responseNoteDto, @PathVariable Long id) {
        Optional<Note> optionalNote=noteService.getNoteId(id);
        if (optionalNote.isEmpty()){
            ResponseDto answer = new ResponseDto();
            answer.setSuccess(false);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(answer);
        }
        else {
            Note note= noteService.putNote(responseNoteDto,optionalNote);
            ResponseDto answer = new ResponseDto(note.getID(), note.getTitle(), note.getText(), note.getTags(), true);
            return ResponseEntity.ok().body(answer);
        }

    }
}