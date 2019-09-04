package duke.task;

import java.util.Date;

/**
 * Represents a todo task in the application that extends the Task class.
 * The dateTime field in this class is set to the default Date object as it is not used.
 */
public class TodoTask extends Task {

    /**
     * Initialises a todo task with type set to "T" and a default date Time.
     *
     * @param description Description of the task
     */
    public TodoTask(String description) {
        super(description);
        this.type = "T";
        this.dateTime = new Date();
    }

    /**
     * Initialises a todo task where the user can specify the value of the isDone field.
     * @param description Description of the task.
     * @param isDone Boolean that shows the state of completion of the task.
     */
    public TodoTask(String description, boolean isDone) {
        super(description, isDone);
        this.type = "T";
        this.dateTime = new Date();
    }

    /**
     * Returns A string that includes the type task and the toString of Task.
     *
     * @return String that adds the type of the task to the toString method of Task.
     */
    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }
}
