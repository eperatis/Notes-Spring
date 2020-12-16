package io.github.eperatis.controller;

import io.github.eperatis.exceptions.NemTalalhatoId;
import io.github.eperatis.model.Kategoria;
import io.github.eperatis.model.Note;
import io.github.eperatis.service.NoteServize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {

    @Autowired
    NoteServize servize;

    @ModelAttribute(value = "note")
    public Note create(){
        return new Note();
    }

    @GetMapping(value = "/notes")
    public ModelAndView getAllNotes(){
        ModelAndView mav = new ModelAndView("listAllNotes.jsp");
        System.out.println(servize.getAllNote());
        mav.addObject("notes",servize.getAllNote());
        return mav;
    }

    @GetMapping(value = "/note/{id}")
    public String getNoteById(@PathVariable String id, Model model){
        model.addAttribute("note",servize.getNoteById(id));
        return "noteDetails.jsp";
    }

    @GetMapping(value = "addNote")
    public String addNoteForm(Model model){
        model.addAttribute("kategoriak", Kategoria.values());
        return "noteForm.jsp";
    }

    @PostMapping(value = "addNote")
    public String addNote(@ModelAttribute("note") Note note, Model model){
        System.out.println(note);
        servize.addNote(note);
        return "redirect:note/"+note.getId();
    }

    @GetMapping(value = "deleteNote/{noteId}")
    public String deleteNote(@PathVariable String noteId, Model model) throws NemTalalhatoId {
        Note note = servize.getNoteById(noteId);
        servize.removeNote(note);
        return "redirect:../notes";
    }

    @GetMapping(value="/listSuli")
    public ModelAndView listSuliKategoria(){
        ModelAndView mav = new ModelAndView("listKategoria.jsp");
        mav.addObject("notes",servize.readAllNoteByKategoria(Kategoria.SULI));
        return mav;
    }

    @GetMapping(value="/listMunka")
    public ModelAndView listMunkaKategoria(){
        ModelAndView mav = new ModelAndView("listKategoria.jsp");
        mav.addObject("notes",servize.readAllNoteByKategoria(Kategoria.MUNKA));
        return mav;
    }

    @GetMapping(value="/listSzemelyes")
    public ModelAndView listSzemelyesKategoria(){
        ModelAndView mav = new ModelAndView("listKategoria.jsp");
        mav.addObject("notes",servize.readAllNoteByKategoria(Kategoria.SZEMELYES));
        return mav;
    }
}
