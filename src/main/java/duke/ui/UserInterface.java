package duke.ui;

import duke.constant.Consts;
import duke.task.Task;
import duke.tasklist.MyList;

import java.util.List;
import java.util.Scanner;

/**
 * Represents the user interface of the application. Provides methods for reading input
 * and printing output to the console.
 */
public class UserInterface implements DukeUserInterface {
    private Scanner sc;

    /**
     * Initialises the UserInterface and creating a scanner object.
     */
    public UserInterface() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Reads from standard input and returns it.
     *
     * @return String which consists of user input.
     */
    public String readCommand() {
        String command = "";
        while (command.equals("")) {
            if (!sc.hasNextLine()) {
                continue;
            }
            command = sc.nextLine();
        }
        return command;
    }

    /**
     * Closes the scanner when the application is exiting.
     */
    public void exit() {
        sc.close();
    }

    //prints the logo for the chat bot
    private void printLogo() {
        System.out.println(Consts.LOGO);
    }

    //prints the indentation used for the output
    private void printIndentation() {
        System.out.print("\t");
    }

    /**
     * Prints line with indentation in front.
     */
    public void printLine() {
        printIndentation();
        System.out.println("____________________________________________________________");
    }

    //prints one section(bounded by lines)
    private void printSection(String msg) {
        printIndentation();
        System.out.println(" " + msg);
    }

    //prints one section(bounded by lines) with multiple lines of messages
    private void printSection(String[] msgArray) {
        for (String string : msgArray) {
            printIndentation();
            System.out.println(string);
        }
    }

    /**
     * Prints the introduction of the application.
     */
    public void printIntro() {
        String[] array = new String[2];
        array[0] = " Hello! I'm Duke";
        array[1] = " What can I do for you?";
        printLogo();
        printSection(array);
        printLine();
        System.out.println();
    }

    /**
     * Prints the exit message.
     */
    public void printExitMsg() {
        printSection(" Bye. Hope to see you again soon!");
    }

    /**
     * Prints a message when a task is added.
     *
     * @param task Task that was added.
     * @param taskList Task List where the Task is stored.
     */
    public void printAddTaskMsg(Task task, MyList taskList) {
        String[] array = new String[3];
        array[0] = " Got it. I've added this task: ";
        array[1] = String.format("   %s", task);
        array[2] = String.format(" Now you have %d %s in the list.", taskList.getNumTasks(), taskList.getNumTasks() == 1 ? "task" : "tasks");
        printSection(array);
    }

    /**
     * Prints the list of tasks.
     *
     * @param myList List of tasks stored in the application.
     */
    public void printList(MyList myList) {
        List<Task> list = myList.getList();
        int listNum = 1;

        String[] array = new String[myList.getNumTasks() + 1];
        array[0] = " Here are the tasks in your list:";
        for (Task task : list) {
            array[listNum] = String.format(" %d.%s", listNum, task);
            listNum++;
        }
        printSection(array);
    }

    /**
     * Prints out the list of tasks that matches the String word from the Find command.
     *
     * @param myList MyList of tasks which contains the String word from the Find command.
     */
    public void printFindList(MyList myList) {
        List<Task> list = myList.getList();
        int listNum = 1;

        String[] array = new String[myList.getNumTasks() + 1];
        array[0] = " Here are the matching tasks in your list:";
        for (Task task : list) {
            array[listNum] = String.format(" %d.%s", listNum, task);
            listNum++;
        }
        printSection(array);
    }

    /**
     * Prints out a message when a task is marked as done.
     *
     * @param task Task that was marked as done.
     */
    public void printDoneMsg(Task task) {
        String[] array = new String[2];
        array[0] = " Nice! I've marked this task as done: ";
        array[1] = String.format("   %s", task);
        printSection(array);
    }

    /**
     * Prints out the exception.
     * @param msg Message of the exception.
     */
    public void printException(String msg) {
        printSection(msg);
    }

    /**
     * Prints out the message when a task is deleted.
     * @param task Task that was deleted.
     * @param taskList Task list that the Task was removed from.
     */
    public void printDeleteMsg(Task task, MyList taskList) {
        String[] array = new String[3];
        array[0] = " Noted. I've removed this task: ";
        array[1] = String.format("   %s", task);
        array[2] = String.format(" Now you have %d %s in the list.", taskList.getNumTasks(), taskList.getNumTasks() == 1 ? "task" : "tasks");
        printSection(array);
    }
}
