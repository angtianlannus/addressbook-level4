package seedu.address.logic.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.Before;
import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.UndoRedoStack;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;


/**
 * Contains integration tests (interaction with the Model) and unit tests for SortCommand.
 */

public class SortCommandTest {

    private Model model;
    private Model expectedModel;
    private SortCommand sortCommand;

    @Before
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void equals() {

        SortCommand sortByName = new SortCommand("name");
        SortCommand sortByAddress = new SortCommand("address");
        SortCommand sortByPhoneNumber = new SortCommand("phone");

        // same object -> returns true
        assertTrue(sortByAddress.equals(sortByAddress));

        // different types -> returns false
        assertFalse(sortByPhoneNumber.equals("sortByName"));

        // null -> returns false
        assertFalse(sortByName.equals(null));

        // different attribute -> returns false
        assertFalse(sortByAddress.equals(sortByName));
    }

    @Test
    public void execute_validAttributeName_showSortedList() {
        sortCommand = new SortCommand("name");
        sortCommand.setData(model, new CommandHistory(), new UndoRedoStack());
        assertCommandSuccess(sortCommand, model,
                String.format(SortCommand.MESSAGE_LIST_SORT_SUCCESS, "Name"),
                expectedModel);
    }

    @Test
    public void execute_invalidAttribute_showsUnsortedList() {
        sortCommand = new SortCommand("race");
        sortCommand.setData(model, new CommandHistory(), new UndoRedoStack());
        assertCommandSuccess(sortCommand, model,
                SortCommand.MESSAGE_INVALID_ATTRIBUTE,
                expectedModel);
    }


}
