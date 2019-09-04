package duke.task;

import duke.constant.Consts;
import duke.exception.DukeWrongDateFormatException;

import java.text.ParseException;

/**
 * Represents an event task in the application that extends the Task class.
 */
public class EventTask extends Task {

    /**
     * Initialises an event task with the description and date and time of the event.
     *
     * @param description Description of the task.
     * @param startDate String of datetime of the event task.
     * @throws DukeWrongDateFormatException Thrown when the String startDate is of the wrong format.
     */
    public EventTask(String description, String startDate) throws DukeWrongDateFormatException {
        super(description);
        try {
            this.dateTime = Consts.DATE_TIME_FORMATTER.parse(startDate);
        } catch (ParseException e) {
            throw new DukeWrongDateFormatException();
        }
        this.type = "E";
    }

    /**
     * Initialises an event task with the description, date and time and a boolean representing
     * the completion state of the task.
     *
     * @param description Description of the task.
     * @param startDate String of datetime of the event task.
     * @param isDone Boolean representing the completion state of the task.
     * @throws DukeWrongDateFormatException Thrown when the String startDate is of the wrong format.
     */
    public EventTask(String description, String startDate, boolean isDone) throws DukeWrongDateFormatException {
        super(description, isDone);
        try {
            this.dateTime = Consts.DATE_TIME_FORMATTER.parse(startDate);
        } catch (ParseException e) {
            throw new DukeWrongDateFormatException();
        }
        this.type = "E";
    }

    /**
     * Returns A string that includes the type task, start date of the event and the
     * toString of Task.
     *
     * @return String that adds the type of the task and start date to the toString method of Task.
     */
    @Override
    public String toString() {
        return String.format("[E]%s (at: %s)", super.toString(), Consts.DATE_TIME_OUTPUT_FORMATTER.format(dateTime));
    }
}
