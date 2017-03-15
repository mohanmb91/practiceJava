package WeekOfCode29;

import java.util.HashMap;
import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        boolean isjulican = false,isTranssactionPeriod = false; 
	        int y = in.nextInt();
	        if(y >= 1700 && y <= 1917){
	        	isjulican = true;
	        }
	        if(y == 1918){
	        	isTranssactionPeriod = true;
	        }
	        HashMap<Integer,Integer> maps = new HashMap<Integer,Integer>();
	        maps.put(1, 31);
	        if(isjulican){
	        	if(y % 4 == 0){
	        		maps.put(2, 29);
	        	}else{
	        		maps.put(2, 28);
	        	}
	        }else{
	        	if((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)){
	        		maps.put(2, 29);
	        	}else{
	        		maps.put(2, 28);
	        	}
	        }
	        if(isTranssactionPeriod){
	        	int feb = maps.get(2);
	        	feb = feb - 13;
	        	maps.put(2,feb);
	        }
	        maps.put(3, 31);maps.put(4, 30);maps.put(5, 31);maps.put(6, 30);maps.put(7, 31);maps.put(8, 31);
	        maps.put(9, 30);maps.put(10, 31);maps.put(11, 30);maps.put(12, 31);
	    	int total = 256;
	        for(int eachMonth =1; eachMonth <= 12; eachMonth++){
	        	if(maps.get(eachMonth) < total){
	        		total = total - maps.get(eachMonth);
	        	}else{
	        		String month = eachMonth+"";
	        		System.out.println(total+"."+ (month.length() <=1 ? ("0"+month) : month) + "."+ y );
	        		break;
	        	}
	        }
	}

}
