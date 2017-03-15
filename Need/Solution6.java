package Need;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution6 {
	static long count1 =0;
    static HashMap<String,Boolean> mimoize = new HashMap<String,Boolean>();
    static int N;
    static String row1;
    static String row2;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            N = in.nextInt();
            row1 = in.next();
            row2 = in.next();
            int blackCount =0;
            for(int i=0;i<N;i++){
            	blackCount += (row1.charAt(i) == '1') ? 1:0;
            	blackCount += (row2.charAt(i) == '1') ? 1:0;
            }
            N=(2*N)-blackCount;
            mimoize = new HashMap<String,Boolean>();
            if(f(-1,-1,0)){
               System.out.println("YES");
            }else{
               System.out.println("NO");
            }
            System.out.println(count1);
        }
        in.close();
    }
    public static boolean f(int row1Index,int row2Index,int count){
    	count1 ++;
        if(mimoize.containsKey(row1Index+"+"+row2Index+"+"+count)){
            return mimoize.get(row1Index+"+"+row2Index+"+"+count);
        }
        else{
    	if(count == N){
    		return true;
    	}else{
    		//red Dominos
    		while(row1Index + 1 < row1.length() && row1.charAt(row1Index + 1) == '1'){
				row1Index+=1;
			}
			while(row2Index + 1 < row2.length() && row2.charAt(row2Index + 1) == '1'){
				row2Index+=1;
			}
    		boolean answer = false;
    		if(row1Index == row2Index){
	    		if(row1Index + 1 < row1.length() && row2Index + 1 < row2.length()){
	    			if(row1.charAt(row1Index + 1) != '1' && row2.charAt(row1Index + 1) != '1'){
	    				answer = answer || f(row1Index + 1, row2Index + 1,count + 2);
	    			}
	    		}
    		}
    		// yellow Dominos
    		if(row1Index + 1 < row1.length() && row1Index + 2 < row1.length()){
    			if(row1.charAt(row1Index + 1) != '1' && row1.charAt(row1Index + 2) != '1'){
    				answer = answer || f(row1Index + 2, row2Index,count + 2);
    			}
    		}
    		if(row2Index + 1 < row2.length() && row2Index + 2 < row2.length()){
    			if(row2.charAt(row2Index + 1) != '1' && row2.charAt(row2Index + 2) != '1'){
    				answer = answer || f(row1Index, row2Index + 2,count + 2);
    			}
    		}
    		// brown Dominos
    		if(row1Index == row2Index + 1){
    			if(row2Index + 1 < row2.length() && row1Index + 1 < row1.length()){
    				if(row2.charAt(row2Index + 1) != '1' && row1.charAt(row1Index + 1) != '1'){
    					answer = answer || f(row1Index + 1,row2Index + 1,count + 2);
    				}
    			}
    		}
            mimoize.put(row1Index+"+"+row2Index+"+"+count,answer);
    		return answer;
    	}
    }
    }
}





