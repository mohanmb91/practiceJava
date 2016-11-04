package main;

import java.util.*;

public class Binary {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		String result = "";
		while (number > 0){
			result = String.valueOf(number % 2) + result;
			number /= 2;
		}
		System.out.println(result);
	}
}
