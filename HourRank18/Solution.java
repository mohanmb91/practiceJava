package HourRank18;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int count =0;
        for(int i=1;i<= s.length(); i ++){
        	int start = 0;
        	int end = start + i; 
        	while(end <= s.length()){
        		String result = s.substring(start, end);
        		BigInteger eachCombination = new BigInteger(result);
        		boolean isDivisible = ((eachCombination.mod(new BigInteger("6"))).equals(new BigInteger("0")));
        		if(result.length() > 1 && result.charAt(0) != '0'){
            		if(isDivisible) {
            			count +=1;
            		}	
        		}else if(result.length() == 1){
        			if(isDivisible) {
            			count +=1;
            		}	
        		}
        		
        		
        		start += 1;
        		end = start + i;
	        }
        }
        System.out.println(count);
        in.close();
    }
}
