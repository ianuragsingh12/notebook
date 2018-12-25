package org.kingempire.notebook.note;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anurag Singh
 */
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note create(Note note) {
        return this.noteRepository.save(note);
    }

    public Note update(Note note) {
        return this.noteRepository.save(note);
    }

    public void delete(Note note) {
        this.noteRepository.delete(note);
    }

    public Optional<Note> findOne(String id) {
        return this.noteRepository.findById(id);
    }

    public List<Note> findAll() {
        return this.noteRepository.findAll();
    }

    public List<Note> findAllBySearchString(String searchString) {
        TextCriteria search = TextCriteria.forDefaultLanguage().matching(searchString);
        return this.noteRepository.findAllBy(search);
    }

    public List<Note> findAllByPageAndSize(int pageNumber, int pageSize) {
        return this.noteRepository.findAllByPageAndSize(pageNumber, pageSize);
    }

    public long getTotalDocumentCount() {
        return this.noteRepository.getTotalDocumentCount();
    }
}
