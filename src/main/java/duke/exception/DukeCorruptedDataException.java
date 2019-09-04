package duke.exception;

/**
 * Represents the exception thrown when the data within the file does not fit the required format.
 */
public class DukeCorruptedDataException extends DukeException {

    /**
     * Specifies the message to be printed.
     * @return String which is the message of the exception.
     */
    @Override
    public String toString() {
        return String.format("%s Data from file is corrupted!", super.toString());
    }
}
