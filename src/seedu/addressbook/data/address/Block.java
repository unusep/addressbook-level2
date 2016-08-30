package seedu.addressbook.data.address;

public class Block {
	private final String value;
	
	public Block(String value){
		this.value = value;
	}
	
	@Override
	public String toString(){
		return value;
	}
	
	@Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }
}
