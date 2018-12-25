package org.kingempire.notebook.note;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

/**
 *
 * @author Anurag Singh
 */
@Data
@Document(collection = "notes_v101")
public class Note {

    @Id
    private String id;

    @NotNull
    @Size(min = 2, max = 50)
    @TextIndexed
    private String author;

    @NotNull
    @Size(min = 2, max = 100)
    @TextIndexed
    private String title;

    @NotNull
    @Size(min = 5, max = 10000)
    @TextIndexed
    private String content;

    /**
     * MongoDB returns a score for each search result. We can make it available
     * for our code with the @TextScore annotation. The field must be a Float o
     * Double. It is also handled as a transient field and not stored in the
     * database.
     */
    @TextScore
    private Float textScore;
}
