package duke.command;

import duke.storage.DukeStorage;
import duke.tasklist.MyList;
import duke.ui.DukeUserInterface;

/**
 * Represents a command which contains an execute method that exits the application.
 */
public class ExitCommand extends Command {

    /**
     * Prints the exit message.
     *
     * @param taskList The main task list of the application.
     * @param ui The main user interface of the application.
     * @param storage The main storage of the application.
     */
    @Override
    public String execute(MyList taskList, DukeUserInterface ui, DukeStorage storage) {
        return ui.getExitMsg();
    }

    /**
     * Returns true when an exit command is called. Else, returns false.
     *
     * @return Boolean which states whether to exit the application.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
