package ksn.com.avl.tree;

public class Node {
	Node left;
	int key;
	Node right;
	int height;
	

	public Node(int key) {
		super();
		this.key = key;
	}
	public Node() {
		
	}
	@Override
	public String toString() {
		return "Node [key=" + key +"]";
	}
	

}
