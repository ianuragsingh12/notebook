package org.kingempire.notebook.note;

import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Anurag Singh
 */
@Controller
public class NoteController {
    
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    
    private final NoteService noteService;
    private final MessageSource messageSource;
    
    @Autowired
    public NoteController(NoteService noteService, MessageSource messageSource) {
        this.noteService = noteService;
        this.messageSource = messageSource;
    }
    
    @GetMapping(value = {"/", "/index"})
    public ModelAndView IndexPage() {
        ModelAndView modalandview = new ModelAndView("index");
        modalandview.addObject("totalnotescount", noteService.getTotalDocumentCount());
        LOG.debug("Index Page Loaded");
        return modalandview;
    }
    
    @PostMapping("/searchNote")
    public //@ResponseBody
            String getAllNoteBySearchString(@RequestParam String searchString, Model model) {
        List<Note> res = noteService.findAllBySearchString(searchString);
        model.addAttribute("notes", res);
        model.addAttribute("notescount", res.size());
        
        return "resultCard :: result-card";
    }
    
    @GetMapping("/page/note/add")
    public ModelAndView NoteAddPage() {
        ModelAndView modalandview = new ModelAndView("add", "note", new Note());
        LOG.debug("Add Page Loaded");
        return modalandview;
    }
    
    @RequestMapping(value = "/addNewNote", method = RequestMethod.POST)
    public String saveNewNote(@Valid @ModelAttribute("note") Note note,
            BindingResult result, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        
        if (result.hasErrors()) {
            LOG.debug(result.toString());
            return "add";
        }
        LOG.debug("Creating a new note.");
        note.setAuthor(capitalizeEachWord(note.getAuthor()));
        noteService.create(note);
        redirectAttributes.addFlashAttribute("message", messageSource.getMessage("message.note.saved", null, Locale.getDefault()));
        return "redirect:/page/note/add";
    }
    
    private String capitalizeEachWord(String str) {
        StringBuilder result = new StringBuilder(str.length());
        String words[] = str.split("\\ ");
        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return result.toString();
    }
}
