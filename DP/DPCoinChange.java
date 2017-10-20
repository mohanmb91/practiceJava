package DP;

import java.util.*;
public class DPCoinChange {
	static TreeMap<Integer, long[]> maps = new TreeMap<Integer, long[]>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		int n = in.nextInt();
		int cDenomination[] = new int[n];
		for(int i =0; i < n ; i ++){
			cDenomination[i] = in.nextInt();	
		}
		Arrays.sort(cDenomination);
		int previousCoinDenomination = -1;
		for(int i =0 ; i < n ; i ++){
			long[] array = new long[total+1];
			int coinDenomination = cDenomination[i];
			if(i == 0){
				for(int currentTotal = 0; currentTotal <= total; currentTotal ++ ){
					if(currentTotal % coinDenomination == 0){
						array[currentTotal] = 1;
					}else{
						array[currentTotal] = 0;
					}
				}
				previousCoinDenomination = coinDenomination;
				maps.put(coinDenomination, array);	
			}else{
				long previousArray[] = maps.get(previousCoinDenomination);
				for(int currentTotal = 0; currentTotal <= total; currentTotal ++ ){
					if(currentTotal < coinDenomination){
						array[currentTotal] = previousArray[currentTotal];
					}else{
						array[currentTotal] = previousArray[currentTotal] + array[currentTotal - coinDenomination];
					}
				}
				previousCoinDenomination = coinDenomination;
				maps.put(coinDenomination, array);
			}
		}
		for(int eachDenomination: maps.descendingKeySet()){
			long tempArray[] = maps.get(eachDenomination);
			System.out.println(tempArray[total]);
			break;
		}
		in.close();
	}

}
