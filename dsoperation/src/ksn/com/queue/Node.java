package ksn.com.queue;

public class Node {
	String data;
	Node next;
	public Node(String data) {
		super();
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

}
