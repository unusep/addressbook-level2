package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {

	private Name john;
	private Name johnWithCapitalisation;
	private Name johnWithoutK;
	private Name johnPermutation;
	private Name johnWithCommas;
	private Name mary;
	
	@Before
	public void setUp() throws Exception {
		john = new Name("John K Smith");
		johnWithCapitalisation = new Name("John K SMITh");
		johnWithoutK = new Name("John Smith");
		johnPermutation = new Name("Smith, John K");
		johnWithCommas = new Name("John K, Smith");
		mary = new Name("Mary");
	}

	@Test
	public void isSimilarCapitalisation() {
		boolean result = john.isSimilar(johnWithCapitalisation);
		assertTrue(result);
	}
	
	@Test
	public void isSimilarOmission() {
		boolean result = john.isSimilar(johnWithoutK);
		assertTrue(result);
	}
	
	@Test
	public void isSimilarPermutation() {
		boolean result = john.isSimilar(johnPermutation);
		assertTrue(result);
	}

	@Test
	public void isSimilarPunctuations() {
		boolean result = john.isSimilar(johnWithCommas);
		assertTrue(result);
	}
	
	@Test
	public void isSimilarDifferentName() {
		boolean result = john.isSimilar(mary);
		assertFalse(result);
	}
	
	@Test
	public void isSimilarNull() {
		boolean result = john.isSimilar(null);
		assertFalse(result);
	}
	
	@Test
	public void isSimilarExactlySame() {
		boolean result = john.isSimilar(john);
		assertTrue(result);
	}
	
}
