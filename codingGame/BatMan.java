package codingGame;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

public class BatMan {


	    public static void main(String args[]) {
	        Scanner in = new Scanner(System.in);
	        int endColumn = in.nextInt(); // width of the building.
	        int endRow = in.nextInt(); // height of the building.
	        int N = in.nextInt(); // maximum number of turns before game over.
	        int startColumn = 0;
	        int startRow = 0;
	        int midColumn = in.nextInt();
	        int midRow = in.nextInt();
	        
	        System.err.println("Max Column Row ====> "+endColumn+" "+endRow);
	        // game loop
	        while (true) {
	            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
	            System.err.println("Bomb Direction "+ bombDir);
	            System.err.println("BatMan Position Before Calculation====> "+midColumn+" "+midRow);
	            if(bombDir.charAt(0) == 'U'){
	                endRow = midRow;
	                System.err.println(endRow + "===>" + startRow + "===>" );
	                midRow = midRow - (int)Math.ceil((double)(endRow - startRow) / 2);
	            }else if(bombDir.charAt(0) == 'D'){
	                startRow = midRow;
	                midRow = midRow + ((endRow - startRow) / 2);
	            }
	            else if(bombDir.charAt(0) == 'L'){
	                endColumn = midColumn;
	                midColumn = midColumn - (endColumn - startColumn) / 2;
	            }else if(bombDir.charAt(0) == 'R'){
	                startColumn = midColumn;
	                midColumn = midColumn + (endColumn - startColumn) / 2;
	            }
	            if(bombDir.length() == 2){
	            if(bombDir.charAt(1) == 'L'){
	                endColumn = midColumn;
	                midColumn = midColumn - (int)Math.ceil((double)(endColumn - startColumn) / 2);
	            }else if(bombDir.charAt(1) == 'R'){
	                startColumn = midColumn;
	                midColumn = midColumn + (endColumn - startColumn) / 2;
	            }
	            }
	            System.err.println("BatMan Position After Calculation====> "+midColumn+" "+midRow);
	            System.out.println(midColumn+" "+midRow);
	        }
	    }
	}
