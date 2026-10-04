package com.note.note_service.service;

import com.note.note_service.Note;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class NoteService {

    private final List<Note> notes = new ArrayList<>(
            List.of(new Note("Default title","Default content"))
    );

    public Note createNote(String title, String content) {
        Note note = new Note(title, content);
        notes.add(note);
        return note;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public Note deleteNote(int id) {
        return notes.remove(id);
    }
}
