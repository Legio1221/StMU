package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest{

	@Test
	public void testPerson() {
		Person p = new Person();
		assertEquals("unknown name", p.getName());
		assertEquals(3,p.getMaximumBooks());
	}

	@Test
	public void testSetName() {
		Person p = new Person();
		
	}

	@Test
	public void testSetMaximumBooks() {
		Person p = new Person();
		assertEquals(3, p.getMaximumBooks());
	}
	
	@Test
	public void testToString(){
		Person p = new Person();
		p.setMaximumBooks(4);
		p.setName("Fred");
		
		assertEquals("Fred",p.getName());
		assertEquals(4, p.getMaximumBooks());
	}
}
