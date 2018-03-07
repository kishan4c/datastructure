package ksn.com.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BST {
	Node root;
	
	// start of BST operations
	
	public void addNode(int key,String name){
		Node p=new Node(key,name);
		if(root==null){
			root=p;
		}
		else{
			Node runner=root;
			Node parent;
			while(true){
				parent=runner;
				if(key<runner.key){
					runner=runner.left;
					if(runner==null){
						parent.left=p;
						return;
					}
				}
				else{
					runner=runner.right;
					if(runner==null){
						parent.right=p;
						return;
					}
				}
			}
		}
		
	}
	
	public Node addNode2(Node root,int key,String name){
		Node q = null,r,p;
			r=new Node(key,name);
			r.right=null;
			r.left=null;
			if(root==null){//if root is null then just assign new node to root
				root=r;
				this.root=root;
				return root;
			}
			
			//finding the leaf node for insertion
			p=root;
			while(p!=null){
				q=p;
				if(key>p.key){
					p=p.right;
				}
				else{
					p=p.left;
				}
				
			}
			// q will have have node address where new node to be inserted
			if(key>q.key){
				q.right=r;  //x as right of q
			}
			else{
				q.left=r;   //x as left of q
			}
			this.root=root;
			return root;
			
		}
	
	public Node addNode3(Node root,int key,String name){
		Node ptr=root,prev=null;
		boolean left=false;
		while(ptr!=null){
			if(key==ptr.key){
				System.out.println("Already exists ..duplicate data");
			}
			prev=ptr;
			if(key<ptr.key){
				ptr=ptr.left;left=true;
			}
			else{
				ptr=ptr.right;left=false;
			}
		}
	 Node n=new Node(key,name);
	 if(root==null){
		 //root=n;
		 return n;
	 }
	 if(left){
		 prev.left=n;
	 }
	 else{
		 prev.right=n;
	 }
	 
	 return n;
		
	}
	
	//Iterative
	//searching time in BST is O(h), where h->height of BST
	public Node search(Node root,int key){
		
		Node ptr=root;
		while(ptr!=null){
			if(key==ptr.key){
				return ptr;
			}
			if(key<ptr.key){
				ptr=ptr.left;
			}
			else{
				ptr=ptr.right;
			}
		}
		return null;
	}
	
	//Recursive search
		public Node searchRecursive(Node root,int key){
			if(root==null){
				return null;
			}
			if(key==root.key){
				return root;
			}
			if(key<root.key){
				return searchRecursive(root.left,key);
			}
			else{
				return searchRecursive(root.right,key);
			}
			
		}
	
		public Node deleteIterative(Node root,int key){
			
			Node x=root,p=null;
			while(x!=null){
				if(key==x.key){
					break;//in case of match will break the loop
				}
				p=x;
				x=key<x.key ? x.left : x.right;
			}
			if(x==null){
				System.out.println("Element not found");
			}
			
			//x has 2 children
			if(x.left!=null && x.right!=null){
				Node y=x.left;
				while(y.right!=null){
					p=y;
					y=y.right;
				}
				x.key=y.key;
				x=y;
			}
			
			//handle x is 1 child case
			if(p==null){
				return x.left!=null ? x.left : x.right;
			}
			Node tmp=x.left!=null ? x.left : x.right;
			if(x==p.right){
				p.right=tmp;
			}
			else{
				p.left=tmp;
			}
			return root;
			
		}
	
	
	
	public Node delete(Node root,int key){
		//Node start=root;
		Node temp;
		
		if(root==null){//element not found
			return root;
			
		}
		if(key<root.key){ //delete in left subtree
			root.left=delete(root.left,key);
			return root;
		}
		if(key>root.key){ //delete in right subtree
			root.right=delete(root.right,key);
			return root;
		}
		
		//element is found
		//base condition
		if(root.left==null && root.right==null){ // if a leaf node then simply delete it
			temp=root;               
			return null;
			
		}
		if(root.left==null){ //if right node is null
			temp=root;
			root=root.right;
			return root;
			
		}
		if(root.right==null){ // if left node is null
			temp=root;
			root=root.left;
			
			return root;
			
		}
		//node with two children , then find min in right subtree
		temp=find_min(root.right);
		root.key=temp.key;   //assigned min value to found node
		root.right=delete(root.right,temp.key);
		
		return root;
		
	}
	
	public Node find_min(Node root){
		Node p=root;
		while(p.left!=null){
			p=p.left;
		}
		System.out.println("MIN---"+p.key);
		return p;
	}
	
	public Node find_max(Node root){
		Node p=root;
			while(p.right!=null){
				p=p.right;
			}
			System.out.println("MAX---"+p.key);
			return p;
		}
	
	// end of BST operations
	
	
	
	
	// general tree operations
	
	/* Binary tree traversals:

	PreOrder traversal - 
	In PreOrder traversal,each node is processed before either of its sub-trees.In simpler words,Visit each node before its children.
	
	InOrder traversal : 
	In InOrder traversal,each node is processed between subtrees.In simpler words,Visit left subtree, node and then right subtree.
	
	PostOrder traversal: 
	In PostOrder traversal,each node is processed after subtrees traversal.In simpler words,Visit left subtree,  right subtree and then node.
	
	Level order traversal : 
	In Level order traversal, tree is traversed by each level. It is same as breadth first search.
	
	Spiral/Zigzag order traversal :
	 In spiral order traversal, tree is traversed in spiral shape.
	 */
	
	
	
	public void inOrderTraversR(Node cur){
		if(cur!=null){
			inOrderTraversR(cur.left);
		System.out.println(cur);
		inOrderTraversR(cur.right);
		}
		
	}
	
	
	public void preOrderTraversR(Node cur){
		if(cur!=null){
			System.out.print(cur.key+" ,");
			preOrderTraversR(cur.left);
			preOrderTraversR(cur.right);
		}
		
	}
	
	
	public void postOrderTraversR(Node cur){
		if(cur!=null){
			postOrderTraversR(cur.left);
			postOrderTraversR(cur.right);
			System.out.println(cur);
		}
		
	}
	
	
	// non recursive in order traversal 
	public void inOrderTraversNonRec(Node root){
		Stack<Node> st=new Stack<Node>();
		while(root!=null){
			st.push(root);
			root=root.left;
		}
		while(st.size()!=0){
			root=st.pop();
			System.out.print(root.key+"  ");
			root=root.right;
			while(root!=null){
				st.push(root);
				root=root.left;
			}
		}
		
	}
	
	public void inOrderIter(Node root) {
		  if(root == null)
		   return;
		  
		  Stack<Node> s = new Stack<Node>();
		  Node currentNode=root;

		  while(!s.empty() || currentNode!=null){

		   if(currentNode!=null)
		   {
		    s.push(currentNode);
		    currentNode=currentNode.left;
		   }
		   else
		   {
			   Node n=s.pop();
		    System.out.print(n.key+", ");
		    currentNode=n.right;
		   }
		  }
		  
		 }

	public void preOrderIter(Node root) {
		  if(root == null)
		   return;
		  
		  Stack<Node> s = new Stack<Node>();
		  Node currentNode=root;

		  while(!s.empty() || currentNode!=null){

		   if(currentNode!=null)
		   {
			System.out.print(currentNode.key+", ");
		    s.push(currentNode);
		    currentNode=currentNode.left;
		   }
		   else
		   {
			Node n=s.pop();
		    currentNode=n.right;
		   }
		  }
		  
		 }

	
	//non recursive pre order traversal 
	public void preOrderTraversNonRec(Node root){
		Stack<Node> st=new Stack<Node>();
		while(root!=null){
			System.out.println(root);
			st.push(root);
			root=root.left;
		}
		while(st.size()!=0){
			root=st.pop();
			root=root.right;
			while(root!=null){
				System.out.println(root);
				st.push(root);
				root=root.left;
			}
		}
		
	}
	
	    /*  1- Push the root node to the first stack.
			2-Pop a node from the first stack, and push it to the second stack.
			3-Then push its left child followed by its right child to the first stack.
			4-Repeat step 2) and 3) until the first stack is empty.
			5-Once done, the second stack would have all the nodes ready to be traversed in post-order.
			 Pop off the nodes from the second stack one by one and you’re done.
		*/
	//non recursive post order traversal using two stacks 
	void postOrderTraversalIterativeTwoStacks(Node root) {
		System.out.println("postOrderTraversalIterativeTwoStacks starts");
		
		  if (root==null) return;
		  Stack<Node> s=new Stack<Node>();
		  Stack<Node> output=new Stack<Node>();
		  s.push(root);
		  while (!s.isEmpty()) {
		    Node curr = s.pop();
		    output.push(curr);
		    if (curr.left!=null)
		      s.push(curr.left);
		    if (curr.right!=null)
		      s.push(curr.right);
		  }
		  while (!output.isEmpty()) {
		    System.out.print(output.pop().key+"  ");
		  }
		  System.out.println("\npostOrderTraversalIterativeTwoStacks ends");
		}
	
	// need to test not working properly
	void postOrderTraversalIterative(Node root) {
		System.out.println("postOrderTraversalIterative starts");
		  if (root==null) return;
		  Stack<Node> s=new Stack<Node>();
		  s.push(root);
		  Node prev = null;
		  while (!s.isEmpty()) {
			  Node curr = s.pop();
		    // we are traversing down the tree ---this condition has some problem , need to be fixed
		    if (prev!=null && ( prev.left == curr || prev.right == curr)) {
		      if (curr.left!=null) {
		        s.push(curr.left);
		      } else if (curr.right!=null) {
		        s.push(curr.right);
		      } else {
		       System.out.println( curr.key + " ");
		        s.pop();
		      }
		    } 
		    // we are traversing up the tree from the left
		    else if (curr.left == prev) {
		      if (curr.right!=null) {
		        s.push(curr.right);
		      } else {
		    	  System.out.println( curr.key +" ");
		        s.pop();
		      }
		    }
		    // we are traversing up the tree from the right
		    else if (curr.right == prev) {
		    	System.out.println(curr.key+ " ");
		      s.pop();
		    }
		    prev = curr;  // record previously traversed node
		  }
		  
		  System.out.println("\npostOrderTraversalIterative ends");
		}
	
	
	
	
	public Node cloneTree(Node root){
		Node n;
		n=null;
		if(root!=null){
			n=new Node();
			n.key=root.key;
			n.name=root.name;
			n.left=cloneTree(root.left);
			n.right=cloneTree(root.right);
		}
		return n;
	}
	
	public int isEquivalence(Node n1,Node n2){
		if(n1==null && n2==null){
			return 1;
		}
		if(n1!=null && n2!=null){
			if(n1.key==n2.key && isEquivalence(n1.left,n2.left)==1 && isEquivalence(n1.right,n2.right)==1){
				return 1;
			}
		}
		return 0;
	}
	
	//time complexity is O(n)
	public int height(Node root){
		Node p=root;
		if(p==null){
			return 0;
		}
		return Math.max(height(p.left), height(p.right))+1;
		
	}
	
	//count all nodes
	public int count(Node root){
		Node p=root;
		if(p==null){
			return 0;
		}
		return count(p.left)+ count(p.right)+1;
		
	}
	
	//count leaf nodes in a tree
	public int countLeafNodes(Node root){
		int i;
		Node p=root;
		if(p==null){
			return 0;
		}
		if(p.left==null && p.right==null){
			return 1;
			
		}
		i= countLeafNodes(p.left)+ countLeafNodes(p.right);
		
		return i;
	}
	
	//count  Degree One Nodes
	public int countDegreeOneNodes(Node root){
		int i;
		Node p=root;
		if(p==null){
			return 0;
		}
		if(p.left==null && p.right==null){
			return 0;
			
		}
		if(p.left==null || p.right==null){
			i=1+ countDegreeOneNodes(p.left)+ countDegreeOneNodes(p.right);
			return i;
			
		}
		i= countDegreeOneNodes(p.left)+ countDegreeOneNodes(p.right);
		
		return i;
	}
	
	//count  Degree two Nodes
	public int countDegreeTwoNodes(Node root){
		int i;
		Node p=root;
		if(p==null){
			return 0;
		}
		if(p.left==null && p.right==null){
			return 0;
			
		}
		if(p.left==null || p.right==null){
			i= countDegreeTwoNodes(p.left)+ countDegreeTwoNodes(p.right);
			return i;
			
		}
		i= 1+countDegreeTwoNodes(p.left)+ countDegreeTwoNodes(p.right);
		
		return i;
	}
	
	/*  
	 * Steps for Level order traversal algorithm:
		1-Create empty queue and pust root node to it.
		2-Do the following when queue is not empty
			Pop a node from queue and print it
			Push left child of popped node to queue if not null
			Push right child of popped node to queue if not null
	 */
	
	//level wise traversing BFS(printing each level in next line)
	 public  void printLevelOrderBFS(Node root){
	        Queue<Node> queue = new LinkedList<Node>();
	        queue.add(root);
	        int currentLevelCount = 1;
	        int nextLevelCount = 0;
	        
	        while(!queue.isEmpty()){
	        	Node n = queue.remove();
	        	//printSpace(height(n));
	            System.out.print(n.key + " ");
	            if(n.left != null){
	                queue.add(n.left);
	                nextLevelCount++;
	            }
	            if(n.right != null){
	                queue.add(n.right);
	                nextLevelCount++;
	            }
	            currentLevelCount--;
	            if(currentLevelCount == 0){
	                System.out.println("");
	                currentLevelCount = nextLevelCount;
	                nextLevelCount = 0;
	            }
	        }
	    }
	
	
	 public  void levelWithMarkerTraversal(Node root) { 
		 System.out.println("levelWithMarkerTraversal starts");
	        Queue<Node> queue=new LinkedList<Node>();  
	        Stack<Node> st=new Stack<Node>();
	        queue.add(root);  
	        queue.add(null);
	        int level = 0;
	        int levelSize=1;
	        while(!queue.isEmpty())  
	        {  
	        	Node tempNode=queue.remove();  
	        	if(tempNode==null){
	        		
	        		System.out.println();
	        		if (queue.isEmpty() == true) break;
	        		System.out.print("level "+level+"["+levelSize+"]--");
	        		level++;
	        		queue.add(null);
	        		levelSize=0;
	        		
	        		while(!st.isEmpty()){
	        			Node temp=st.pop();
	        			System.out.print(" "+temp.key+"  --");
	        		}
	        		continue;
	        	}
	        	if(level==0){
	        		System.out.print("level "+level+"["+levelSize+"]--");
	        		levelSize=0;
	        		level++;
	        	}
	            System.out.printf("%d ",tempNode.key);  
	        	
	            if(tempNode.left!=null)  {
	            	levelSize++;
	            	queue.add(tempNode.left); 
	            	st.push(tempNode.left);
	            }
	                 
	            if(tempNode.right!=null){
	            	levelSize++;
	            	 queue.add(tempNode.right); 
	            	 st.push(tempNode.right);
	            }
	                
	        }  
	        
	        System.out.println("levelWithMarkerTraversal ends");
	    }  
	 
	//level wise traversing BFS
	 public  void levelOrderTraversal(Node root) {   
	        Queue<Node> queue=new LinkedList<Node>();  
	        queue.add(root);  
	        while(!queue.isEmpty())  
	        {  
	        	Node tempNode=queue.poll();  
	            System.out.printf("%d ",tempNode.key);  
	            if(tempNode.left!=null)  
	                queue.add(tempNode.left);  
	            if(tempNode.right!=null)  
	                queue.add(tempNode.right);  
	        }  
	    }  

	// prints in Spiral/Zigzag level order
	 public  void spiralOrZigzagLevelOrder(Node root) {
	        if(root==null) return; 
	        Stack<Node> stack=new Stack<Node>();
	        stack.push(root);
	        
	        boolean directionflag=false;
	        while(!stack.isEmpty())
	        {
	            Stack<Node> tempStack=new Stack<Node>();
	        
	            while(!stack.isEmpty())
	            {
	            	Node tempNode=stack.pop();
	            	System.out.printf("%d ",tempNode.key);
	                if(!directionflag) 
	                {
	                    if(tempNode.left!=null) 
	                     tempStack.push(tempNode.left);
	                    if(tempNode.right!=null) 
	                     tempStack.push(tempNode.right);
	                }else
	                {
	                    if(tempNode.right!=null) 
	                     tempStack.push(tempNode.right);
	                    if(tempNode.left!=null) 
	                     tempStack.push(tempNode.left);
	                }
	            }
	            // for changing direction
	            directionflag=!directionflag; 
	      
	            stack=tempStack; 
	        }
	     
	    }

	 
	 
	 public void printSpace(int i){
		 for(int j=0;j<i;j++){
			 System.out.print("  ");
		 }
	 }
	 
	// swapping of left and right children of every node
	public Node swapper(Node root){
		Node p;
		if(root!=null){
			p=root.left;
			root.left=swapper(root.right);
			root.right=swapper(p);
		}
		return root;
	}
	
	
	// Prints all paths to leaf from root
	 public  void printAllPathsToLeaf(Node node, int[] path, int len) {
	     if ( node == null )
	         return;

	     // storing data in array
	     path[len] = node.key;
	     len++;

	     if(node.left == null && node.right == null) {
	         // leaf node is reached
	    	 System.out.println();
	         printArray(path,len);
	         return;
	     }

	     printAllPathsToLeaf(node.left, path, len);
	     printAllPathsToLeaf(node.right, path, len);
	 }
	 
	

	/* To get the count of leaf nodes in a binary tree*/
	 public static  int getLeafCountOfBinaryTree(Node node)
	 {
	   if(node == null)      
	     return 0;
	   if(node.left ==null && node.right==null)     
	     return 1;           
	   else
	     return getLeafCountOfBinaryTree(node.left)+ getLeafCountOfBinaryTree(node.right);     
	}

 private void printArray(int[] path, int len) {
		 

		 for(int i=0;i<len;i++){
			 System.out.print(path[i]+"  ");
		 }
	}
	
}
