package unitTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MyLibraryTest {

	ArrayList<Book> bList;
	ArrayList<Person> pList;
	MyLibrary lib;
	
	public void setUp(){
		
		bList = new ArrayList<Book>();
		pList = new ArrayList<Person>();
		
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		Book b4 = new Book();
		Book b5 = new Book();
		Person p1 = new Person();
		Person p2 = new Person();
		
		p1.setMaximumBooks(6);
		p1.setName("Johnathan");
		
		b1.setAuthor("Tippler");
		b1.setTitle("Modern Physics");
		b1.setPerson(p1);
		
		
		p2.setMaximumBooks(4);
		p2.setName("Oscar");
		
		b2.setAuthor("Michael");
		b2.setTitle("King Arthur");
		b2.setPerson(p2);
		
		b3.setAuthor("Castro");
		b3.setTitle("Test1");
		b3.setPerson(p1);
		
		b4.setAuthor("Diego");
		b4.setTitle("Tower");
		
		b5.setAuthor("Juan");
		b5.setTitle("Lord");
		
		bList.add(b1);
		bList.add(b2);
		bList.add(b3);
		bList.add(b4);
		bList.add(b5);
		
		pList.add(p1);
		pList.add(p2);
		
		lib = new MyLibrary(bList,pList);
		
	}
	
	@Test
	public void testMyLibrary() {
		MyLibrary lib = new MyLibrary();
		assertEquals("Library",lib.name);
		assertEquals(1,lib.bookList.size());
		assertEquals(1,lib.personList.size());
		
	}

	@Test
	public void testGetPersonList() {
		setUp();
		assertEquals("Johnathan",pList.get(0).getName());
		assertEquals(6,pList.get(0).getMaximumBooks());
		
		assertEquals("Oscar",pList.get(1).getName());
		assertEquals(4,pList.get(1).getMaximumBooks());
		
	}
	
	@Test
	public void testGetBookList(){
		setUp();
		assertEquals("Tippler",bList.get(0).getAuthor());
		assertEquals("Modern Physics",bList.get(0).getTitle());
		assertEquals("Johnathan",bList.get(0).getPerson().getName());
		assertEquals(6,bList.get(0).getPerson().getMaximumBooks());
		
		assertEquals("Michael",bList.get(1).getAuthor());
		assertEquals("King Arthur",bList.get(1).getTitle());
		assertEquals("Oscar",bList.get(1).getPerson().getName());
		assertEquals(4,bList.get(1).getPerson().getMaximumBooks());
	}
	
	@Test
	public void addBookList() {
		setUp();
		Book b6 = new Book();
		bList.add(b6);
		assertEquals(6,bList.size());
	}
	
	@Test
	public void addPersonList() {
		setUp();
		Person p3 = new Person();
		pList.add(p3);
		assertEquals(3,pList.size());
		assertSame(p3,pList.get(2));
	}
	
	@Test
	public void removeBookList() {
		setUp();
		Book b6 = new Book();
		bList.add(b6);
		bList.remove(1);
		assertEquals(5,bList.size());
		assertSame(b6,bList.get(4));
	}
	
	@Test
	public void removePersonList(){
		setUp();
		Person p3 = new Person();
		pList.add(p3);
		pList.remove(1);
		assertEquals(2,pList.size());
		assertSame(p3,pList.get(1));
	}
	
	@Test
	public void testCheckIn(){
		setUp();
		lib.checkOut(bList.get(0), pList.get(0));
		lib.checkOut(bList.get(1), pList.get(1));
		lib.checkIn(bList.get(0));
		assertFalse(bList.get(0).isCheckedOut());
	}
	
	@Test
	public void testCheckOut() {
		setUp();
		assertTrue(lib.checkOut(bList.get(0),pList.get(0)));//checks if book has been checked out.
		assertEquals(3,pList.get(0).getBooksHeld()); //Books held field should only have 1 book stored.
	}
	
	@Test
	public void testGetCountOfBooks(){
		setUp();
		assertEquals(2,lib.getCountofBooks(pList.get(0)));
		assertEquals(1,lib.getCountofBooks(pList.get(1)));
	}
	
	@Test
	public void testGetAvailableBooks() {
		setUp();
		
		assertEquals(2,lib.getAvailableBooks().size()); //checks to make sure only 2 are available
		assertEquals("Tower by Diego; available",lib.getAvailableBooks().get(0).toString()); //checks available book's toString for comparison
		assertEquals("Lord by Juan; available",lib.getAvailableBooks().get(1).toString()); //same as above
	}
}
