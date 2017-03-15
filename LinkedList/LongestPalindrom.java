package LinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class LongestPalindrom {

	public static String findLongestPalindrom(String input){
		String result= "";
		int max = 0;
		String reverse ="";
		for(int i = input.length() -1; i >=0 ; i --){
			reverse += input.charAt(i);
		}
		for(int j = input.length(); j >=0 ; j--){
			
			int i =0,tempJ = j;
			
//			if(tempJ > i){
			while(tempJ <= input.length()){
				String eachCombination = input.substring(i,tempJ);
				if(reverse.contains(eachCombination)){
					if(max < eachCombination.length()){
						max = eachCombination.length();
						result = eachCombination;
					}
				}
				i+= 1;
				tempJ += 1;
			}
//			}else{
//				break;
//			}
			
		}
		
		return result;
	}
	public static boolean isPlaindrom(String result){
		String reverse ="";
		for(int i = result.length() -1; i >=0 ; i --){
			reverse += result.charAt(i);
		}
		if(result.equals(reverse)){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String input = "adfasyyzzzzzzyy";
		System.out.println(findLongestPalindrom(input));
	}

}





