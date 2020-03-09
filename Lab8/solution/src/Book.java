
public class Book implements java.lang.Comparable<Book> {
	private int id;

	private java.lang.String name;

	private java.lang.String author;
	
	public static java.util.HashMap<Book, Shelf> bookToShelf;

	public Book(java.lang.String name, java.lang.String author, int id) {
		this.name = name;
		this.id = id;
		this.author = author;
	}

	@Override
	public int compareTo(Book o) {
		if(this.id < o.id) {
			return -1;
		}
		else if(this.id == o.id && this.author.equals(o.author) && this.name.equals(o.name)) {
			return 0;
		}
		else 
			return 1;
	}
	
	

	public int getId() {
		return this.id;
	}

	public java.lang.String getName(){
		return this.name;
	}

	public java.lang.String getAuthor(){
		return this.author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public boolean equals(Book o) {
		if(this.id == o.id && this.author.equals(o.author) && this.name.equals(o.name)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Shelf getShelf() {
		return bookToShelf.get(this);
	}
}
