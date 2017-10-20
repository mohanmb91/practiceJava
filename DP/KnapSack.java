package DP;


	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	public class KnapSack {
	    static HashMap<Integer,long[]> maps = new HashMap<>();
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int T = in.nextInt();
	        while(T--> 0){
	            int n = in.nextInt();
	            int sum = in.nextInt();
	            int elements[] = new int[n];
	            maps = new HashMap<>();
	            for(int i =0; i < n ; i ++){
	                elements[i] = in.nextInt();	
	            }
	            Arrays.sort(elements);
	            long nearestSum = Long.MIN_VALUE;
	            int previousCoinDenomination = -1;
	            boolean isMaxSumReached = false;
	            for(int i =0 ; i < n ; i ++){
	                long[] array = new long[sum+1];
	                int coinDenomination = elements[i];
	                if(i == 0){
	                    for(int currentTotal = 0; currentTotal <= sum; currentTotal ++ ){
	                        if(currentTotal % coinDenomination == 0){
	                            array[currentTotal] = 1;
	                            if(currentTotal > nearestSum){
	                                nearestSum = currentTotal;
	                                if(nearestSum == sum){
	                                	isMaxSumReached = true;
	                                	break;
	                                }
	                            }
	                        }else{
	                            array[currentTotal] = 0;
	                        }
	                    }
	                    
	                    previousCoinDenomination = coinDenomination;
	                    maps.put(coinDenomination, array);
	                    if(isMaxSumReached){break;}
	                }else{
	                    long previousArray[] = maps.get(previousCoinDenomination);
	                    for(int currentTotal = 0; currentTotal <= sum; currentTotal ++ ){
	                        if(currentTotal < coinDenomination){
	                            array[currentTotal] = previousArray[currentTotal];
	                            if(array[currentTotal] > 0 && currentTotal > nearestSum){
	                                nearestSum = currentTotal;
	                                if(nearestSum == sum){
	                                	isMaxSumReached = true;
	                                	break;
	                                }
	                            }
	                        }else{
	                            array[currentTotal] = previousArray[currentTotal] + array[currentTotal - coinDenomination];
	                            if(array[currentTotal] > 0 && currentTotal > nearestSum){
	                                nearestSum = currentTotal;
	                                if(nearestSum == sum){
	                                	isMaxSumReached = true;
	                                	break;
	                                }
	                            }
	                        }
	                    }
	                    previousCoinDenomination = coinDenomination;
	                    maps.put(coinDenomination, array);
	                    if(isMaxSumReached){break;}
	                }
	            }
	            System.out.println(nearestSum);
	        }
	        in.close();
	    }
	}