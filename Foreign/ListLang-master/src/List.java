package listlang.objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.LinkedList;

public class List {

	static final Pattern listPattern = Pattern.compile(" *\\[ *\\d+(, *\\d+ *)* *\\] *");
	static final Pattern numberPattern = Pattern.compile("\\d+");

	public static List read() {
		List readedList = new List();
		
		// read line from stdin
		BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in)); 
		String line = "";
		try {
			line = bufferedreader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// parse readed line
		Matcher listMatcher = listPattern.matcher(line);
		if(listMatcher.matches()) {
			Matcher numberMatcher = numberPattern.matcher(line);

			while (numberMatcher.find()) {
				readedList.addLast(Integer.parseInt(numberMatcher.group()));
			}
		}
		
		return readedList;
	}
	
	private LinkedList<Integer> mList = new LinkedList<Integer>();
	
	public List() {
	}
	
	public void print() {		
		String str = "";
		if(!mList.isEmpty()) {
			str = mList.get(0).toString();
			for(int i = 1; i < mList.size(); i++) {
				str += ", " + mList.get(i).toString();
			}
		}
		System.out.print("[" + str + "]");
	}
	
	public int count(int n) {
		int n_count = 0;
		for(int val : mList) {
			if(val == n) {
				n_count++;
			}
		}
		return n_count;
	}
	
	@SuppressWarnings("unchecked")
	public List(LinkedList<Integer> linkedList) {
		mList = (LinkedList<Integer>) linkedList.clone();
	}
	
	public List clone() {
		return new List(this.getLinkedList());
	}
	
	public LinkedList<Integer> getLinkedList() {
		return mList;
	}
	
	public void addFirst(int n) {
		mList.addFirst(new Integer(n));
	}
	
	public void addLast(int n) {
		mList.addLast(new Integer(n));
	}
	
	public void removeFirst() {
		mList.remove(0);
	}
	
	public void removeLast() {
		mList.remove(mList.size() - 1);
	}
	
	public void delete(int i) {
		mList.remove(i);
	}
	
	public boolean boolean_value() {
		return !mList.isEmpty();
	}
	
	public int to_int() {
		return boolean_value() ? 1 : 0;
	}
	
	// expressions
	
	public int get(int i) {
		return mList.get(i).intValue();
	}
	
	public List slice(int begin, int end) {
		LinkedList<Integer> slicingLinkedList = this.getLinkedList();
		for(int i = slicingLinkedList.size() - end; i > 0; i--) {
			slicingLinkedList.remove(end);
		}
		for(int i = 0; i < begin; i++) {
			slicingLinkedList.remove(0);
		}
		return new List(slicingLinkedList);
	}
	
	public int len() {
		return mList.size();
	}

	public int equal(List second) {
		if(second.getLinkedList().equals(mList)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public List concat(List second) {
		List resList = this.clone();
		for(int i = 0; i < second.len(); i++) {
			resList.addLast(second.get(i));
		}
		return resList;
	}
	
	public List multiply(int times) {
		List result = this;
		for(int i = 1; i < times; i++) {
			result = result.concat(this);
		}
		return result;
	}
	
	public List removeEvery(int n) {
		List result = clone();
		int i = 0;
		while(i < result.len()) {
			if(result.get(i) == n) {
				result.delete(i);
			} else {
				i++;
			}
		}
		return result;
	}

	public List pre_incr() {
		addFirst(0);
		return this;
	}

	public List pre_decr() {
		delete(0);
		return this;
	}

	public List post_incr() {
		addLast(0);
		return this;
	}

	public List post_decr() {
		delete(len() - 1);
		return this;
	}
}
