package org.kingempire.notebook.sequence;

/**
 * db.sequence.insert({_id: "hosting",seq: 0})
 *
 * @author Anurag Singh
 */
public interface SequenceDao {

    public long getNextSequenceId(String key) throws SequenceException;
}
