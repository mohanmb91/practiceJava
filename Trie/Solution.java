package Trie;
import java.util.*;

class Node{
	Node[] childrens;
	int wordCount;
	public Node(){
		childrens = new Node[26];
		wordCount = 0;
	}
}
class Trie{
	Node root;
	public Trie() {
		root = new Node();
	}
	public void addWord(String str){
		Node current = root;
		for(int i=0; i < str.length(); i ++){
			int asciiValue = (int) str.charAt(i);asciiValue -= 97;
			if(current.childrens[asciiValue] == null){
				current.childrens[asciiValue] = new Node();	
			}
			current.wordCount += 1;
			current = current.childrens[asciiValue];
		}
		current.wordCount += 1;
	}
	public int searchWordCount(String str){
		Node current = root;
		for(int i=0; i < str.length(); i ++){
			int asciiValue = (int) str.charAt(i);asciiValue -= 97;
			if(current.childrens[asciiValue] == null){
				return 0;
			}
			current = current.childrens[asciiValue];
		}
		return current.wordCount;
	}
}
public class Solution {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Trie tree = new Trie();
		while(n-->0){
			String operation = in.next();
			if(operation.equals("add")){
				tree.addWord(in.next());
			}else{
				System.out.println(tree.searchWordCount(in.next()));
			}
		}
		in.close();	
	}
}


/*
4
add hack
add hackerrank
find hac
find hak
*/