package duke.exception;

/**
 * Represents the exception thrown when updating the file fails.
 */
public class DukeFileSaveException extends DukeException {

    /**
     * Specifies the message to be printed.
     * @return String which is the message of the exception.
     */
    @Override
    public String toString() {
        return String.format("%s Failed to save to file!", super.toString());
    }
}
