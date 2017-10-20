package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class WordBreak {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
 
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        return t[s.length()];
    }

   
	public static void main(String args[]){
    	WordBreak obj = new WordBreak();
    	List<String> list = new ArrayList<>();
    	list.add("abc");
    	list.add("abcd");
    	list.add("defg");
    	list.add("h");
    	System.out.println(obj.wordBreak("abcdefgh", list));
    }
}