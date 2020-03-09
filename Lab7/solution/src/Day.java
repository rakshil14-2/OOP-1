
public class Day {
	
	public class Node {
		
		public class Event {
			private int startTime;

			private int endTime;

			java.lang.String name;
			
			Event(int startTime,
				      int endTime,
				      java.lang.String eventName){
				this.startTime = startTime;
				this.endTime = endTime;
				this.name = eventName;
			}
			public int getStartTime() {
				return this.startTime;
			}
			public int getEndTime() {
				return this.endTime;
			}

			public void changeStartTime​(int newStartTime) {
				this.startTime = newStartTime;
			}

			public void changeEndTime​(int newEndTime) {
				this.endTime = newEndTime;
			}

			public void addBST​(int bstValue) {
				this.startTime += bstValue;
				this.endTime += bstValue;
			}
			
		}

		Day.Node.Event event;

		Day.Node prev;

		Day.Node next;
		
		Node(int eventStartTime,
			     int eventEndTime,
			     java.lang.String eventName){
			this.prev = null;
			this.next = null;
			this.event = new Event(eventStartTime, eventEndTime, eventName);
		}
		
		Node(Day.Node.Event ev){
			this.prev = null;
			this.next = null;
			this.event = ev;
		}
	}

	Day.Node head;

	int dayIndex;
	
	public Day(int dayNumber) {
		this.head = new Node(null);
		this.dayIndex = dayNumber;
	}
	
	
	public boolean addEvent​(Day.Node.Event ev) {
//		Node n = new Node(ev);
//		
//		if(this.head.event.startTime > ev.startTime) {
//			n.next = this.head;
//			n.prev = null; //check
//			this.head.prev = n;
//			head = n;
//			return true;
//		}
//		
//		Node temp = this.head;
//		
//		while(temp.event.startTime < ev.startTime) {
//			temp = temp.next;
//		}
//		
//		n.next = temp.next;
//		n.prev = temp;
		return false;		
	}

	public boolean deleteEventAtIndex​(int index) {
		
		if(index == 0) {
			this.head = head.next;
			return true;
		}
		
		int count = 0;
		Node temp = this.head;
		
		while(count != index) {
			temp = temp.next;
			count++;
		}
		
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		
		return true;
	}
	
	

	public void modifyTime​(int index, int change) {
		
		Node temp = this.head;
		
		if(index == 0) {
			this.head.event.startTime += change;
			this.head.event.endTime += change;
			return;
		}
		
		int count = 0;
		
		while(count != index) {
			temp = temp.next;
			count++;
		}
		
		temp.next.event.startTime += change;
		temp.next.event.endTime += change;
		
	}
	
	
}
