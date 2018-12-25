package org.kingempire.notebook.note;

import java.util.List;

/**
 *
 * @author Anurag Singh
 */
public interface NoteRepositoryCustom {

    public Note saveNote(Note note);

    public Note updateNote(Note note);

    public void deleteNote(Note note);

    public Note findOneByAuthor(String author);

    public List<Note> findByAuthor(String author);

    public Note findOneByTitle(String title);

    public List<Note> findByTitle(String title);

    public List<Note> findAllNote();

    public List<Note> findAllByPageAndSize(int pageNumber, int pageSize);

    public long getTotalDocumentCount();
}
