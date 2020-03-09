import java.util.ArrayList;
import java.util.Iterator;

public class Shelf {
	private java.lang.String category;
	
	private int numBooks;
	private java.util.List<Book> books;
	private int capacity;
	
	public Shelf(java.lang.String category,
            int capacity) {
		this.capacity = capacity;
		this.category = category;
		this.numBooks = 0;
		this.books = new ArrayList<Book>(capacity);
	}
	
	public java.lang.String getCategory(){
		return this.category;
	}

	public Book getBooks​(int id) {
		Iterator<Book> iter = books.listIterator();
		
		while(iter.hasNext()) {
			Book b = (Book) iter.next();
			if(b.getId() == id) {
				return b;
			}
		}
		return null;
	}

	public boolean addBook​(java.lang.String name,
	                       java.lang.String author,
	                       int id) {
		
		Book b = new Book(name, author, id);
		return this.addBook​(b);
	}

	public boolean addBook​(Book book) {
		if(this.numBooks >= this.capacity) {
			return false;
		}
		if(books.contains(book)) {
			return false;
		}
		books.add(book);
		this.numBooks++;
		return true;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public int getNumBooks() {
		return this.numBooks;
	}

	public java.lang.Boolean organize(){
		for(int i=0; i<this.numBooks; i++) {
			for(int j = i+1; j<this.numBooks; j++) {
				Book b1 = this.books.get(i);
				Book b2 = this.books.get(j);
				if(b1.getId() > b2.getId()) {
					this.books.set(j, b1);
					this.books.set(i, b2);
				}
			}
		}
		return true;
	}

	public java.lang.Boolean isRedundant​(Shelf shelf){
		if(shelf.getBooks().containsAll(this.getBooks())) {
			return true;
		}
		return false;
	}

	public java.util.List<Book> getBooks(){
		return this.books;
	}
	
	public boolean isBookPresent(String name) {
		Iterator<Book> it = this.books.iterator();
		
		while(it.hasNext()) {
			Book b = (Book) it.next();
			if(b.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
}
