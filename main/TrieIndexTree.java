package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TrieNode
{
    Integer value = 0;
    TrieNode[] node = new TrieNode[26];
}

class Trie
{
    TrieNode root;
    public Trie()
       {
       root = new TrieNode();
       } 
    
    public void insert(String name)
       {
       TrieNode p = root;
       int length = name.length();
       int i;
       for(i=0 ; i<length ;i++)
          {
          int index = name.charAt(i) - 'a';
          if(p.node[index] == null)
              { 
              p.node[index] = new TrieNode();
              p.value++;
              }
          else 
              p.value++;
          p = p.node[index];
          }
       p.value = 1;
       }
    
    public int search(String key)
       {
       TrieNode p = root;
       int c=0;
       int len = key.length();
       int i;
       for(i=0 ; i<len ; i++)
           {
           int index = key.charAt(i) - 'a';
           if(p.node[index] == null)
              return 0;
           p = p.node[index];
           }
       return p.value;
       }
}


public class TrieIndexTree {
	  public static void main(String[] args) throws Exception
      {
      Trie data = new Trie();
      int t;
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      t = Integer.parseInt(br.readLine());      
      String input;
      while(t-- > 0)
          {
          input = br.readLine();
          String[] pair = input.split(" ");
          if(pair[0].equals("add"))
             data.insert(pair[1]);            
          else
             System.out.println(data.search(pair[1]));
          }    
      }  
}
