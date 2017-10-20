package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

 class TrieNode{
    char ch;
     HashMap<Character, TrieNode> children;
     boolean isComplete;
     int numberOfWord;
    public TrieNode(char ch)
         {
         this.ch = ch;
         this.isComplete = false;
         this.children = new HashMap<Character, TrieNode>();
         this.numberOfWord = 0;
     }
 }
  class Trie{
    TrieNode root;
    public Trie(){
    this.root = new TrieNode('*');
    }
    
    public void add(String word){
        TrieNode current  = root;
        for(char c : word.toCharArray())
            {
                if(current.children.get(c) == null)
                    current.children.put(c,new TrieNode(c));
                current = current.children.get(c);
                current.numberOfWord++;
        }
         current.isComplete = true;
    }
    
    public int find(String prefix)
        {
         TrieNode current  = root;
         for(char c : prefix.toCharArray())
            {
                if(current.children.get(c) == null)
                   return 0;
                current = current.children.get(c);
        }
        return current.numberOfWord ;
    }
    private int find(TrieNode n)
        {
        if(n.isComplete && n.children.size() == 0)
            {
            return 1;
        }
        int count = 0;
        for(TrieNode node : n.children.values())
            {
            count = count +  find(node) + (n.isComplete?1:0) ;
        }
        
        return count;
    }
   
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Trie tree= new Trie();
        tree.add("hack");
        tree.add("hackrank");
        System.out.println(tree.find("hac"));
    }
}
