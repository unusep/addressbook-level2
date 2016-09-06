package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {

	private Name john;
	private Name johnWithCapitalisation;
	private Name johnWithoutK;
	private Name johnPermutation;
	private Name mary;
	
	@Before
	public void setUp() throws Exception {
		john = new Name("John K Smith");
		johnWithCapitalisation = new Name("John K SMITh");
		johnWithoutK = new Name("John Smith");
		johnPermutation = new Name("Smith, John K");
		mary = new Name("Mary");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
