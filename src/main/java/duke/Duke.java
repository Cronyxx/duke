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
 *
 * This application reads word by word so any additional arguments would be ignored.
 */
public class Duke {
    private MyList taskList;
    private Storage storage;
    private UserInterface ui;

    /**
     * Initialises a new Duke application.
     * @param directory Directory of which the file is stored.
     */
    public Duke(String directory) {
        storage = new Storage(directory);
        ui = new UserInterface();
        try {
            taskList = storage.loadList();
        } catch (DukeException e) {
            ui.printException(e.toString());
            taskList = new TaskList();
        }

    }

    /**
     * Creates a new Duke object and runs the application.
     * @param args Arguments from console.
     */
    public static void main(String[] args) {
        Duke duke = new Duke("./data/");
        duke.run();
        duke.exit();
    }

    /**
     * Starts the main application loop.
     */
    public void run() {
        ui.printIntro();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.printLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.printException(e.toString());
            } finally {
                ui.printLine();
            }
        }
    }

    /**
     * Handles the exit logic of the application.
     */
    public void exit() {
        ui.exit();
    }
}

