package ksn.com.avl.tree;

	/* AVL Tree | Set 1 (Insertion)
	AVL tree is a self-balancing Binary Search Tree (BST) where the difference
	between heights of left and right subtrees cannot be more than one for all nodes.
	
	Why AVL Trees?
	Most of the BST operations (e.g., search, max, min, insert, delete.. etc) 
	take O(h) time where h is the height of the BST. The cost of these operations 
	may become O(n) for a skewed Binary tree. If we make sure that height of the 
	tree remains O(Logn) after every insertion and deletion, then we can guarantee
	 an upper bound of O(Logn) for all these operations. The height of an AVL tree 
	 is always O(Logn) where n is the number of nodes in the tree
	 
	 Note:::
	  Trees which remain balanced - and thus guarantee O(logn) search times - 
	  in a dynamic environment. Or more importantly, since any tree can be 
	  re-balanced - but at considerable cost - can be re-balanced in O(logn) time.
	 

	Insertion
	To make sure that the given tree remains AVL after every insertion, we must
	 augment the standard BST insert operation to perform some re-balancing. 
	 Following are two basic operations that can be performed to re-balance
	  a BST without violating the BST property (keys(left) < key(root) < keys(right)).
	1) Left Rotation
	2) Right Rotation
	
	T1, T2 and T3 are subtrees of the tree rooted with y (on left side) 
	or x (on right side)           
	                y                               x
	               / \     Right Rotation          /  \
	              x   T3   – – – – – – – >        T1   y 
	             / \       < - - - - - - -            / \
	            T1  T2     Left Rotation            T2  T3
	            
	Keys in both of the above trees follow the following order 
	      keys(T1) < key(x) < keys(T2) < key(y) < keys(T3)
	So BST property is not violated anywhere.
	Steps to follow for insertion
	Let the newly nserted node be w
	1) Perform standard BST insert for w.
	2) Starting from w, travel up and find the first unbalanced node.
	 Let z be the first unbalanced node, y be the child of z that comes
	  on the path from w to z and x be the grandchild of z that comes on 
	  the path from w to z.
	3) Re-balance the tree by performing appropriate rotations on the
	 subtree rooted with z. There can be 4 possible cases that needs to
	  be handled as x, y and z can be arranged in 4 ways. Following 
	  are the possible 4 arrangements:
	a) y is left child of z and x is left child of y (Left Left Case)
	b) y is left child of z and x is right child of y (Left Right Case)
	c) y is right child of z and x is right child of y (Right Right Case)
	d) y is right child of z and x is left child of y (Right Left Case)
	
	Following are the operations to be performed in above mentioned 4 cases.
	 In all of the cases, we only need to re-balance the subtree rooted with z
	  and the complete tree becomes balanced as the height of subtree
	   (After appropriate rotations) rooted with z becomes same as it was 
	   before insertion.
	

	a) Left Left Case
	
	T1, T2, T3 and T4 are subtrees.
	         z                                      y 
	        / \                                   /   \
	       y   T4      Right Rotate (z)          x      z
	      / \          - - - - - - - - ->      /  \    /  \ 
	     x   T3                               T1  T2  T3  T4
	    / \
	  T1   T2
	b) Left Right Case
	
	     z                               z                           x
	    / \                            /   \                        /  \ 
	   y   T4  Left Rotate (y)        x    T4  Right Rotate(z)    y      z
	  / \      - - - - - - - - ->    /  \      - - - - - - - ->  / \    / \
	T1   x                          y    T3                    T1  T2 T3  T4
	    / \                        / \
	  T2   T3                    T1   T2
	c) Right Right Case
	
	  z                                y
	 /  \                            /   \ 
	T1   y     Left Rotate(z)       z      x
	    /  \   - - - - - - - ->    / \    / \
	   T2   x                     T1  T2 T3  T4
	       / \
	     T3  T4
	d) Right Left Case
	
	   z                            z                            x
	  / \                          / \                          /  \ 
	T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z      y
	    / \  - - - - - - - - ->     /  \   - - - - - - - ->  / \    / \
	   x   T4                      T2   y                  T1  T2  T3  T4
	  / \                              /  \
	T2   T3                           T3   T4
	* */
 public class AVLTree {

	Node root=null;
	
	public int height(Node root){
		Node p=root;
		if(p==null){
			return 0;
		}
		return Math.max(height(p.left), height(p.right))+1;
		
	}
	public Node rotateRight(Node x){
		Node y;
		y=x.left;
		x.left=y.right;
		y.right=x;
		x.height=height(x);
		y.height=height(y);
		return(y);
		
	}
	
	public Node rotateLeft(Node x){
		Node y;
		y=x.right;
		x.right=y.left;
		y.left=x;
		x.height=height(x);
		y.height=height(y);
		return(y);
		
	}
	
	public Node RR(Node t){
		t=rotateLeft(t);
		return t;
	}
	
	public Node LL(Node t){
		t=rotateRight(t);
		return t;
	}

	public Node LR(Node t){
	
		t.left=rotateLeft(t.left);
		t=rotateRight(t);
		return t;
	}

	public Node RL(Node t){
	
		t.right=rotateRight(t.right);
		t=rotateLeft(t);
		return t;
	}
	
	public int BF(Node t){
		int lh,rh;
		if(t.left==null){
			lh=0;
		}
		else{
			lh=1+t.left.height;
		}
		if(t.right==null){
			rh=0;
		}
		else{
			rh=1+t.right.height;
		}
		return lh-rh;
	}
	
	public Node insert(Node t,int x){
		
		if(t==null){
			t=new Node(x);
		}
		else{
			if(x>t.key){
				t.right=insert(t.right,x);
				if(BF(t)==2){
					if(x>t.right.key){
						t=RR(t);
					}
					else{
						t=RL(t);
					}
				}
			}
			else{
				if(x<t.key){
					t.left=insert(t.left,x);
					if(BF(t)==2){
						if(x<t.left.key){
							t=LL(t);
						}
						else{
							t=LR(t);
						}
					}
				}
				
			}
		}
		t.height=height(t);
		return t;
		
	}
	
	public void inOrderTraversR(Node cur){
		if(cur!=null){
			inOrderTraversR(cur.left);
		System.out.print(cur.key+"  ");
		inOrderTraversR(cur.right);
		}
		
	}
	
	public void preOrderTraversR(Node cur){
		if(cur!=null){
			System.out.print(cur.key+"  ");
			preOrderTraversR(cur.left);
			preOrderTraversR(cur.right);
		}
		
	}
	
	
	public void postOrderTraversR(Node cur){
		if(cur!=null){
			postOrderTraversR(cur.left);
			postOrderTraversR(cur.right);
			System.out.print(cur.key+"  ");
		}
		
	}
	
}
