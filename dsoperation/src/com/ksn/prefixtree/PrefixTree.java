package com.ksn.prefixtree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*static int factorial(int n){    
	  if (n == 0)    
	    return 1;    
	  else    
	    return(n * factorial(n-1));    
	 } 

public static int fibonacci(int number){ 
	if(number == 1 || number == 2){ 
		return 1; 
		}
	
	return fibonacci(number-1) + fibonacci(number -2); //tail recursion }
}*/


public class PrefixTree {

	static TrieNode createTree()
    {
        return(new TrieNode('\0'));
    }
    
    static void insertWord(TrieNode root, String word)
    {
        int offset = 97;
        int l = word.length();
        char[] letters = word.toCharArray();
        TrieNode curNode = root;
        
        for (int i = 0; i < l; i++)
        {
        	int index= letters[i]-offset;
            if (curNode.links[index] == null){
            	 curNode.links[index] = new TrieNode(letters[i]);
            	}
            curNode = curNode.links[index]; // move forward
        }
        curNode.fullWord = true;  
        curNode.count++;
        
    }

    static boolean find(TrieNode root, String word)
    {
        char[] letters = word.toCharArray();
        int l = letters.length;
        int offset = 97;
        TrieNode curNode = root;
        
        int i;
        for (i = 0; i < l; i++)
        {
            if (curNode == null)
                return false;
            curNode = curNode.links[letters[i]-offset]; //move forward
        }
        
        if (i == l && curNode == null)
            return false;
        
        if (curNode != null && !curNode.fullWord)
            return false;
        
        return true;
    }
    
    static void printTree(TrieNode root, int level, char[] branch)
    {
        if (root == null)
            return;
        
        for (int i = 0; i < root.links.length; i++)
        {
        	/*char l='*';
        	if(root.links[i]!=null){
        		l = root.links[i].letter;
        	}
        	System.out.print(l+"|");
        	if(root.links.length==25){
        		System.out.println();
        	}*/
            branch[level] = root.letter;
            printTree(root.links[i], level+1, branch);    
        }
        
        if (root.fullWord)
        {
            for (int j = 1; j <= level; j++){
            	System.out.print(branch[j]);
            	
            }
            System.out.println("--->"+root.count);   
            System.out.println();
        } 
    }
	
	public static void main(String[] args) {

        TrieNode tree = createTree();
        
        String[] words = {
        		"an", "ant", "all", "allot", "alloy", "aloe",
        		"are", "ate", "be","alll","xcv","an","ssfd",
        		"an","fgr","cat","mat","cat",
        		"an", "ant", "all", "allot", "alloy", "aloe",
        		"are", "ate", "be","alll","xcv","an","ssfd",
        		"an","fgr","cat","mat","cat"
        		};
        List<String> lst = Arrays.asList(words);
        for (int i = 0; i < words.length; i++)
            insertWord(tree, words[i]);
        
        
        System.out.println(tree.links.length);
        char[] branch = new char[50];
        printTree(tree, 0, branch);
        int i = Collections.frequency(lst, "an");
        System.out.println(i);
       /* String searchWord = "all";
        if (find(tree, searchWord))
        {
            System.out.println("The word was found");
        }
        else
        {
            System.out.println("The word was NOT found");
        }*/
	}

}

