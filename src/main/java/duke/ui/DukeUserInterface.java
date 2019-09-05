package duke.ui;

import duke.task.Task;
import duke.tasklist.MyList;

/**
 * Represents an interface of the user interface of the application. Provides methods for
 * reading input and printing output to the console.
 */
public interface DukeUserInterface {

    /**
     * Prints the introduction of the application.
     */
    public String printIntro();

    /**
     * Prints the exit message.
     */
    public String printExitMsg();

    /**
     * Prints a message when a task is added.
     * @param task Task that was added.
     * @param taskList Task List where the Task is stored.
     */
    public String printAddTaskMsg(Task task, MyList taskList);

    /**
     * Prints the list of tasks.
     *
     * @param myList List of tasks stored in the application.
     */
    public String printList(MyList myList);

    /**
     * Prints out a message when a task is marked as done.
     * @param task Task that was marked as done.
     */
    public String printDoneMsg(Task task);

    /**
     * Prints out the exception.
     * @param msg Message of the exception.
     */
    public String printException(String msg);

    /**
     * Prints out the message when a task is deleted.
     * @param task Task that was deleted.
     * @param taskList Task list that the Task was removed from.
     */
    public String printDeleteMsg(Task task, MyList taskList);

    public String printFindList(MyList resultList);
}
