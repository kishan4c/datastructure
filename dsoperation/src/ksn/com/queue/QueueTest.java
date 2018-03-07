package ksn.com.queue;

public class QueueTest {

	public static void main(String[] args) {

		Queue q=new Queue();
		//q.dequeue();
		q.display();
		q.enqueue("aaaaa");
		q.enqueue("bbbbb");
		q.enqueue("ccccc");
		q.enqueue("dddddd");
		q.display();
		System.out.println();
		System.out.println("front---"+q.front);
		System.out.println("rear---"+q.rear);
		System.out.println();
		q.dequeue();
		q.display();
		System.out.println();
		q.dequeue();
		q.display();
		System.out.println();
		q.dequeue();
		q.display();
		System.out.println();
		q.dequeue();
		q.display();
		System.out.println();
		q.dequeue();
		q.display();
		System.out.println();
		q.dequeue();
		q.enqueue("happy programming");
		q.display();
	}

}
