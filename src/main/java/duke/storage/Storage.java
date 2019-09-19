package duke.storage;

import duke.exception.DukeCorruptedDataException;
import duke.exception.DukeMissingFileException;
import duke.exception.DukeWrongDateFormatException;
import duke.tag.Tag;
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
import java.util.ArrayList;
import java.util.List;
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
        this.filename = "rooster.txt";
    }

    /**
     * Updates the data in the file by writing to the file.
     *
     * @param taskList Current task list stored in the application.
     * @throws IOException Thrown when writing to file fails.
     */
    @Override
    public void updateList(MyList taskList) throws IOException {
        File file = new File(directory + filename);
        if (!file.exists()) {
            file.getParentFile().mkdir();
        }
        FileWriter fw = new FileWriter(file, false);
        for (Task task : taskList.getList()) {
            StorageItem si;
            if (task.getType().equals("T")) {
                si = new StorageItem(task.getType(), task.getIsDone(), task.getDescription(), task.getTagNames());
            } else {
                si = new StorageItem(task.getType(), task.getIsDone(), task.getDescription(), task.getDateTime(),
                        task.getTagNames());
            }
            fw.write(si.getData() + System.lineSeparator());
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

        List<Tag> tags = new ArrayList<>();

        if (arguments.length == 5) {
            String[] tagArray = arguments[4].split(" ");


            for (String tagName : tagArray) {
                tags.add(new Tag(tagName));
            }
        }

        switch (arguments[0]) {
        case "T":
            return new TodoTask(arguments[2], isDone, tags);
        case "D":
            return new DeadlineTask(arguments[2], arguments[3], isDone, tags);
        case "E":
            return new EventTask((arguments[2]), arguments[3], isDone, tags);
        default:
            throw new DukeCorruptedDataException();
        }
    }

}
