package duke.parser;

import duke.command.*;
import duke.exception.*;

/**
 * Represents a class that takes in inputs and translates them into different commands.
 */
public class Parser {

    /**
     * Takes in a string input and convert the input into a command which performs a set of
     * instructions on the task list, ui and storage.
     *
     * @param input String that contains the input of the user.
     * @return A command that execute a set of instructions.
     * @throws DukeException Thrown when there is a Duke exception.
     */
    public static Command parse(String input) throws DukeException {
        String[] arguments = input.split(" ");

        switch (arguments[0]) {
        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand();
        case "done":
            //Fallthrough
        case "delete":
            int num;
            try {
                num = Integer.parseInt(arguments[1]);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                throw new DukeIntFormatException(arguments[0]);
            }
            if (arguments[0].equals("done")) {
                return new DoneCommand(num);
            } else {
                return new DeleteCommand(num);
            }
        case "deadline":
            //Fallthrough
        case "event":
            //Fallthrough
        case "todo":
            if (arguments.length == 1) {
                throw new DukeEmptyDescriptionException(arguments[0]);
            }

            int index = -1;

            if (arguments[0].equals("deadline")) {
                index = findIndexByToken(arguments, "/by");
                if (index == -1) {
                    throw new DukeMissingDateTimeException(arguments[0]);
                }
            } else if (arguments[0].equals("event")) {
                index = findIndexByToken(arguments, "/at");
                if (index == -1) {
                    throw new DukeMissingDateTimeException(arguments[0]);
                }
            }

            if (arguments[0].equals("todo")) {
                String description = parseArguments(arguments, 1, arguments.length);
                return new AddCommand(arguments[0], description, "00/00/0000 0000");
            } else {
                String description = parseArguments(arguments, 1, index);
                String dateTime = parseArguments(arguments, index + 1, arguments.length);
                return new AddCommand(arguments[0], description, dateTime);
            }
        case "find":
            if (arguments.length == 1) {
                throw new DukeMissingKeywordException();
            }
            return new FindCommand(arguments[1]);
        default:
            throw new DukeUnknownCommandException();
        }
    }

    //returns index of token if found, else returns -1
    //stops at first occurrence of token
    private static int findIndexByToken(String[] array, String token) {
        int index = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i].equals(token)) {
                index = i;
                break;
            }
        }
        return index;
    }

    // Combines words into a sentence
    private static String parseArguments(String[] array, int start, int end) {
        if (start >= end) {
            return "";
        }
        StringBuilder result = new StringBuilder(array[start]);
        for (int i = start + 1; i < end; i++) {
            result.append(" ").append(array[i]);
        }
        return result.toString();
    }
}
