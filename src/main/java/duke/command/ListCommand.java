package duke.command;

import duke.storage.DukeStorage;
import duke.tasklist.MyList;
import duke.ui.DukeUserInterface;

/**
 * Represents a command which contains an execute method that lists the task list.
 */
public class ListCommand extends Command {

    /**
     * Lists all the tasks in the task list and prints them out.
     *  @param taskList The main task list of the application.
     * @param ui The main user interface of the application.
     * @param storage The main storage of the application.
     * @return
     */
    @Override
    public String execute(MyList taskList, DukeUserInterface ui, DukeStorage storage) {
        return ui.getList(taskList);
    }
}
