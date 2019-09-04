package duke.exception;

/**
 * Represents the exception thrown when the description of the task is empty.
 */
public class DukeEmptyDescriptionException extends DukeException {
    private String type;

    /**
     * Initialises an exception with type of the task specified.
     *
     * @param type Type of Task
     */
    public DukeEmptyDescriptionException(String type) {
        this.type = type;
    }

    /**
     * Specifies the message to be printed.
     *
     * @return String which is the message of the exception.
     */
    @Override
    public String toString() {
        return String.format("%s The description of %s cannot be empty!", super.toString(), type);
    }
}
