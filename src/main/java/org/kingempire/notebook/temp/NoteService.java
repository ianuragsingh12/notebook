//package org.kingempire.notebook.service;
//
//import org.kingempire.notebook.dao.SequenceDao;
//import org.kingempire.notebook.model.Note;
//import org.kingempire.notebook.repository.NoteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author Anurag Singh
// */
//@Service
//public class NoteService {
//
//    private static final String HOSTING_SEQ_KEY = "hosting";
//
//    @Autowired
//    private SequenceDao sequenceDao;
//
//    @Autowired
//    private NoteRepository noteRepository;
//
//    public Note create(Note note) {
//        note.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
//        return this.noteRepository.save(note);
//    }
//}
