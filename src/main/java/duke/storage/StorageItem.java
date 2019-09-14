package duke.storage;

import duke.constant.Consts;

import java.util.Date;

/**
 * Represents a data unit in the file. It is represented by a String.
 */
public class StorageItem {
    private String data;

    /**
     * Initialises a StorageItem using the type of the task, a boolean which states if the
     * task is done and the description of the task with a datetime value of 0. 0 is used
     * to indicate that the object is of type Todo.
     *
     * @param type Type of Task.
     * @param isDone Boolean that states whether the task is done.
     * @param description Description of the task.
     * @param tags Tags of the task
     */
    public StorageItem(String type, boolean isDone, String description, String tags) {
        data = String.format("%s | %d | %s | 0 | %s", type, isDone ? 1 : 0, description, tags);
    }

    /**
     * Initialises a StorageItem using the type of the task, a boolean which states if the
     * task is done, description of the task and the datetime requirement of the task.
     *
     * @param type Type of Task.
     * @param isDone Boolean that states whether the task is done.
     * @param description Description of the task.
     * @param datetime Date object of the task.
     */
    public StorageItem(String type, boolean isDone, String description, Date datetime, String tags) {
        data = String.format("%s | %d | %s | %s | %s", type, isDone ? 1 : 0, description,
                Consts.DATE_TIME_FORMATTER.format(datetime), tags);
    }

    /**
     * Returns the data of the Storage Item.
     * @return String that contains the formatted data to be stored.
     */
    public String getData() {
        return this.data;
    }
}
