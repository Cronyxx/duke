package duke.tasklist;

import duke.task.Task;

import java.util.List;

/**
 * Represents an interface of a task list. Provides methods to add a task to the list,
 * getting a List, getting the size of the list, getting a task using the index and removing
 * a task based on the index specified.
 */
public interface MyList {

    /**
     * Adds a task to the task list.
     *
     * @param task Task to be added.
     */
    public abstract void add(Task task);

    /**
     * Returns a List of type Task.
     *
     * @return List of tasks.
     */
    public abstract List<Task> getList();

    /**
     * Returns the size of the list.
     *
     * @return Size of list.
     */
    public abstract int getNumTasks();

    /**
     * Returns a task based on the index specified.
     *
     * @param index Index of task tagged in the list.
     * @return Task tagged with the index.
     */
    public abstract Task getTask(int index);

    /**
     * Removes a task from the list based on the index specified.
     *
     * @param index Index of task tagged in the list.
     * @return Task that was removed.
     */
    public abstract Task removeTask(int index);

    /**
     * Returns a list of tasks in the taskList whose description contain the String word
     * that is passed the method. Returns an empty list if none of the tasks' description
     * contains the word.
     *
     * @param word String to find within the tasks' description.
     * @return MyList of tasks whose description contains word.
     */
    public abstract MyList findTasks(String word);
}
