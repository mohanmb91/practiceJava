package DP;
import java.util.*;

public class SamAndSubString {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
        String input = in.next();
        HashMap<String,Long> mimoize = new HashMap<String,Long>();
        long totalSum =0;
        for(int i = input.length()-1;i >=0; i --){
        	int temp = i;
        	String tempSum = "";
        	long tempSumTotal = 0;
    		while(temp < input.length()){
    			char currentDigit = input.charAt(temp);
    			if(tempSum.equals("")){
    				tempSum = currentDigit + tempSum;
        			tempSumTotal += Integer.parseInt(currentDigit+"");	
    			}else{
    				tempSum = tempSum + currentDigit;
        			tempSumTotal += Integer.parseInt(currentDigit+"");	
        			tempSumTotal += Integer.parseInt(tempSum+"");	
    			}
    			String key = temp + "+" + input.charAt(temp);
    			if(mimoize.containsKey(key)){
    				tempSumTotal += mimoize.get(key);
    			}
    			temp += 1;
    		}
    		if(i != input.length() -1){
    		String key = i + "+" + input.charAt(i);
    		mimoize.put(key, tempSumTotal);
    		}
    		totalSum += tempSumTotal;
        }
        System.out.println(totalSum);
        in.close();
	}
}
