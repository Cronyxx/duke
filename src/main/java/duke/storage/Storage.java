package duke.storage;

import duke.exception.DukeCorruptedDataException;
import duke.exception.DukeMissingFileException;
import duke.exception.DukeWrongDateFormatException;
import duke.task.DeadlineTask;
import duke.task.EventTask;
import duke.task.Task;
import duke.task.TodoTask;
import duke.tasklist.MyList;
import duke.tasklist.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents the storage of the application. Has methods that support the updating
 * of file and loading data from the file.
 */
public class Storage implements DukeStorage {
    private String directory;
    private String filename;

    /**
     * Initialises the Storage with the directory of which the file resides and the name
     * of the file.
     *
     * @param directory String of the directory the file is in.
     */
    public Storage(String directory) {
        this.directory = directory;
        this.filename = "duke.txt";
    }

    /**
     * Updates the data in the file by writing to the file.
     *
     * @param taskList Current task list stored in the application.
     * @throws IOException Thrown when writing to file fails.
     */
    @Override
    public void updateList(MyList taskList) throws IOException {
        FileWriter fw = new FileWriter(directory + filename, false);
        for (Task task : taskList.getList()) {
            StorageItem sI;
            if (task.getType().equals("T")) {
                sI = new StorageItem(task.getType(), task.getIsDone(), task.getDescription());
            } else {
                sI = new StorageItem(task.getType(), task.getIsDone(), task.getDescription(), task.getDateTime());
            }
            fw.write(sI.getData() + System.lineSeparator());
        }
        fw.close();
    }

    /**
     * Reads the data stored in the file which would then be use to generate a task list
     * that would be returned.
     *
     * @return A list from the data loaded from the file.
     * @throws DukeMissingFileException Thrown when the file does not exist.
     * @throws DukeCorruptedDataException Thrown when the data of the file is corrupted.
     * @throws DukeWrongDateFormatException Thrown when the datetime Format is wrong.
     */
    @Override
    public MyList loadList() throws DukeMissingFileException, DukeCorruptedDataException, DukeWrongDateFormatException {
        MyList taskList = new TaskList();
        File file = new File(directory + filename);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                Task task = dataParser(sc.nextLine());
                taskList.add(task);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new DukeMissingFileException();
        }
        return taskList;
    }

    private Task dataParser(String data) throws DukeCorruptedDataException, DukeWrongDateFormatException {

        assert data != null : " Data is null";

        String[] arguments = data.split(" \\| ");
        boolean isDone;
        isDone = arguments[1].equals("1");

        switch (arguments[0]) {
        case "T":
            return new TodoTask(arguments[2], isDone);
        case "D":
            return new DeadlineTask(arguments[2], arguments[3], isDone);
        case "E":
            return new EventTask((arguments[2]), arguments[3], isDone);
        default:
            throw new DukeCorruptedDataException();
        }
    }

}
