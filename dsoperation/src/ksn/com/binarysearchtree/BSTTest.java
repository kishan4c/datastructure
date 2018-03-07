package ksn.com.binarysearchtree;

public class BSTTest {
	public static void gp(){
		System.out.println();
	}

	public static void main(String[] args) {

		BST bst=new BST();
		/*bst.addNode(3, "a");
		bst.addNode(1, "rr");
		bst.addNode(6, "gg");
		bst.addNode(4, "sc");
		bst.addNode(9, "kkk");
		bst.addNode(10, "kkk2");
		bst.addNode(11, "kkk3");
		bst.addNode(12, "kkk4");
		bst.addNode(13, "kkk5");
		bst.addNode(14, "kkk6");*/
		bst.addNode2(bst.root,17, "a");
		bst.addNode2(bst.root,15, "rr");
		bst.addNode2(bst.root,19, "gg");
		bst.addNode2(bst.root,16, "sc");
		bst.addNode2(bst.root,18, "kkk");
		bst.addNode2(bst.root,10, "kkk2");
		bst.addNode2(bst.root,12, "sc");
		bst.addNode2(bst.root,22, "kkk");
		bst.addNode2(bst.root,2, "kkk2");
		
		/*bst.addNode2(bst.root,33, "a");
		bst.addNode2(bst.root,11, "rr");
		bst.addNode2(bst.root,66, "gg");
		bst.addNode2(bst.root,44, "sc");
		bst.addNode2(bst.root,5, "kkk");
		bst.addNode2(bst.root,12, "kkk2");
		
		bst.addNode2(bst.root,13, "a");
		bst.addNode2(bst.root,14, "rr");
		bst.addNode2(bst.root,16, "gg");
		bst.addNode2(bst.root,24, "sc");
		bst.addNode2(bst.root,19, "kkk");
		bst.addNode2(bst.root,22, "kkk2");
		bst.addNode2(bst.root,0, "kkk3");
		bst.addNode2(bst.root,12, "kkk4");
		bst.addNode2(bst.root,13, "kkk5");
		bst.addNode2(bst.root,14, "kkk6");*/
		
		
		/*bst.preOrderTraversR(bst.root);
		System.out.println();
		bst.preOrderTraversNonRec(bst.root);
		System.out.println("================================preOrderTraversR=============================================");
		bst.inOrderTraversR(bst.root);
		System.out.println();
		bst.inOrderTraversNonRec(bst.root);
		System.out.println("===============================inOrderTraversNonRec==============================================");*/
		bst.printLevelOrderBFS(bst.root);
		bst.levelOrderTraversal(bst.root);
		System.out.println();
		System.out.println(bst.count(bst.root));
		System.out.println("spiralOrZigzagLevelOrder");
		bst.spiralOrZigzagLevelOrder(bst.root);
		System.out.println("\ntwo degree nodes----"+bst.countDegreeTwoNodes(bst.root));
		System.out.println("\ntwo onr nodes----"+bst.countDegreeOneNodes(bst.root));
		
		System.out.println("cloning ..................");
		
		//bst.root=bst.deleteIterative(bst.root, 18);
		//bst.root=bst.deleteIterative(bst.root, 2);
		//System.out.println();
		//bst.inOrderTraversNonRec(bst.root);
		 System.out.println("\n#####################iiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		 
		//BST bst2=new BST();
		//bst2.root=bst.cloneTree(bst.root);
		
		//bst2.levelOrderTraversal(bst2.root);
	//	bst.swapper(bst.root);
		//System.out.println("tree equivalence check");
		//System.out.println("isEquivalence--"+bst.isEquivalence(bst.root, bst2.root));
		
		System.out.println("Printing all paths from root to leaf :");  
		  bst.printAllPathsToLeaf(bst.root,new int[1000],0);  
		  System.out.println("\n#####################");
		  bst.levelWithMarkerTraversal(bst.root);
		  
		  bst.postOrderTraversalIterative(bst.root);

		  bst.postOrderTraversalIterativeTwoStacks(bst.root);
		  
		  //bst.levelWithMarkerTraversal(bst.root);
		  
		  System.out.println("height--"+bst.height(bst.root));
		  bst.preOrderIter(bst.root);
		  gp();
		  bst.preOrderTraversR(bst.root);
		  
		  
		//bst.inOrderIter(bst.root);
		/*bst.inOrderTraversR(bst.root);
		System.out.println("count all nodes--"+bst.count(bst.root));
		bst.traverse(bst.root);
		//bst.find_min(bst.root);
		//bst.find_max(bst.root);
		bst.delete(bst.root, 6);
		bst.inOrderTraversR(bst.root);
		System.out.println("height--"+bst.height(bst.root));
		System.out.println("count all nodes--"+bst.count(bst.root));*/
	}

}
