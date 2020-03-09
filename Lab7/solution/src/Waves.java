import java.util.ArrayList;

public class Waves {
	java.util.ArrayList<Day> days;

	public Waves(ArrayList<Day> days) {
		this.days = days;
	}
	
	public boolean addDay​(Day d) {
		
		if(days.size() == 0) {
			days.add(d);
			return true;
		}
		int x = d.dayIndex;
		
		for(int i=0; i<days.size(); i++) {
			if(this.days.get(i).dayIndex < d.dayIndex) {
				x--;
			}
		}
		
		if(x == 0) {
			this.days.add(d);
			return true;
		}
		return false;
	}

	public boolean deleteDay​(Day d) {
		
		for(int i=0; i<this.days.size(); i++) {
			if(this.days.get(i).dayIndex == d.dayIndex && this.days.get(i).head == d.head) {
				this.days.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean addEvent​(int dayIndex, int startTime, int endTime, java.lang.String eventName) {
		for(int i=0;i<this.days.size(); i++) {
			if(this.days.get(i).dayIndex == dayIndex) {
				Day d = new Day(0);
				Day.Node n = d.new Node(startTime, endTime, eventName);
				this.days.get(i).addEvent​(n.event);
				return true;
			}
		}
		return false;
	}
	

	public boolean deleteEvent​(int dayIndex, int eventIndex) {
		for(int i=0; i<this.days.size();i++) {
			if(this.days.get(i).dayIndex == dayIndex) {
				this.days.get(i).deleteEventAtIndex​(eventIndex);
				return true;
			}
		}
		return false;
	}

	public void modifyBST​(int dayIndex, int eventIndex, int bst) {
		for(int i=0; i<this.days.size(); i++) {
			if(this.days.get(i).dayIndex == dayIndex) {
				this.days.get(i).modifyTime​(eventIndex, bst);
				break;
			}
		}
	}

	public void cascadeBST​(int dayIndex, int eventIndex, int startBST, int reduce, int maxEvents) {
		int dayi = 0;
		
		for(int i=0; i<this.days.size(); i++) {
			if(this.days.get(i).dayIndex == dayIndex) {
				dayi = i;
				break;
			}
		}
			
		while(startBST >= 0 && maxEvents >=0) {
			this.days.get(dayi).modifyTime​(eventIndex, startBST);
			startBST -= reduce;
			eventIndex++;
			maxEvents--;
		}
	}

	public int clash​(int dayIndex) {
		int dayi = 0;
		
		for(int i=0; i<this.days.size(); i++) {
			if(this.days.get(i).dayIndex == dayIndex) {
				dayi = i;
				break;
			}
		}
		
		Day.Node temp = this.days.get(dayi).head;
		
		int pairs = 0;
		
		while(temp.next != null) {
			if(temp.event.getEndTime() > temp.next.event.getStartTime()) {
				pairs++;
			}
		}
		return pairs;
		
	}
	
}
