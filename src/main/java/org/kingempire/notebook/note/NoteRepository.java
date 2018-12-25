package org.kingempire.notebook.note;

import java.util.List;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anurag Singh
 */
@Repository
public interface NoteRepository extends MongoRepository<Note, String>, NoteRepositoryCustom {

    public List<Note> findAllBy(TextCriteria criteria);
}
