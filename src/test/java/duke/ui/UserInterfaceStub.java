package duke.ui;

import duke.constant.Consts;
import duke.task.Task;
import duke.tasklist.MyList;
import duke.tasklist.TaskList;

import java.util.List;
import java.util.Scanner;

public class UserInterfaceStub implements DukeUserInterface {
    private Scanner sc;

    public UserInterfaceStub() {
    }

    @Override
    public String readCommand() {
        return "Testing readCommand";
    }

    //closes scanner
    @Override
    public void exit() {
    }

    //prints line with indentation in front
    @Override
    public void printLine() {
    }

    @Override
    public void printIntro() {
    }

    @Override
    public void printExitMsg() {
    }

    @Override
    public void printAddTaskMsg(Task task, MyList taskList) {
    }

    @Override
    public void printList(MyList myList) {
    }

    @Override
    public void printDoneMsg(Task task) {
    }

    @Override
    public void printException(String msg) {
    }

    @Override
    public void printDeleteMsg(Task task, MyList taskList) {
    }

    @Override
    public void printFindList(MyList resultList) {
    }
}
