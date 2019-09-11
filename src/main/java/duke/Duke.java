package duke;

import duke.command.Command;
import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.tasklist.MyList;
import duke.tasklist.TaskList;
import duke.ui.UserInterface;

/**
 * Duke is a task manager which allows users to organise their tasks by adding different types
 * of tasks, list out the tasks, marking the tasks as done, deleting the task and storing the
 * tasks into a file so that they can be retrieved the next time the user uses the application.
 * This application reads word by word so any additional arguments would be ignored.
 */
public class Duke {
    private MyList taskList;
    private Storage storage;
    private UserInterface ui;

    /**
     * Initialises a new Duke application.
     */
    public Duke() {
        storage = new Storage("./data/");
        ui = new UserInterface();
        try {
            taskList = storage.loadList();
        } catch (DukeException e) {
            ui.getException(e.toString());
            taskList = new TaskList();
        }
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    String getResponse(String input) {

        assert input != null : " Input cannot be null";

        try {
            Command c = Parser.parse(input);
            return c.execute(taskList, ui, storage);
        } catch (DukeException e) {
            return ui.getException(e.toString());
        }
    }



}

