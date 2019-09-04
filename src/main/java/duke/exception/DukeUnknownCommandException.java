package duke.exception;

/**
 * Represents the exception thrown when an invalid command is entered.
 */
public class DukeUnknownCommandException extends DukeException {

    /**
     * Specifies the message to be printed.
     * @return String which is the message of the exception.
     */
    @Override
    public String toString() {
        return String.format("%s I'm sorry, but I don't know what that means :-(", super.toString());
    }
}
