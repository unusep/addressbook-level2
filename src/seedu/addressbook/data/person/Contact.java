package seedu.addressbook.data.person;

public class Contact {
    public final String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate){
    	this.value = value;
    	this.isPrivate = isPrivate;
    }

    /**
     * Checks if a given string is a valid person email.
     */
    public static boolean isValidEmail(String test, String regex) {
        return test.matches(regex);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Email // instanceof handles nulls
                && this.value.equals(((Email) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
