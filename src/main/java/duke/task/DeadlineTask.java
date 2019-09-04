package duke.task;

import duke.constant.Consts;
import duke.exception.DukeWrongDateFormatException;

import java.text.ParseException;

/**
 * Represents a deadline task in the application that extends the Task class.
 */
public class DeadlineTask extends Task {

    /**
     * Initialises a deadline task with the description and date and time of the deadline task.
     *
     * @param description Description of the task.
     * @param deadline String of datetime of the deadline task.
     * @throws DukeWrongDateFormatException Thrown when the String deadline is of the wrong format.
     */
    public DeadlineTask(String description, String deadline) throws DukeWrongDateFormatException {
        super(description);
        try {
            this.dateTime = Consts.DATE_TIME_FORMATTER.parse(deadline);
        } catch (ParseException e) {
            throw new DukeWrongDateFormatException();
        }
        this.type = "D";
    }

    /**
     * Initialises a deadline task with the description, date and time and a boolean representing
     * the completion state of the task.
     *
     * @param description Description of the task.
     * @param deadline String of datetime of the deadline task.
     * @param isDone Boolean representing the completion state of the task.
     * @throws DukeWrongDateFormatException Thrown when the String deadline is of the wrong format.
     */
    public DeadlineTask(String description, String deadline, boolean isDone) throws DukeWrongDateFormatException {
        super(description, isDone);
        try {
            this.dateTime = Consts.DATE_TIME_FORMATTER.parse(deadline);
        } catch (ParseException e) {
            throw new DukeWrongDateFormatException();
        }
        this.type = "D";
    }

    /**
     * Returns A string that includes the type task and the toString of Task.
     *
     * @return String that adds the type of the task to the toString method of Task.
     */
    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), Consts.DATE_TIME_OUTPUT_FORMATTER.format(dateTime));
    }
}
