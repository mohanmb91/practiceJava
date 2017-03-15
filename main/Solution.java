package main;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static HashMap<Integer,Integer> results = new HashMap<Integer,Integer>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            results = new HashMap<Integer,Integer>();
            int PossibleWays = davidStairCase(0,n);
            System.out.println(PossibleWays);
        }
    }
    public static int davidStairCase(int currentStair,int limit){
        if(currentStair == limit){
            return 1;
        }else if(currentStair > limit){
            return 0;
        }else{
            int first,second,third; first = second = third = 0;
            if(results.containsKey(currentStair)){
            	return results.get(currentStair);
            }else{
	            first = davidStairCase(currentStair+1,limit);
	            results.put(currentStair+1, first );
	            second =  davidStairCase(currentStair+2,limit);
	            results.put(currentStair+2, second );
	            third = davidStairCase(currentStair+3,limit);
	            results.put(currentStair+3, third );
	            return first + second + third;
            }
        }
    }
}


