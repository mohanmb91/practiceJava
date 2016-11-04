package main;

import java.util.*;

public class repeatingElementArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int array[] = new int[size];
		for(int i =0; i < size; i ++){
			array[i] = in.nextInt();
		}
		int sum =0;
		for(int i=0; i < size; i++){
		sum = sum + array[i];
		int summation = ((i+1)*(i + 2))/2;
		if(sum != summation){
			System.out.println(array[i]);
			break;
		}
		}
		in.close();
	}

}
