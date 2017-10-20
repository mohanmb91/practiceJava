package fidessa;

import java.util.Stack;

public class Solution {
	
	int function(String input){
		if((input.length()==0) && !Character.isUpperCase(input.charAt(0))){
			return -1;
		}
		int answer=-1;
		int length=input.length();
		Stack<Character> stack = new Stack<Character>();
		stack.push(input.charAt(0));
	    for(int i=1;i<length;i++){
	       if(!stack.isEmpty()){
	    	   char eachCharacter = stack.peek();
	    	   if(Character.toLowerCase(eachCharacter) == input.charAt(i)){
	    		   stack.pop();
	    		   answer=-1;
	    	   }
	    	   else{
	    		  stack.push(input.charAt(i));
	    	   }
	       }
	       else{
	    	   stack.push(input.charAt(i));
	       }
	    }
	    
	    if(stack.isEmpty()){
	    	return length-1;
	    }
	    else{
	    	return answer;
	    }
	}
	 public static void main(String args[]){
		 
	 }
}
