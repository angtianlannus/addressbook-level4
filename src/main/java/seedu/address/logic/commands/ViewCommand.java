package seedu.address.logic.commands;

import static seedu.address.model.ListingUnit.ADDRESS;
import static seedu.address.model.ListingUnit.EMAIL;
import static seedu.address.model.ListingUnit.PERSON;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.core.EventsCenter;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.events.ui.ChangeListingUnitEvent;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ListingUnit;
import seedu.address.model.person.FixedAddressPredicate;
import seedu.address.model.person.ReadOnlyPerson;
import seedu.address.model.person.ShowSpecifiedPersonPredicate;

/**
 * Views all persons with the selected listing unit from the address book.
 */
public class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Views all persons with the selected listing attribute from the address book.\n"
            + " It will simply listing the person of select index if the panel is currently listing all persons.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_VIEW_PERSON_SUCCESS = "persons founded with %1$s";

    private final Index targetIndex;

    public ViewCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute() throws CommandException {

        List<ReadOnlyPerson> lastShownList = model.getFilteredPersonList();
        ListingUnit currentUnit = ListingUnit.getCurrentListingUnit();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        ReadOnlyPerson toView = lastShownList.get(targetIndex.getZeroBased());

        Predicate predicate;
        String resultMessage;


        switch (currentUnit) {
            case PERSON:
                predicate = new ShowSpecifiedPersonPredicate(toView);
                model.updateFilteredPersonList(predicate);
                resultMessage = String.format(MESSAGE_VIEW_PERSON_SUCCESS, toView);

            case ADDRESS:
                predicate = new FixedAddressPredicate(toView.getAddress());
                model.updateFilteredPersonList(predicate);
                ListingUnit.setCurrentListingUnit(PERSON);
                EventsCenter.getInstance().post(new ChangeListingUnitEvent(PERSON));
                resultMessage = String.format(MESSAGE_VIEW_PERSON_SUCCESS, toView.getAddress());

            case EMAIL:
                predicate = new FixedAddressPredicate(toView.getAddress());
                model.updateFilteredPersonList(predicate);
                ListingUnit.setCurrentListingUnit(PERSON);
                EventsCenter.getInstance().post(new ChangeListingUnitEvent(PERSON));
                resultMessage = CommandResult(String.format(MESSAGE_VIEW_PERSON_SUCCESS, toView.getEmail());

            case PHONE:
                predicate = new FixedAddressPredicate(toView.getAddress());
                model.updateFilteredPersonList(predicate);
                ListingUnit.setCurrentListingUnit(PERSON);
                EventsCenter.getInstance().post(new ChangeListingUnitEvent(PERSON));
                resultMessage = String.format(MESSAGE_VIEW_PERSON_SUCCESS, toView.getPhone());
        }


    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ViewCommand // instanceof handles nulls
                && this.targetIndex.equals(((ViewCommand) other).targetIndex)); // state check
    }
}
