package duke.exception;

/**
 * Represents the exception thrown when the file does not exist.
 */
public class DukeMissingFileException extends DukeException {

    /**
     * Specifies the message to be printed.
     * @return String which is the message of the exception.
     */
    @Override
    public String toString() {
        return String.format("%s File cannot be found!", super.toString());
    }
}
