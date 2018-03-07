package ksn.com.avl.tree;

public class AVLTreeTest {

	public static void main(String[] args) {

		AVLTree avl=new AVLTree();
		avl.root=avl.insert(avl.root, 55);
		avl.root=avl.insert(avl.root, 56);
		avl.root=avl.insert(avl.root, 57);
		avl.root=avl.insert(avl.root, 58);
		
		avl.inOrderTraversR(avl.root);
		
	}

}
