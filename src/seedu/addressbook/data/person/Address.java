package seedu.addressbook.data.person;

import seedu.addressbook.data.address.Block;
import seedu.addressbook.data.address.PostalCode;
import seedu.addressbook.data.address.Street;
import seedu.addressbook.data.address.Unit;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS 
    	= "Person addresses must be in the following format: BLK, STREET, UNIT, POSTALCODE";
    public static final String ADDRESS_VALIDATION_REGEX 
    	= "^" // start of string
    			+ "([^,]*,){3}" // check there are characters before a comma 3 times
    			+ "[^,]*$"; // check check that after the 3rd comma, 
    						// there are no more commas until the end of the string

    public final String value;
    private boolean isPrivate;
    
    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = address;
        
        String[] tokens = address.split(", ");
        block = new Block(tokens[0]);
        street = new Street(tokens[1]);
        unit = new Unit(tokens[2]);
        postalCode = new PostalCode(tokens[3]);
        
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block + ", "
        		+ street + ", "
        		+ unit + ", "
        		+ postalCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}