package unitTesting;

import java.util.ArrayList;

public class MyLibrary {
	ArrayList<Book> bookList;
	ArrayList<Person> personList;
	String name;
	boolean isCheckedOut;
	
	public MyLibrary(){
		name = "Library";
		bookList = new ArrayList<Book>();
		personList = new ArrayList<Person>();
		Book b = new Book();
		bookList.add(b);
		personList.add(b.getPerson());
	}
	
	public MyLibrary(ArrayList<Book> bList, ArrayList<Person> pList){
		name = "Library";
		this.bookList = bList;
		this.personList = pList;
	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	public ArrayList<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(ArrayList<Person> personList) {
		this.personList = personList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addPersonList(Person p) {
		personList.add(p);
	}
	
	public void addBookList(Book b) {
		bookList.add(b);
	}
	
	public void removePersonList(int i) {
		personList.remove(i);
	}
	
	public void removeBookList(int i) {
		bookList.remove(i);
	}
	
	/**Requires Exception in refactoring. This method assumes that Book b is already in the Library ArrayList*/
	public boolean checkOut(Book b, Person p) {
		boolean result;
		if(p.getBooksHeld() < p.getMaximumBooks()){
			b.setPerson(p);
			p.getBookList().add(b);
			b.setCheckedOut(true);
		}
		result = b.isCheckedOut();
		return result;
	}
	
	public boolean checkIn(Book b) {
		boolean result;
		b.getPerson().subBooksHeld();
		b.getPerson().getBookList().remove(b);
		b.setCheckedOut(false);
		
		result = b.isCheckedOut();
		return result;
	}
	
	public int getCountofBooks(Person p1){
		int result = 0;
		result = p1.getBooksHeld();
		return result;
	}

	public ArrayList<Book> getAvailableBooks() {
		ArrayList<Book> newList = new ArrayList<Book>(1);
		for(int i = 0; i < bookList.size(); i++){
			if( bookList.get(i).isCheckedOut() == false ) {
				newList.add(bookList.get(i));
			}
		}
		return newList;
	}
	
}
