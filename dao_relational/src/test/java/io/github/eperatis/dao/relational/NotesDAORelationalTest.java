package io.github.eperatis.dao.relational;

import io.github.eperatis.dao.NoteDAO;
import io.github.eperatis.exceptions.FontossagNemLehetKisebb;
import io.github.eperatis.exceptions.FontossagNemLehetNagyobb;
import io.github.eperatis.exceptions.NemTalalhatoId;
import io.github.eperatis.exceptions.NevNemLehetUresException;
import io.github.eperatis.model.Jegyzet;
import io.github.eperatis.model.Kategoria;
import io.github.eperatis.model.Note;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class NotesDAORelationalTest {

    @Test
    public void test() throws NevNemLehetUresException, FontossagNemLehetKisebb, FontossagNemLehetNagyobb {
        NoteDAO dao = new NotesDAORelational();
        Note note = new Note();
        note.setNev("Bevásárlás");
        note.setKategoria(Kategoria.SZEMELYES);
        note.setFontossag(6);
        Jegyzet jgy1 = new Jegyzet("Kenyér");
        Jegyzet jgy2 = new Jegyzet("Tej");
        List jegyzetek = new ArrayList<>();
        jegyzetek.add(jgy1);
        jegyzetek.add(jgy2);
        note.setJegyzetek(jegyzetek);
        dao.createNote(note);
        //System.out.println(dao.readAllNote());
        System.out.println(dao.readNote(note.getId()));
        System.out.println(dao.readAllNoteByKategoria(Kategoria.SZEMELYES));
    }

    @Test
    public void testNoteDelete() throws NemTalalhatoId {
        NoteDAO dao = new NotesDAORelational();
        System.out.println(dao.readAllNote());
        dao.deleteNote(dao.readNote("67c87c72-1663-4bd1-bb3f-d50dfb60ac87"));
        System.out.println(dao.readAllNote());
    }

    @Test
    public void testNoteUpdate() throws NemTalalhatoId, FontossagNemLehetNagyobb, NevNemLehetUresException, FontossagNemLehetKisebb {
        NoteDAO dao = new NotesDAORelational();
        Note regi = dao.readNote("a65bddc2-c408-4822-bd74-b335b9780e57");
        Note uj = regi;
        uj.setNev("Uj bevasarlo");
        Jegyzet jgy3 = new Jegyzet("Répa");
        List jegyzetek = new ArrayList<>();
        jegyzetek.add(jgy3);
        uj.setJegyzetek(jegyzetek);
        dao.updateNote(uj);
        System.out.println(dao.readNote("a65bddc2-c408-4822-bd74-b335b9780e57"));
    }
}