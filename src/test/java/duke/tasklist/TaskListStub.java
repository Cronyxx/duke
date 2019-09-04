package duke.tasklist;

import duke.task.Task;
import duke.task.TodoTask;

import java.util.ArrayList;
import java.util.List;

public class TaskListStub implements MyList {
    private List<Task> list;

    public TaskListStub() {
        list = new ArrayList<>();
    }

    //adds a task to the list
    @Override
    public void add(Task task) {
    }

    //returns the list of Strings
    @Override
    public List<Task> getList() {
        return list;
    }

    @Override
    public int getNumTasks() {
        return 10;
    }

    //index is the number shown when list is called
    @Override
    public Task getTask(int index) {
        return new TodoTask("Testing get task");
    }

    @Override
    public Task removeTask(int index) {
        return new TodoTask("Testing remove task");
    }

    @Override
    public MyList findTasks(String word) {
        return new TaskList();
    }
}
