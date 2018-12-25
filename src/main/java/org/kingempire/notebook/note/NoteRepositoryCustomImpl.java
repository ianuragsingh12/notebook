package org.kingempire.notebook.note;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anurag Singh
 */
@Repository
public class NoteRepositoryCustomImpl implements NoteRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public NoteRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Note saveNote(Note note) {
        mongoTemplate.save(note);
        return note;
    }

    @Override
    public Note updateNote(Note note) {
        mongoTemplate.save(note);
        return note;
    }

    @Override
    public void deleteNote(Note note) {
        mongoTemplate.remove(note);
    }

    @Override
    public Note findOneByAuthor(String author) {
        Query query = new Query();
        query.addCriteria(Criteria.where("author").is(author));
        return mongoTemplate.findOne(query, Note.class);
    }

    @Override
    public List<Note> findByAuthor(String author) {
        Query query = new Query();
        query.addCriteria(Criteria.where("author").is(author));
        return mongoTemplate.find(query, Note.class);
    }

    @Override
    public Note findOneByTitle(String title) {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(title));
        return mongoTemplate.findOne(query, Note.class);
    }

    @Override
    public List<Note> findByTitle(String title) {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(title));
        return mongoTemplate.find(query, Note.class);
    }

    @Override
    public List<Note> findAllNote() {
        return mongoTemplate.findAll(Note.class);
    }

    @Override
    public List<Note> findAllByPageAndSize(int pageNumber, int pageSize) {
        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);
        return mongoTemplate.find(query, Note.class);
    }

    @Override
    public long getTotalDocumentCount() {
        return mongoTemplate.count(new Query(), Note.class);
    }
}
