package main;

import java.util.Scanner;

public class LongestCommonSubsequence {
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner in = new Scanner(System.in);
	        
	        int firstLength = in.nextInt();
	        int secondLength = in.nextInt();
	        int c[][] = new int[firstLength+1][secondLength+1];
	        String first = "",second = "";
	        for(int i = 0 ; i< firstLength; i ++){
	              first = first + String.valueOf(in.nextInt());
	        }
	        first = " " + first;
	        for(int i=0; i < secondLength; i++){
	            second = second + String.valueOf(in.nextInt());
	        }
	        second = " " + second;
	        //1 2 3 4 1
	        //3 4 1 2 1 3
	        for(int i = 1; i <=firstLength ; i ++ ){
	            for(int j= 1; j<= secondLength ; j++){
	                if(first.substring(i,i+1).equals(second.substring(j,j+1))){
	                    c[i][j] = c[i-1][j-1] +1;
	                }else{
	                    c[i][j] = Math.max(c[i-1][j],c[i][j-1]);
	                }
	            }
	        }
	        int row = first.length() -1;String result = "";
	        for(int column = second.length() -1;column >= 0;){
	        	if(column == 0 || row == 0){
	        		break;
	        	}
	        	if(c[row][column] == c[row - 1][column]){
	        		row = row-1;
	        	}else if(c[row][column] == c[row][column-1]){
	        		column = column -1;
	        	}else{
	        		result =   second.substring(column, column+1)+" "+result;
	        		//System.out.print(c[row][column]+ " ");
	        		column = column -1;
	        		row = row-1;
	        	}
	        	
	        }
	        System.out.println(result);
	        in.close();
	    }
}
