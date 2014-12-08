package unitTesting;

import java.util.ArrayList;

public class Person {
	private String name;
	private int maximumBooks;
	private int booksHeld;
	ArrayList<Book> bookList;
	
	public Person(){
		name = "unknown name";
		maximumBooks = 3;
		booksHeld = 0;
		bookList = new ArrayList<Book>(maximumBooks);
	}
	
	/*public Person(String name, int maximumBooks){
		this.name = name;
		this.maximumBooks = maximumBooks;
	}*/
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaximumBooks() {
		return maximumBooks;
	}
	public void setMaximumBooks(int maximumBooks) {
		this.maximumBooks = maximumBooks;
	}

	public int getBooksHeld() {
		return booksHeld;
	}

	public void setBooksHeld(int booksHeld) {
		this.booksHeld = booksHeld;
	}
	
	public void addBooksHeld(){
		booksHeld++;
	}
	
	public void subBooksHeld() {
		booksHeld--;
	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	
}
