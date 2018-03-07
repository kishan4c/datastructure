package ksn.com.queue;

public class Queue {
	
	Node front,rear;

	public Queue() {
		super();
		this.front = null;
		this.rear = null;
	}
	public boolean isEmplty(){
		return rear==null;
	}

	
	public void enqueue(String data){
		
		Node newNode=new Node(data);
		if(isEmplty()){
			front=rear=newNode;
		}
		else{
			rear.next=newNode;
			rear=newNode;
		}
		newNode.next=null;
	}
	
	public void dequeue(){
		if(!isEmplty()){
			if(front.next==rear.next){
				front=rear=null;
			}
			else{ 
				front=front.next;
			}
		}
		else{
			System.out.println("Queue is empty");
		}
	}
	
	public void display(){
		Node p=front;
		if(!isEmplty()){
			while(p!=null){
				System.out.print(p+"--->");
				p=p.next;
			}
		}
		else{
			System.out.println("display Queue is empty");
		}
	}
}
