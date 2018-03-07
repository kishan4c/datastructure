package ksn.com.stack;

public class StackTest {
	public static void main(String[] args) {
		Stack st=new Stack();
		st.push("kishan");
		st.push("pramod");
		st.push("amit");
		st.push("seema");
		System.out.println(st);
		st.display();
		
		st.pop();
		System.out.println();
		st.display();
		
		st.pop();
		System.out.println();
		st.display();
		
		st.pop();
		System.out.println();
		st.display();
		
		st.pop();
		System.out.println();
		st.display();
		
		st.pop();
		System.out.println();
		st.display();
		
		System.out.println(st.isEmpty());
	}

}
