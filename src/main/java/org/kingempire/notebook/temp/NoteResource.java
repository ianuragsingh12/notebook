//package org.kingempire.notebook.resource;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import java.util.List;
//import java.util.Optional;
//import org.kingempire.notebook.exception.NoteNotFoundException;
//import org.kingempire.notebook.model.Note;
//import org.kingempire.notebook.service.NoteService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author Anurag Singh
// */
//@RestController
//@RequestMapping("/api/notes")
//@Api(tags = "notes", description = "Note API")
//public class NoteResource {
//
//    private final Logger LOG = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    private NoteService noteService;
//
//    @GetMapping
//    @ApiOperation(value = "List notes", notes = "List all notes")
//    @ApiResponses(value = {
//        @ApiResponse(code = 200, message = "Notes found")
//        ,
//      @ApiResponse(code = 404, message = "Notes not found")
//    })
//    public ResponseEntity<List<Note>> findAll() {
//        LOG.info("Getting all notes.");
//        return ResponseEntity.ok(noteService.findAll());
//    }
//
//    @GetMapping(value = "/{id}")
//    @ApiOperation(value = "Find note", notes = "Find the Note by ID")
//    @ApiResponses(value = {
//        @ApiResponse(code = 200, message = "Note found")
//        ,
//      @ApiResponse(code = 404, message = "Note not found"),})
//    public ResponseEntity<Note> findOne(@PathVariable("id") Long id) {
//        LOG.info("Getting note with ID: {}.", id);
//        Optional<Note> note = noteService.findOne(id);
//        if (note.isPresent()) {
//            return ResponseEntity.ok(note.get());
//        } else {
//            throw new NoteNotFoundException("given note id not found: " + id);
//        }
//    }
//
//    @PostMapping(value = "/add")
//    @ApiOperation(value = "Create note", notes = "It permits to create a new note")
//    @ApiResponses(value = {
//        @ApiResponse(code = 201, message = "Note created successfully")
//        ,
//      @ApiResponse(code = 400, message = "Invalid request")
//    })
//    public ResponseEntity<Note> newNote(@RequestBody Note note) {
//        return new ResponseEntity<>(noteService.create(note), HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @ApiOperation(value = "Remove note", notes = "It permits to remove a note")
//    @ApiResponses(value = {
//        @ApiResponse(code = 200, message = "Note removed successfully")
//        ,
//      @ApiResponse(code = 404, message = "Note not found")
//    })
//    public void removeNote(@PathVariable("id") Long id) {
//    }
//
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @ApiOperation(value = "Update note", notes = "It permits to update a note")
//    @ApiResponses(value = {
//        @ApiResponse(code = 200, message = "Note update successfully")
//        ,
//      @ApiResponse(code = 404, message = "Note not found")
//        ,
//      @ApiResponse(code = 400, message = "Invalid request")
//    })
//    public ResponseEntity<Note> updateNote(@PathVariable("id") Long id, Note note) {
//        return new ResponseEntity<>(new Note(), HttpStatus.OK);
//    }
//}
