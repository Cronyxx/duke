package duke.ui;

import duke.task.Task;
import duke.tasklist.MyList;

import java.util.List;

/**
 * Represents the user interface of the application. Provides methods for reading input
 * and printing output to the console.
 */
public class UserInterface implements DukeUserInterface {

    /**
     * Prints the introduction of the application.
     */
    public String getIntro() {
        return "Hello! I'm Duke!\n"
                + "What can I do for you?";
    }

    /**
     * Prints the exit message.
     */
    public String getExitMsg() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * Prints a message when a task is added.
     *
     * @param task Task that was added.
     * @param taskList Task List where the Task is stored.
     * @return String which represents the output text.
     */
    public String getAddTaskMsg(Task task, MyList taskList) {
        return String.format("Got it. I've added this task: \n%s\nNow you have %d %s in the list.", task,
                taskList.getNumTasks(), taskList.getNumTasks() == 1 ? "task" : "tasks");
    }

    /**
     * Prints the list of tasks.
     *
     * @param myList List of tasks stored in the application.
     * @return String which represents the output text.
     */
    public String getList(MyList myList) {
        StringBuilder sb = new StringBuilder();
        List<Task> list = myList.getList();
        int listNum = 1;

        String[] array = new String[myList.getNumTasks() + 1];
        sb.append("Here are the tasks in your list:\n");
        for (Task task : list) {
            sb.append(String.format(" %d.%s\n", listNum, task));
            listNum++;
        }
        return sb.toString();
    }

    /**
     * Prints out the list of tasks that matches the String word from the Find command.
     *
     * @param myList MyList of tasks which contains the String word from the Find command.
     * @return String which represents the output text.
     */
    public String getFindList(MyList myList) {
        StringBuilder sb = new StringBuilder();
        List<Task> list = myList.getList();
        int listNum = 1;

        String[] array = new String[myList.getNumTasks() + 1];
        sb.append("Here are the matching tasks in your list:\n");
        for (Task task : list) {
            sb.append(String.format(" %d.%s\n", listNum, task));
            listNum++;
        }
        return sb.toString();
    }

    /**
     * Prints out a message when a task is marked as done.
     *
     * @param task Task that was marked as done.
     * @return String which represents the output text.
     */
    public String getDoneMsg(Task task) {
        return String.format("Nice! I've marked this task as done\n%s", task);
    }

    /**
     * Prints out the exception.
     *
     * @param msg Message of the exception.
     * @return String which represents the output text.
     */
    public String getException(String msg) {
        return msg;
    }

    /**
     * Prints out the message when a task is deleted.
     *
     * @param task Task that was deleted.
     * @param taskList Task list that the Task was removed from.
     * @return String which represents the output text.
     */
    public String getDeleteMsg(Task task, MyList taskList) {
        return String.format("Noted. I've removed this task:\n%s\nNow you have %d %s in the list.",
                task, taskList.getNumTasks(), taskList.getNumTasks() == 1 ? "task" : "tasks");
    }
}
