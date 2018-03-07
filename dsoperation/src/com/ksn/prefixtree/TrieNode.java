package com.ksn.prefixtree;

public class TrieNode {
	char letter;
    TrieNode[] links;
    boolean fullWord;
    int count = 0;
    
    TrieNode(char letter)
    {
        this.letter = letter;
        links = new TrieNode[26];
        this.fullWord = false;
    }

}
