package duke.storage;

import duke.exception.DukeCorruptedDataException;
import duke.exception.DukeMissingFileException;
import duke.exception.DukeWrongDateFormatException;
import duke.tasklist.MyList;

import java.io.IOException;

/**
 * Represents an Interface for a class responsible for saving and loading of files. Includes
 * methods such as updating the list in the file and retrieving data from the file.
 */
public interface DukeStorage {

    /**
     * Updates the list in the file by writing to the file.
     *
     * @param taskList Current task list stored in the application.
     * @throws IOException Thrown when an error occurred while writing to a file.
     */
    public void updateList(MyList taskList) throws IOException;

    /**
     * Reads the data stored in the file which would then be use to generate a task list
     * that would be returned.
     *
     * @return A list from the data loaded from the file.
     * @throws DukeMissingFileException Thrown when the file does not exist.
     * @throws DukeCorruptedDataException Thrown when the data of the file is corrupted.
     * @throws DukeWrongDateFormatException Thrown when the datetime Format is wrong.
     */
    public MyList loadList() throws DukeMissingFileException, DukeCorruptedDataException, DukeWrongDateFormatException;
}
