package com.note.note_service.controller;


import com.note.note_service.Note;
import com.note.note_service.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/get")
    public List<Note> getNotes(){
        return noteService.getNotes();
    }


    @PostMapping("/create")
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(
                note.getTitle(),
                note.getContent()
        );
    }


    @DeleteMapping("/delete/{id}")
    public Note deleteNote(@PathVariable int id) {
        return noteService.deleteNote(id);
    }

}
