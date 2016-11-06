package main;

import java.util.Scanner;

public class MaxSum {
public static void main(String args[]){
	Scanner in = new Scanner(System.in); 
	int maxSum = 0;
	int length = in.nextInt();
	int arr[] = new int[length];
	for(int i =0; i < length; i ++){
		arr[i] = in.nextInt();
	}
	// 1 2 3 4 5 6 
	//Find the max sum of a pair of integer in a given integer array where these pairs are not consecutive
	int max = Integer.MIN_VALUE;int secondMax = Integer.MIN_VALUE;
	int maxPostion = 0;
	for(int i = 0; i < arr.length; i++){
		if(arr[i] > max){
			max = arr[i];
			maxPostion = i;
		}
	}
	for(int i =0 ; i < arr.length; i ++){
		if((i != maxPostion && i != maxPostion -1 )&& i != maxPostion +1){
			if(arr[i] > secondMax){
				secondMax = arr[i];
			}
		}
	}
	maxSum = max + secondMax;
	if(((maxPostion + 1) < arr.length && (maxPostion +1) >= 0) && ((maxPostion-1) < arr.length) && (maxPostion -1) >= 0){
		int sum = arr[maxPostion +1] + arr[maxPostion -1]; 
		if(sum > maxSum){
			maxSum = sum;
		}
	}
	System.out.println(maxSum);
}
}
