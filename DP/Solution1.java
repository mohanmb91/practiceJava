package DP;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {
	static HashMap<Integer,Integer> A = new HashMap<Integer,Integer>();
	static HashMap<String,Integer> mimoize = new HashMap<String,Integer>();
	//static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            int n = in.nextInt();
            int b[] = new int[n];
            for(int i=n-1;i >= 0 ; i --){
                b[i] = in.nextInt();
            }
            //count = 0;
            mimoize = new HashMap<String,Integer>();
            System.out.println(f(0,b,0));
            //System.err.println(count);
        }
        in.close();
    }
    public static int f(int index, int[] b, int sum){
    	//count ++;
    	String key = index + "+" + sum;
    	if(mimoize.containsKey(key)){
    		return mimoize.get(key);
    	}
    else{
        if(index < b.length){
        	int maxSum = 0;
            for(int i = b[index]; i >= 1;){
            	if(index > 0){
                int diff = Math.abs(i - A.get(index- 1));
                int newSum = sum + diff;
                A.put(index, i);
                int tempResult = f(index+1,b,newSum);
                if(tempResult > maxSum){
                	maxSum = tempResult;
                }
                A.put(index, i);
            	}else{
            		A.put(index, i);
            		maxSum = Math.max(maxSum,f(index+1,b,sum));
            		A.put(index, i);
            	}
            	if(i == 1){
            		break;
            	}else{
            		i = i / i;
            	}
            }
            mimoize.put(key, maxSum);
            return maxSum;
        }else{
        	return sum;
        }
    }
    }
}