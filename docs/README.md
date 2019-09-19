# User Guide
![RoosterUI](Ui.png)
## Features 

### Adding Task
You can add three types of task to the task list, mainly a Todo 
task, an Event task and a Deadline task.

### Completing Task
You can mark a task as done once you have completed the task.

### Deleting of Task
You can delete any task from the task list once you no longer need them.

### Listing out tasks
You can list out all the task that you have added to the task list for viewing.

### Finding tasks via keywords
You can search for tasks that contains the keywords you specify. 

### Automatic loading and saving 
Your tasks would be saved to a text file whenever you update your task list 
and loaded to the application whenever you start up the application.

### Adding and Deleting of tags
You can add tags to your tasks and delete them from your tasks.


## Usage

### `todo` - Adds a todo task

Adds a todo task to the task list. 

Example of usage: 

`todo <description>`

Expected outcome:

`A new Todo task with <description> would be 
added to the task list.`

### `event` - Adds an event task

Adds an event task to the task list.

Example of usage:

`event <description> /at <dd/mm/yyyy HHHH>`

Expected outcome:

`A new Event task with <description> and a event date time 
at <dd/mm/yyyy HHHH> would be added to the task list.`

### `deadline` - Adds a deadline task

Adds a deadline task to the task list.

Example of usage:

`deadline <description> /by <dd/mm/yyyy HHHH>`

Expected outcome:

`A new Deadline task with <description> and a deadline 
of <dd/mm/yyyy HHHH> would be added to the task list.`

### `done` - Marks a task as complete

Marks a task in the task list as complete, resulting in a tick 
beside of the task.

Example of usage:

`done <index>`

Expected outcome:

`A tick would be shown beside of the task.`

### `delete` - Deletes a task

Deletes a task from the task list.

Example of usage:

`delete <index>`

Expected outcome:

`The task with index of <index> would be removed and 
no longer be shown in the task list.`

### `list` - Lists out the task list

Lists out all the tasks in the task list.

Example of usage:

`list`

Expected outcome:

`All the tasks in the task list would be shown.`

### `find` - Finds tasks via keyword

Finds all the tasks via the keyword and lists them out.

Example of usage:

`find <keyword>`

Expected outcome:

`All the tasks that contains <keyword> would be listed out.`

### `tag` - Adds a tag to a task

Adds a tag with a tag name to the specified task.

Example of usage:

`tag <index> <tagName>`

Expected outcome:

`The task with the index of <index> would be tagged with a tag 
with the tag name <tagName>.`

### `deletetag` - Deletes a tag from a task

Deletes a specified tag from the specified task.

Example of usage:

`deletetag <index> <tagName>`

Expected outcome:

`The task with the index of <index> would have a tag with a tag name of <tagName> removed.`

### `bye` - Exits the application

Quits the application.

Example of usage:

`bye`

Expected outcome:

`The application is closed.`
