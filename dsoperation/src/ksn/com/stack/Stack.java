package ksn.com.stack;

public class Stack {
	Node top=null;
	
	public boolean isEmpty(){
		return top==null;
	}

	public void push(String data){
		Node newNode=new Node(data);
		if(isEmpty()){
			top=newNode;
		}
		else{
			newNode.next=top;
			top=newNode;
		}
	}
	
	public void pop(){
		if(!isEmpty()){
			top=top.next;
		}
		else{
			System.out.println("Sorry cant pop stack is empty");
		}
	}
	
	public void display(){
		Node p=top;
		if(!isEmpty()){
		while(p!=null){
			System.out.print(p+"--->");
			p=p.next;
		}
		}
		else{
			System.out.println("cant displya stack is emplty");
		}
	}
}
