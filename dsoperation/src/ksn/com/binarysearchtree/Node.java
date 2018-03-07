package ksn.com.binarysearchtree;

public class Node {
	int key;
	String name;
	boolean visited=false;
	
	public Node(int key, String name) {
		super();
		this.key = key;
		this.name = name;
	}
	public Node() {
		
	}

	Node left,right;

	@Override
	public String toString() {
		return "Node [key=" + key + ", name=" + name + "]";
	}
	

}
