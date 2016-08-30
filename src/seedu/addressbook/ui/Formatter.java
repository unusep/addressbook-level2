package seedu.addressbook.ui;

import java.util.List;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Formatter will have public methods used by TextUI to format text.
 * @author unusep
 *
 */
public class Formatter {

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
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
	
    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
