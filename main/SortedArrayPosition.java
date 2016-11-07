package main;

import java.util.Scanner;

public class SortedArrayPosition {
public static void main(String args[]){
//	Scanner scan = new Scanner(System.in);
	String input = "12 23 25 33 34 39 40 45";//scan.nextLine();
	
	int i = getPosition(input,33);
	System.out.println(i);
//	scan.close();
}

private static int getPosition(String input, int searchValue) {
	// TODO Auto-generated method stub
	int i = input.length() -1;
	for(;i < input.length();){
		i = i /2;
		int left = i;
		int right = i+1;
		String result = "";
		while(input.charAt(left) != ' '){
			result = String.valueOf(input.charAt(left)) + result;
			left --;
		}
		while(input.charAt(right) != ' '){
			result = result + String.valueOf(input.charAt(right)) ;
			right ++;
		}
		i = i - (i-left);
		if(searchValue > Integer.parseInt(result)){
			i = (int) (i + Math.round( (Double.parseDouble(String.valueOf(i))) / 2.0));
		}else if(searchValue < Integer.parseInt(result)){
			i = i - i/2;
		}
		else{
			return i;
		}
	}
	return -1;
}
}
