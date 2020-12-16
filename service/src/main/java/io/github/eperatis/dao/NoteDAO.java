package io.github.eperatis.dao;

import io.github.eperatis.exceptions.FontossagNemLehetKisebb;
import io.github.eperatis.exceptions.FontossagNemLehetNagyobb;
import io.github.eperatis.exceptions.NemTalalhatoId;
import io.github.eperatis.exceptions.NevNemLehetUresException;
import io.github.eperatis.model.Kategoria;
import io.github.eperatis.model.Note;

import java.util.Collection;

public interface NoteDAO {
    void createNote(Note note);
    Collection<Note> readAllNote();
    Note readNote(String id);
    void updateNote(Note note) throws NemTalalhatoId, FontossagNemLehetKisebb, FontossagNemLehetNagyobb, NevNemLehetUresException;
    void deleteNote(Note note) throws NemTalalhatoId;
    Collection<Note> readAllNoteByKategoria(Kategoria kategoria);
}
