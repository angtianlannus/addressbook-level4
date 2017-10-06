package seedu.address.logic.commands;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.person.ReadOnlyPerson;

import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;


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

    public static final String MESSAGE_SELECT_PERSON_SUCCESS = "List sorted successfully";
    public static final String MESSAGE_INVALID_ATTRIBUTE = "Invalid attribute";

    private final String targetAttribute;

    public SortCommand(String attribute) {
        this.targetAttribute = attribute;
    }

    public CommandResult execute() throws CommandException {

        //List<ReadOnlyPerson> lastShownList = model.getFilteredPersonList();
        if(model.sortFilteredPersonListbyAttribute(targetAttribute)){
            model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
            return new CommandResult(MESSAGE_SELECT_PERSON_SUCCESS);
        }else{
            return new CommandResult(MESSAGE_INVALID_ATTRIBUTE);
        }


    }

}
