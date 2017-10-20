package twitterU;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		maxLength(new int[]{1,2,3},3);

	}
	static int maxLength(int[] a, int k) {
        Arrays.sort(a);
        int sum = 0, maxPhrase =0;
        int pointer = 0;
        for(int i=0; i < a.length; i ++){
        	if((sum +  a[i]) <= k){
        		sum += a[i];
        	}else{
        		maxPhrase =  i - pointer;
        		while(sum > k){
        			sum = sum - a[pointer];
        			pointer ++;
        		}
        	}
        	if(pointer > i){
        		break;
        	}
        }
        return maxPhrase;
    }

}
