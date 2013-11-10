package heineman.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestModel {

	@Test
	public void testAddOneWord() {
		Model m = new Model();
		int value = m.addWord("Test2");
		assertEquals(0, value);
		
		assertEquals ("Test2", m.getNth(0));
	}
	
	@Test
	public void testAddAndDeleteWord() {
		Model m = new Model();
		int value = m.addWord("Test");
		assertEquals(0, value);
		assertTrue (m.removeWord(value));
	}
	
	@Test
	public void testBadRemoval() {
		Model m = new Model();
		assertFalse (m.removeWord(-1));
		assertFalse (m.removeWord(10));
		
	}

}
