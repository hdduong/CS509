package heineman.model;

import java.util.*;

public class Model {
	ArrayList<String> words = new ArrayList<String>();
	
	public int addWord(String s) {
		int idx = words.size();
		words.add(s);
		return idx;
	} 
	
	public int removeWord(String s) {
		int idx = words.indexOf(s);
		if (idx != -1) { 
			words.remove(s);
		}
		
		return idx;
	}
	
	public Iterator<String> iterator() { 
		return words.iterator();
	}

	public String getNth(int i) {
		return words.get(i);
	}
	
	public int size() { return words.size(); }
	
	public boolean removeWord(int idx) {
		if (idx < 0 || idx > words.size()-1) { return false; }
		
		words.remove(idx);
		return true;
	}
}
