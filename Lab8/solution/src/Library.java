import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Library {
	private java.lang.String name;

	private int maxShelves;
	private java.util.List<Shelf> shelvesList;

	public Library(java.lang.String name, int capacity) {
		this.name = name;
		this.maxShelves = capacity;
		this.shelvesList = new ArrayList<Shelf>();
	}

	public boolean addShelf​(java.lang.String category, int capacity) {
		if (this.getNumShelves() >= this.maxShelves) {
			return false;
		}
		Shelf s = new Shelf(category, capacity);
		this.shelvesList.add(s);
		return true;
	}

	public int getNumBooks() {
		Iterator<Shelf> iter = this.shelvesList.iterator();
		int numBooks = 0;
		while (iter.hasNext()) {
			Shelf s = (Shelf) iter.next();
			numBooks += s.getNumBooks();
		}
		return numBooks;
	}

	public java.lang.String getName() {
		return this.name;
	}

	public int getMaxShelves() {
		return this.maxShelves;
	}

	public java.util.List<Shelf> getShelvesList() {
		return this.shelvesList;
	}

	public java.util.Set<Shelf> searchBook​(java.lang.String name) {
		Set<Shelf> mySet = new HashSet<Shelf>();
		Iterator<Shelf> it = this.shelvesList.iterator();

		while (it.hasNext()) {
			Shelf s = (Shelf) it.next();
			if (s.isBookPresent(name)) {
				mySet.add(s);
			}
		}
		return mySet;
	}

	public Shelf getShelf​(java.lang.Integer i) {
		return this.shelvesList.get(i);
	}

	public java.lang.Integer getNumShelves() {
		return this.shelvesList.size();
	}

}
