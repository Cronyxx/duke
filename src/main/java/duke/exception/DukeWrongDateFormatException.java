package duke.exception;

/**
 * Represents the exception thrown when the input format for datetime is invalid.
 */
public class DukeWrongDateFormatException extends DukeException {

    /**
     * Specifies the message to be printed.
     * @return String which is the message of the exception.
     */
    @Override
    public String toString() {
        return String.format("%s Please follow the correct datetime format(dd/mm/yyyy HHMM)", super.toString());
    }
}
