package duke.exception;

/**
 * Represents the exception thrown when the input is not an Integer.
 */
public class DukeIntFormatException extends DukeException {
    private String type;

    /**
     * Initialises the exception that specifies the type of task.
     * @param type Type of Task.
     */
    public DukeIntFormatException(String type) {
        this.type = type;
    }

    /**
     * Specifies the message to be printed.
     * @return String which is the message of the exception.
     */
    @Override
    public String toString() {
        return String.format("%s Please add an integer after %s!", super.toString(), type);
    }
}
