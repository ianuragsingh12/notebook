//package org.kingempire.notebook.temp;
//
//import java.util.List;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import lombok.Data;
//import org.kingempire.notebook.Note.Note;
//import org.kingempire.notebook.Note.NoteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.index.TextIndexed;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.TextScore;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//
///**
// *
// * @author Anurag Singh
// */
//@Repository
//interface NotRepo extends MongoRepository<Not, String> {
//
//}
//
//public class DataTransferBetweenCollectionNote {
//
//    @Autowired
//    NotRepo o;
//
//    @Autowired
//    NoteRepository no;
//
//    public void transfer() {
//        List<Not> ll = o.findAll();
//        for (int i = 0; i < ll.size(); i++) {
//            Note n = new Note();
//            n.setAuthor("King");
//            n.setTitle(ll.get(i).getCategory() + " " + ll.get(i).getTitle());
//            n.setContent(ll.get(i).getContent());
//            no.save(n);
//
//        }
//        System.out.println("Done!");
//    }
//}
//
//@Data
//@Document(collection = "notes")
//class Not {
//
//    @Id
//    private String id;
//
//    @NotNull
//    @Size(min = 2, max = 50)
//    @TextIndexed
//    private String category;
//
//    @NotNull
//    @Size(min = 2, max = 50)
//    @TextIndexed
//    private String title;
//
//    @NotNull
//    @Size(min = 5, max = 5000)
//    @TextIndexed
//    private String content;
//
//    /**
//     * MongoDB returns a score for each search result. We can make it available
//     * for our code with the @TextScore annotation. The field must be a Float o
//     * Double. It is also handled as a transient field and not stored in the
//     * database.
//     */
//    @TextScore
//    private Float textScore;
//}
