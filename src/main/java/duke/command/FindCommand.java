package duke.command;

import duke.storage.DukeStorage;
import duke.tasklist.MyList;
import duke.ui.DukeUserInterface;

/**
 * Represents a command which contains an execute method that lists tasks whose description
 * contains the String word.
 */
public class FindCommand extends Command {

    private String word;

    /**
     * Initialises the a command which contains the word to be used to find the list of
     * tasks.
     *
     * @param word String word to be used to check if a task contains it.
     */
    public FindCommand(String word) {
        this.word = word;
    }

    /**
     * Finds the list of tasks from the taskList that contains the String word in the
     * tasks' description. The list of tasks will then be printed out.
     *  @param taskList The main task list of the application.
     * @param ui The main user interface of the application.
     * @param storage The main storage of the application.
     * @return
     */
    public String execute(MyList taskList, DukeUserInterface ui, DukeStorage storage) {
        MyList resultList = taskList.findTasks(word);
        return ui.getFindList(resultList);
    }
}
