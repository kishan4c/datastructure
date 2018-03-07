package ksn.com.linkedlist;

import java.util.HashSet;

public class LinkedList {
	Node start;
	

	public LinkedList(){
		this.start=null;
	}
	public boolean isEmpty(){
		return (start==null);
	}
	
	public Node insertAtFirst(String data){
		
		Node newNode=new Node(data);
		newNode.next = start;
		start=newNode;
		//HashSet<E>
		return newNode;
	}
	
	public void display(){
		Node node=start;
		if(!isEmpty()){
			while(node!=null){
				System.out.println(node.toString());
				node=node.next;
			}
		}
		else{
			System.out.println("List is empty");
		}
	}
	
	public void findMiddleInOnePass(){
		Node node=start;
		Node p=start;
		if(!isEmpty()){
			while(node.next!=null){
				//System.out.println(node.toString());
				p=p.next;
				if(node.next!=null)
				node=node.next.next;
			}
		}
		else{
			System.out.println("List is empty");
		}
		System.out.println("Middle list element --"+p.toString());
	}
}
