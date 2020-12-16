package io.github.eperatis.service;

import io.github.eperatis.exceptions.FontossagNemLehetKisebb;
import io.github.eperatis.exceptions.FontossagNemLehetNagyobb;
import io.github.eperatis.exceptions.NemTalalhatoId;
import io.github.eperatis.exceptions.NevNemLehetUresException;
import io.github.eperatis.model.Kategoria;
import io.github.eperatis.model.Note;

import java.util.Collection;

public interface NoteServize {
    void addNote(Note note);
    Collection<Note> getAllNote();
    Note getNoteById(String id);
    void updateNote(Note note) throws NemTalalhatoId, NevNemLehetUresException, FontossagNemLehetKisebb, FontossagNemLehetNagyobb;
    void removeNote(Note note) throws NemTalalhatoId;
    Collection<Note> readAllNoteByKategoria(Kategoria kategoria);
}
