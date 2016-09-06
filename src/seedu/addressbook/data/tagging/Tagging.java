package seedu.addressbook.data.tagging;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {
	Tag tag;
	Person person;
	boolean added;
	
	public Tagging(Tag t, Person p, boolean a){
		tag = t;
		person = p;
		added = a;
	}
	
	public String toString(){
		return (added ? "+" : "-") + " " + 
				person.toString() + " [" + tag.toString() + "]";
	}

}
