package seedu.addressbook.main;

import org.junit.jupiter.api.Test;
import seedu.addressbook.Main;
import seedu.addressbook.commands.Command;
import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.storage.StorageFile;
import seedu.addressbook.ui.TextUi;

import java.util.Collections;
import java.util.List;

public class MainTest {
    /** Version info of the program. */
    public static final String VERSION = "AddressBook Level 2 - Version 1.0";

    private TextUi ui;
    private StorageFile storage;
    private AddressBook addressBook;

    /** The list of person shown to the user most recently.  */
    private List<? extends ReadOnlyPerson> lastShownList = Collections.emptyList();

    @Test
    public CommandResult executeCommand(Command command) {

        try {
            this.ui = new TextUi();
            this.storage = new StorageFile();
            this.addressBook = storage.load();
        } catch (StorageFile.InvalidStorageFilePathException | StorageFile.StorageOperationException e) {
            e.printStackTrace();
        }

        Command command_input = new Command();


    }

}

/*

private CommandResult executeCommand(Command command) {
        try {
            command.setData(addressBook, lastShownList);
            CommandResult result = command.execute();
            storage.save(addressBook);
            return result;
        } catch (Exception e) {
            ui.showToUser(e.getMessage());
            throw new RuntimeException(e);
        }
    }

 */