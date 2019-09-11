package duke.command;

import duke.exception.DukeFileSaveException;
import duke.exception.DukeWrongDateFormatException;
import duke.storage.DukeStorage;
import duke.task.DeadlineTask;
import duke.task.EventTask;
import duke.task.Task;
import duke.task.TodoTask;
import duke.tasklist.MyList;
import duke.ui.DukeUserInterface;

import java.io.IOException;

/**
 * Represents a command which contains an execute method that adds a task to the task list.
 * The AddCommand object requires the type, description and datetime of the task that is to be
 * added to the list.
 */
public class AddCommand extends Command {
    private String type;
    private String description;
    private String dateTime;

    /**
     * Initialises a command which contains the task to be added.
     *
     * @param type Type of Task.
     * @param description Description of Task.
     * @param dateTime Date and Time of Task.
     */
    public AddCommand(String type, String description, String dateTime) {
        this.type = type;
        this.description = description;
        this.dateTime = dateTime;
    }

    /**
     * Adds the specified task to the task list, stores the task into the file and
     * prints the result.
     *
     * @param taskList The main task list of the application.
     * @param ui The main user interface of the application.
     * @param storage The main storage of the application.
     * @throws DukeFileSaveException Thrown when the new task cannot be added to the file.
     * @throws DukeWrongDateFormatException Thrown when the user enters the wrong format for the datetime of the task.
     */
    @Override
    public String execute(MyList taskList, DukeUserInterface ui, DukeStorage storage) throws DukeFileSaveException,
            DukeWrongDateFormatException {
        Task task;
        if (type.equals("todo")) {
            task = new TodoTask(description);
        } else if (type.equals(("deadline"))) {
            task = new DeadlineTask(description, dateTime);
        } else {
            task = new EventTask(description, dateTime);
        }

        taskList.add(task);

        try {
            storage.updateList(taskList);
        } catch (IOException e) {
            throw new DukeFileSaveException();
        }
        return ui.getAddTaskMsg(task, taskList);
    }
}
