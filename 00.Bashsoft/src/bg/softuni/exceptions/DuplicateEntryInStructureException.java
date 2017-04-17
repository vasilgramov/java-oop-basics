package bg.softuni.exceptions;

/**
 * Created by vladix on 4/17/17.
 */
public class DuplicateEntryInStructureException extends RuntimeException {

    private static final String DUPLICATE_ENTRY = "Student %s arleady in %s course!";


    public DuplicateEntryInStructureException(String entryName, String structureName) {
        super(String.format(DUPLICATE_ENTRY, entryName, structureName));
    }

    public DuplicateEntryInStructureException(String message) {
        super(message);
    }

}
