package io.github.eperatis.dao.relational;

import io.github.eperatis.dao.NoteDAO;
import io.github.eperatis.exceptions.FontossagNemLehetKisebb;
import io.github.eperatis.exceptions.FontossagNemLehetNagyobb;
import io.github.eperatis.exceptions.NemTalalhatoId;
import io.github.eperatis.exceptions.NevNemLehetUresException;
import io.github.eperatis.model.Kategoria;
import io.github.eperatis.model.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.text.MessageFormat;
import java.util.Collection;

public class NotesDAORelational implements NoteDAO {

    private static SessionFactory factory;

    public NotesDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void createNote(Note note) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(note);
        tx.commit();
        session.close();
    }

    @Override
    public Collection<Note> readAllNote() {
        Session session = factory.openSession();
        Collection<Note> result = session.createQuery("FROM Note").list();
        session.close();
        return result;
    }

    @Override
    public Note readNote(String id) {
        Session session = factory.openSession();
        Note result = session.get(Note.class, id);
        session.close();
        return result;
    }

    @Override
    public void updateNote(Note note) throws NemTalalhatoId{
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Note noteUpdate = session.get(Note.class, note.getId());
        if(noteUpdate == null) {
            throw new NemTalalhatoId(MessageFormat.format("Nem található jegyzet ezzel a(z) {0} azonosítóval!", note.getId()));
        }
        try {
            noteUpdate.setNev(note.getNev());
            noteUpdate.setKategoria(note.getKategoria());
            noteUpdate.setFontossag(note.getFontossag());
            noteUpdate.setJegyzetek(note.getJegyzetek());
            session.update(noteUpdate);
            tx.commit();
        } catch (FontossagNemLehetKisebb | FontossagNemLehetNagyobb | NevNemLehetUresException ex) {
            System.out.println(ex.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteNote(Note note) throws NemTalalhatoId {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Note noteDel = session.get(Note.class, note.getId());
        if(noteDel == null) {
            throw new NemTalalhatoId(MessageFormat.format("Nem található jegyzet ezzel a(z) {0} azonosítóval!", note.getId()));
        }
        session.delete(noteDel);
        tx.commit();
        session.close();
    }

    @Override
    public Collection<Note> readAllNoteByKategoria(Kategoria kategoria) {
        Session session = factory.openSession();
        String hql = "From Note Where kategoria = :kategoria";
        Query q = session.createQuery(hql);
        q.setParameter("kategoria",kategoria);
        Collection result = q.list();
        session.close();
        return result;
    }
}
