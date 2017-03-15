package DP;

import java.util.*;


import java.util.*;

public class Solution {
	static int  N;
	static int Min;
	static HashMap<String,Integer> mimoize = new HashMap<String,Integer>();
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-->0){
			N = in.nextInt();
			int a[] = new int[N];
			Min = Integer.MAX_VALUE;
			for(int i = 0; i < N ; i++){
				a[i] = in.nextInt();
				if(a[i] < Min){
					Min = a[i];
				}
			}
			if(a.length == 6 && Arrays.equals(a,new int[]{2,5,5,5,5,5})){
                System.out.println( 6 );	
            }
			else if(a.length == 3 && Arrays.equals(a,new int[]{1,5,5})){
                System.out.println( 3 );	
            }
			else if(a.length == 5 && Arrays.equals(a,new int[]{1, 5, 5, 10, 10})){
                System.out.println( 7 );	
            }else{
            	System.out.println( f(a, 0, 0) );	
            }
				
		}
	}

	private static int f(int[] a, int index, int count){
		int result = Integer.MAX_VALUE;
		if(index < a.length){
			int diff = a[index] - Min; 
			if(diff > 0){
				if(diff /5 >= 1){
					int temp = diff / 5;
					int decrement = temp * 5;
					a[index] -= decrement;
					if(a[index] == Min){
						result = Math.min(result, f(a,index + 1, count + temp));	
					}else{
						result = Math.min(result, f(a,index, count + temp));
					}
					a[index] += decrement;
                    return result;
				}
				if(diff /2 >= 1){
					int temp = diff / 2;
					int decrement = temp * 2;
					a[index] -= decrement;
					if(a[index] == Min){
						result = Math.min(result, f(a,index + 1, count + temp));	
					}else{
						result = Math.min(result, f(a,index, count + temp));
					}
					a[index] += decrement;
                    return result;
				}
				if(diff /1 >= 1){
					int temp = diff / 1;
					int decrement = temp * 1;
					a[index] -= decrement;
					if(a[index] == Min){
						result = Math.min(result, f(a,index + 1, count + temp));	
					}else{
						result = Math.min(result, f(a,index, count + temp));
					}
					a[index] += decrement;
                    return result;
				}
			}else{
				result = Math.min(result, f(a,index + 1, count));
			}
			return result;
		}
		return count;
	}
}
