package duke.command;

import duke.exception.DukeFileSaveException;
import duke.exception.DukeTaskNotPresentException;
import duke.storage.DukeStorage;
import duke.task.Task;
import duke.tasklist.MyList;
import duke.ui.DukeUserInterface;

import java.io.IOException;

/**
 * Represents a command which contains an execute method that deletes a task from the task list.
 * This object accepts task number of the task in the list that is to be deleted from the list.
 */
public class DeleteCommand extends Command {
    private int taskNum;

    /**
     * Initialises a command which contains the task to be deleted.
     *
     * @param taskNum The number of the task specified by the task list.
     */
    public DeleteCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    /**
     * Deletes the specified task from the task list, updates the file and prints the result.
     *
     * @param taskList The main task list of the application.
     * @param ui The main user interface of the application.
     * @param storage The main storage of the application.
     * @throws DukeTaskNotPresentException Thrown when the index of the task is out of bounds.
     * @throws DukeFileSaveException Thrown when the file update fails.
     */
    @Override
    public String execute(MyList taskList, DukeUserInterface ui, DukeStorage storage)
            throws DukeTaskNotPresentException, DukeFileSaveException {
        if (taskNum < 1 || taskNum > taskList.getNumTasks()) {
            throw new DukeTaskNotPresentException();
        }
        Task task = taskList.removeTask(taskNum);
        try {
            storage.updateList(taskList);
        } catch (IOException e) {
            throw new DukeFileSaveException();
        }
        return ui.getDeleteMsg(task, taskList);
    }
}
