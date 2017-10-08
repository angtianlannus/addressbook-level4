package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;

/***
 * Sort list base on attributes
 * Keywords are key insenstive
 */

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sort list by given single attribute "
            + "the specified attribute (case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: ATTRIBUTE\n"
            + "Example: " + COMMAND_WORD + " name";

    public static final String MESSAGE_LIST_SORT_SUCCESS = "List sorted successfully by %1$s";

    public static final String MESSAGE_INVALID_ATTRIBUTE = "Invalid attribute\n"
            + "Please select one of these attributes: name, phone, email";

    private final String targetAttribute;

    public SortCommand(String attribute) {
        this.targetAttribute = attribute;
    }

    @Override
    public CommandResult execute() throws CommandException {

        StringBuilder sortAttribute = new StringBuilder(targetAttribute);
        sortAttribute.setCharAt(0, Character.toUpperCase(targetAttribute.charAt(0)));

        //model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        if (model.sortFilteredPersonListByAttribute(targetAttribute)) {
            return new CommandResult(String.format(MESSAGE_LIST_SORT_SUCCESS, sortAttribute));
        } else {
            return new CommandResult(MESSAGE_INVALID_ATTRIBUTE);
        }

    }

}
