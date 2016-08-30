package seedu.addressbook.data.address;

public class PostalCode {
	private final String value;
	
	public PostalCode(String value){
		this.value = value;
	}
	
	@Override
	public String toString(){
		return value;
	}
	
	@Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.value.equals(((PostalCode) other).value)); // state check
    }
}
