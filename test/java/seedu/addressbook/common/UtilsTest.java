package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class UtilsTest {
	
	Collection<String> twoSameList;
	Collection<String> allUniqueList;

    @Before
    public void setup() {
    	twoSameList = new ArrayList<String>();
    	twoSameList.add("123");
    	twoSameList.add("123");
    	twoSameList.add("1");
    	allUniqueList = new ArrayList<String>();
    	allUniqueList.add("1");
    	allUniqueList.add("2");
    }

	@Test
	public void isAnyNull_noNull() {
		boolean result = Utils.isAnyNull(new Object(), new Object());
		assertFalse(result);
	}

	@Test
	public void isAnyNull_oneNull() {
		boolean result = Utils.isAnyNull(new Object(), null);
		assertTrue(result);
	}
	
	@Test
	public void isAnyNull_empty() {
		boolean result = Utils.isAnyNull();
		assertFalse(result);
	}
	
	@Test
	public void elementAreUnique_twoSame() {
		boolean result = Utils.elementsAreUnique(twoSameList);
		assertFalse(result);
	}

	@Test
	public void elementAreUnique_allUnique() {
		boolean result = Utils.elementsAreUnique(allUniqueList);
		assertTrue(result);
	}

	@Test
	public void elementAreUnique_emptyCollection() {
		boolean result = Utils.elementsAreUnique(new ArrayList<String>());
		assertTrue(result);
	}
}
