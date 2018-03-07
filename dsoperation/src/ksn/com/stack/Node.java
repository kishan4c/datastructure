package ksn.com.stack;

public class Node {
	String data;
	Node next;
	public Node(String data) {
		super();
		this.data = data;
		//this.next = null;
	}
	
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	
}
