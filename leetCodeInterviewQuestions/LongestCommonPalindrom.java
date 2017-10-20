package leetCodeInterviewQuestions;
import java.util.*;
public class LongestCommonPalindrom {
	   public static String longestPalindrome(String s) {
	        int n = s.length(), palindromeBeginAt = 0, palindromEndAt = 1, max = Integer.MIN_VALUE;
	        
	        boolean mimoize[][] = new boolean[n][n];
	        for(int cSL = 1; cSL <= n; cSL ++){
	            for(int i = 0; (i + cSL) <= n; i++){
	                int start = i;
	                int end = start + cSL;
	                int diff = end - start;
	                if(diff == 1){
	                    mimoize[start][end -1] = true;
	                }else if(diff == 2){
	                    if(s.charAt(start) == s.charAt(end -1)){
	                    	if(diff > max){
	                    		palindromeBeginAt = start;
	                    		palindromEndAt = end;
	                    	}
	                        mimoize[start][end -1] = true;    
	                    }
	                }else{
	                	if(s.charAt(start) == s.charAt(end -1) && mimoize[start +1][end-2]){
	                		if(diff > max){
	                    		palindromeBeginAt = start;
	                    		palindromEndAt = end;
	                    	}
	                		mimoize[start][end -1] = true;    
	                    }
	                }
	                
	            }
	        }
	        String result = s.substring(palindromeBeginAt,palindromEndAt);
	        return result;
	    }
	   public static void main(String args[]){
		   System.out.println(longestPalindrome("banana"));
	   }
	}