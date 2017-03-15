package WeekOfCode29;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Checker implements Comparator<String>{
	@Override
	public int compare(String a, String b){
		for(int i=0; i < a.length(); i++){
			int A = a.charAt(i);
			int B = b.charAt(i);
			if(A > B){
				return 1;
			}else if(A < B){
				return -1;
			}
		}
		return 0;
	}
}
public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        TreeMap<Integer, PriorityQueue<String>> maps = new TreeMap<>();
        
        
        int n = in.nextInt();
        
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
        	String input = in.next();
        	if(!maps.containsKey(input.length())){
        		PriorityQueue<String> frontier = new PriorityQueue<>(10,new Checker());
        		frontier.add(input);
        		maps.put(input.length(), frontier);
        	}else{
        		PriorityQueue<String> frontier = maps.get(input.length());
        		frontier.add(input);
        		maps.put(input.length(), frontier);
        	}
        }
        
        for(int eachKey: maps.keySet()){
        	PriorityQueue<String> frontier = maps.get(eachKey);
        	while(!frontier.isEmpty()){
        		System.out.println(frontier.poll());
        	}
        }
        
    }
}