package weekofcode31;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int[] sequence = new int[n];
            int start = -1,end = -1;
            boolean isAliceTurn = true;
            for(int sequence_i=0; sequence_i < n; sequence_i++){
                sequence[sequence_i] = in.nextInt();
                if(start == -1){
                	if(sequence[sequence_i] == 0){
                		start = sequence_i;
                	}
                }else{
                	if(sequence_i >= (start + 2)){
                		int current = sequence[sequence_i];
                		int previous = sequence[sequence_i-1];
                		if(current == 1 && previous == 1){
                			end = sequence_i-2;
                			isAliceTurn = findTurns(end,start,isAliceTurn);
                			start = -1;
                			end = -1;
                		}
                	}
                }
            }
            if(end == -1){
            	if(n-2 >= 0){
	        		int previous = sequence[n-2];
	        		if(previous == 0) end = n-2;
            	}
            	int current = sequence[n-1];
            	if(current == 0) end = n-1;
            	isAliceTurn = findTurns(end,start,isAliceTurn);
            }
            // If Alice wins, print 'Alice' on a new line; otherwise, print 'Bob'
            if(isAliceTurn){
            	System.out.println("Bob");
            }else{
            	System.out.println("Alice");
            }
            
        }
        in.close();
    }
    
	public static boolean findTurns(int end, int start, boolean isAliceTurn) {
    	int turnsWithinRange = end - start + 1 -2; 
		if(turnsWithinRange >=1){
			boolean thisRange = true;
			if(turnsWithinRange % 2 == 1){
				thisRange = false;
			}else{ thisRange = true;}
			if(isAliceTurn){
				return thisRange;
			}else{
				return thisRange ? false : true;
			}
		}
		return isAliceTurn;
    }
}
