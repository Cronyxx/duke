package duke.exception;

/**
 * Represents the exception thrown when the keyword after the command is missing.
 */
public class DukeMissingKeywordException extends DukeException {

    /**
     * Specifies the message to be printed.
     * @return String which is the message of the exception.
     */
    @Override
    public String toString() {
        return String.format("%s Keyword cannot be found!", super.toString());
    }
}
