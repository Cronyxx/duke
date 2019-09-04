package duke.exception;

/**
 * Represents the exception thrown when the input of datetime is missing.
 */
public class DukeMissingDateTimeException extends DukeException {
    private String type;

    /**
     * Initialises the exception that specifies the type of task.
     * @param type Type of Task.
     */
    public DukeMissingDateTimeException(String type) {
        this.type = type;
    }

    /**
     * Specifies the message to be printed.
     * @return String which is the message of the exception.
     */
    @Override
    public String toString() {
        return String.format("%s Datetime for %s must be specified!", super.toString(), type);
    }
}
