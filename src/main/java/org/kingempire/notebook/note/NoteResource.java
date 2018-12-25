package org.kingempire.notebook.note;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.kingempire.notebook.exceptionHandler.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Anurag Singh
 */
@RestController
@RequestMapping("/api/v1")
public class NoteResource {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final NoteService noteService;

    @Autowired
    public NoteResource(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "/notes", produces = "application/json")
    public ResponseEntity<List<Note>> findAll() {
        LOG.info("Getting all notes.");
        List<Note> notes = noteService.findAll();
        return ResponseEntity.ok().body(notes);
    }

    @GetMapping(value = "/notes/{id}")
    public ResponseEntity<Note> findOne(@PathVariable("id") String id) throws ResourceNotFoundException {
        LOG.info("Getting note with ID: {}.", id);
        Note note = noteService.findOne(id).orElseThrow(() -> new ResourceNotFoundException("given note id not found: " + id));
        return ResponseEntity.status(HttpStatus.OK).body(note);
    }

    @GetMapping(value = "/notes_1/{id}")
    public ResponseEntity<Note> findOne_1(@PathVariable("id") String id) {
        LOG.info("Getting note with ID: {}.", id);
        Optional<Note> note = noteService.findOne(id);

        return note.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/note")
    public ResponseEntity<Note> createNote(@Valid @RequestBody Note note) throws URISyntaxException {
        LOG.info("Creating a new note.");
        Note result = noteService.create(note);
        return ResponseEntity.created(new URI("/api/v1/notes/" + result.getId())).body(result);
    }

    @PutMapping("/note")
    public ResponseEntity<Note> updateNote(@Valid @RequestBody Note note) {
        LOG.info("Updating a note with ID {}.", note.getId());
        Note uNote = noteService.update(note);
        return ResponseEntity.ok().body(uNote);
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") String id,
            @Valid @RequestBody Note note) throws ResourceNotFoundException {
        Note n = noteService.findOne(id)
                .orElseThrow(() -> new ResourceNotFoundException("given note id not found: " + id));
        n.setAuthor(note.getAuthor());
        n.setTitle(note.getTitle());
        n.setContent(note.getContent());
        final Note updatedNote = noteService.update(note);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/notes/{id}")
    public Map<String, Boolean> removeNote(@PathVariable("id") String id) throws ResourceNotFoundException {
        LOG.info("Deleting a note with ID: {}.", id);
        Note note = noteService.findOne(id)
                .orElseThrow(() -> new ResourceNotFoundException("given note id not found: " + id));
        noteService.delete(note);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping(value = "/notes", params = {"page", "size"})
    @ResponseBody
    public List<Note> findAllByPageAndSize(@RequestParam("page") int page,
            @RequestParam("size") int size) {
        LOG.info("Getting notes from page: " + page + " size: " + size);
        return noteService.findAllByPageAndSize(page, size);
    }
}
