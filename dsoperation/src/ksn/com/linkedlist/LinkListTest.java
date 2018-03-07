package ksn.com.linkedlist;

public class LinkListTest {

	public static void main(String[] args) {

		LinkedList list=new LinkedList();
		System.out.println(list.isEmpty());
		list.display();
		list.insertAtFirst("kishan");
		list.insertAtFirst("seema");
		list.insertAtFirst("pramod");
		list.insertAtFirst("kavita");
		list.insertAtFirst("papa");
		list.insertAtFirst("mommy");
		list.insertAtFirst("mommy33333");
		list.insertAtFirst("eeeee");
		System.out.println(list.isEmpty());
		list.display();
		list.findMiddleInOnePass();
	}

}
