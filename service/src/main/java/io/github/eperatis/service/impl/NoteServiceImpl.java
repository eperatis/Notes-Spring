package io.github.eperatis.service.impl;

import io.github.eperatis.dao.NoteDAO;
import io.github.eperatis.exceptions.FontossagNemLehetKisebb;
import io.github.eperatis.exceptions.FontossagNemLehetNagyobb;
import io.github.eperatis.exceptions.NemTalalhatoId;
import io.github.eperatis.exceptions.NevNemLehetUresException;
import io.github.eperatis.model.Kategoria;
import io.github.eperatis.model.Note;
import io.github.eperatis.service.NoteServize;

import java.util.Collection;
import java.util.stream.Collectors;

public class NoteServiceImpl implements NoteServize {
    private NoteDAO dao;

    public NoteServiceImpl(NoteDAO dao) {
        this.dao = dao;
    }

    public void addNote(Note note) {
        dao.createNote(note);
    }

    public Collection<Note> getAllNote() {
        return dao.readAllNote();
    }

    public Note getNoteById(String id) {
        return dao.readNote(id);
    }

    public void updateNote(Note note) throws NemTalalhatoId, NevNemLehetUresException, FontossagNemLehetKisebb, FontossagNemLehetNagyobb {
        this.dao.updateNote(note);
    }

    public void removeNote(Note note) throws NemTalalhatoId {
        this.dao.deleteNote(note);
    }

    public Collection<Note> readAllNoteByKategoria(final Kategoria kategoria) {
        Collection<Note> notes = getAllNote();
        Collection<Note> result = notes.stream().filter(d -> d.getKategoria() == kategoria).collect(Collectors.toList());
        return result;
    }
}
