package unitTesting;

public class Book	{

	String title, author;
	Person person;
	boolean isCheckedOut;
	
	public Book(){
		person = new Person();
		title = "Harry Potter";
		author = "Rowling";
		person.setName("Fred");
		person.setMaximumBooks(3);
		isCheckedOut = false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPerson(String name, int maxBooks) {
		person.setMaximumBooks(maxBooks);
		person.setName(name);
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
		person.addBooksHeld();
		this.isCheckedOut = true;
	}
	
	public boolean isCheckedOut() {
		return isCheckedOut;
	}

	public void setCheckedOut(boolean isCheckedOut) {
		this.isCheckedOut = isCheckedOut;
	}

	public String toString(){
		String str;
		if( isCheckedOut == true ){
			str = title + " " + "by " + author + "; unavailable";
		} else {
			str = title + " " + "by " + author + "; available";
		}
		
		return str;
	}

}
