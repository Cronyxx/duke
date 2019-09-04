package duke.exception;

/**
 * Represents the exception thrown when the input index of the task is out of bounds of the
 * task list.
 */
public class DukeTaskNotPresentException extends DukeException {

    /**
     * Specifies the message to be printed.
     * @return String which is the message of the exception.
     */
    @Override
    public String toString() {
        return String.format("%s This task is not in list!", super.toString());
    }
}
