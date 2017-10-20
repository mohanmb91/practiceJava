package clearpool;

import java.util.*;

public class Solution {
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in); 
		int n = scan.nextInt();
		System.out.println(findCombinations(0,n,""));
	}

	private static int findCombinations(int sum,int destination, String combinations) {
		int result = 0;
		if(sum == destination){
			return 1;
		}
		if(sum > destination){
			return 0;
		}
		for(int i = 1; i <= destination; i ++){
			result = result + findCombinations(sum + i, destination,combinations +'+'+ i);
			
		}
		return result;
	}
}
