package duke.tasklist;

import duke.task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the task list used to store the tasks. Provides methods to add a task to the list,
 * getting a List, getting the size of the list, getting a task using the index and removing
 * a task based on the index specified.
 */
public class TaskList implements MyList {
    private List<Task> list;

    /**
     * Initialises the TaskList and creates an ArrayList to store the tasks.
     */
    public TaskList() {
        list = new ArrayList<>();
    }

    /**
     * Adds a task to the task list.
     *
     * @param task Task to be added.
     */
    @Override
    public void add(Task task) {
        list.add(task);
    }

    /**
     * Returns a List of type Task.
     *
     * @return List of tasks.
     */
    @Override
    public List<Task> getList() {
        return list;
    }

    /**
     * Returns the size of the list.
     *
     * @return Size of list.
     */
    @Override
    public int getNumTasks() {
        return list.size();
    }

    /**
     * Returns a task based on the index specified.
     *
     * @param index Index of task tagged in the list.
     * @return Task tagged with the index.
     */
    @Override
    public Task getTask(int index) {
        return list.get(index - 1);
    }

    /**
     * Removes a task from the list based on the index specified.
     *
     * @param index Index of task tagged in the list.
     * @return Task that was removed.
     */
    @Override
    public Task removeTask(int index) {
        return list.remove(index - 1);
    }

    /**
     * Returns a list of tasks in the taskList whose description contain the String word
     * that is passed the method. Returns an empty list if none of the tasks' description
     * contains the word.
     *
     * @param word String to find within the tasks' description
     * @return TaskList of tasks whose description contains word.
     */
    public TaskList findTasks(String word) {
        TaskList taskList = new TaskList();
        
        for (Task task : list) {
            if (task.getDescription().contains(word)) {
                taskList.add(task);
            }
        }
        return taskList;
    }
}
