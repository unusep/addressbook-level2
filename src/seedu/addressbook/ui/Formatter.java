package seedu.addressbook.ui;

import java.util.List;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Formatter will have public methods used by TextUI to format text.
 * @author unusep
 *
 */
public class Formatter {

	/**
	 * formatPersons takes in a list of persons and a list to store the formattedPersons,
	 * and stores all a a list of all formatted persons in formattedPersons
	 * @param persons
	 * @param formattedPersons initially empty list
	 */
	public static void formatPersons(List<? extends ReadOnlyPerson> persons, final List<String> formattedPersons) {
		for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
	}
}
