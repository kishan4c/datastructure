package ksn.com.linkedlist;

public class Node {
public String data;
public Node next;
public Node(String data){
	this.data=data;
}

@Override
public String toString() {
	return "Node [data=" + data + "]";
}

}
