package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void testBook() {
		Book b = new Book();
		b.getPerson().setName("Fred");
		assertEquals("Harry Potter",b.title);
		assertEquals("Rowling",b.author);
		assertEquals("Fred",b.getPerson().getName());
	}
	
	@Test
	public void testSetTitle() {
		Book b = new Book();
		b.setTitle("Microsoft");
		assertEquals("Microsoft", b.getTitle());
	}
	
	@Test
	public void testSetAuthor() {
		Book b = new Book();
		b.setAuthor("Bill Gates");
		assertEquals("Bill Gates", b.getAuthor());
	}
	
	@Test
	public void testGetPerson() {
		Book b = new Book();
		b.setPerson("Billy", 5);
		assertEquals("Billy", b.getPerson().getName());
		assertEquals(5, b.getPerson().getMaximumBooks());
	}
	
	@Test
	public void testToString(){
		Book b = new Book();
		b.setAuthor("Chris");
		b.setTitle("Eragon");
		b.getPerson().setName("Oscar");
		b.setCheckedOut(true);
		assertEquals("Eragon by Chris; unavailable", b.toString());
	}

}
