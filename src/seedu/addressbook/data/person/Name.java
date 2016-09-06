package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        name = name.trim();
        if (!isValidName(name)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = name;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }
    
    /**
     * Returns true if the other name is very similar to this name.
     * Returns false if the names are dissimilar or one of the names is null.
     * 
     * Two names are considered similar if 
     * 1) They are exactly the same except for differences in capitalisation
     * 2) They are the same except for omission in any one part of the name (John Smith similar to John K Smith)
     * 3) They are permutations of each other (John K Smith similar to Smith John K)
     * 4) They fit any of the above categories disregarding commas 
     * 
     * @param other		the other name to compare with
     * @return similarity boolean
     */
     public boolean isSimilar(Name other) { 
    	 if (other == null){
    		 return false;
    	 } else {
    		 String regexGetOnlyWords = "[\\W]";
    		 String[] thisName = this.fullName.toLowerCase().split(regexGetOnlyWords);
    		 String[] otherName = other.fullName.toLowerCase().split(regexGetOnlyWords);
    		 return isExactlyTheSame(thisName, otherName) ||
    				 isSameDisregardingOmission(thisName, otherName) ||
    				 isPermutation(thisName, otherName);
    	 }
     }

    /**
     * Returns true if two names, given in string arrays split by words, are 
     * permutations of each other
     * 
     * @param thisName the first name given in string array
     * @param otherName the second name given in string array
     * @return similarity boolean
     */
	private boolean isPermutation(String[] thisName, String[] otherName) {
		// TODO Auto-generated method stub
		return false;
	}
	
    /**
     * Returns true if two names, given in string arrays split by words, are 
     * the same except for some omissions
     * 
     * @param thisName the first name given in string array
     * @param otherName the second name given in string array
     * @return similarity boolean
     */
	private boolean isSameDisregardingOmission(String[] thisName, String[] otherName) {
		// TODO Auto-generated method stub
		return false;
	}
	
    /**
     * Returns true if two names, given in string arrays split by words, are
     * exactly the same (contains the same words in the same order)
     * 
     * @param thisName the first name given in string array
     * @param otherName the second name given in string array
     * @return similarity boolean
     */
	private boolean isExactlyTheSame(String[] thisName, String[] otherName) {
		if (thisName.length == otherName.length){
			boolean result = true;
			for (int i = 0; i < thisName.length; i++){
				result &= thisName[i].equals(otherName[i]);
			}
			return result;
		} else {
			return false;
		}
	}
     
}
