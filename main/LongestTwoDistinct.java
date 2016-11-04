package main;
import java.util.*;

class LongestTwoDistinct{
public static void main(String args[]){
	HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
	Scanner in = new Scanner(System.in);
	String input = in.nextLine();
	for(int i=0 ; i < input.length(); i ++){
	int max =0,start =0;
	char c = input.charAt(i);
	if(!charCount.containsKey(c)){
		charCount.put(c,1);
		max += 1;
	}else{
		int count = charCount.get(c);
		count  += 1;
		charCount.put(c,count);
		max += 1;
	}
	
	if(charCount.size() > 2){
		while(charCount .size() >  2){
			char t = input.charAt(start);
			if(charCount.containsKey(t)){
				if(charCount.get(t) > 1){
				int tempCount = charCount.get(t);
				tempCount = tempCount -1;
				charCount.put(t,tempCount);
				}
				else{
				charCount.remove(t);
				}	
			max = max -1;
			start ++;	
			}
		}
	}
	}

}
}