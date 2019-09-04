package duke.task;

import java.util.Date;

/**
 * Represents a task in the application. A task has four protected fields, the description
 * of the task, the state of completion of the task, the type of the task and the date time
 * information of the task. The Task class supports the getter methods to the four fields,
 * as well as getting the icon (tick and cross) which corresponds to the isDone field. The
 * Task class also supports a markAsDone method which sets the isDone field to true.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected String type;
    protected Date dateTime;

    /**
     * Initialises a Task that has a default isDone field of false.
     *
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Initialises a Task where the user can specify the value of the isDone field.
     *
     * @param description Description of the task.
     * @param isDone Boolean that shows the state of completion of the task.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Returns a tick or a cross depending on the field isDone.
     *
     * @return Icon which shows a tick or a cross.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * Sets the boolean isDone to true.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Returns the description of the task.
     *
     * @return String that represents the description of the task.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the type of the task.
     * @return String that represents the type of the task.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Returns the boolean of whether the task is completed.
     *
     * @return Boolean value of isDone.
     */
    public boolean getIsDone() {
        return this.isDone;
    }

    /**
     * Returns the datetime of the task.
     * @return Date object of the task.
     */
    public Date getDateTime() {
        return this.dateTime;
    }

    /**
     * Returns A string that includes the status icon and the description of the task.
     *
     * @return String with status icon and description of task.
     */
    @Override
    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), getDescription());
    }
}
