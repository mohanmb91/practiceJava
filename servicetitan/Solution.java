package servicetitan;
import java.io.*;
import java.util.*;



public class Solution {

    public static void main(String[] args) {


        String[] strings = new String[]{
                "10000",
                "01000",
                "00100",
                "00010",
                "00001"

        };

        int count = zombieCluster(strings);
        System.out.println(count);
    }


    static int zombieCluster(String[] zombies) {
    	boolean isZombieConntected [][] = new boolean[zombies.length][zombies.length];
    	int result = 0;
    	HashSet<String> connections = new HashSet<String>();
    	for(int i=0;i<zombies.length; i++){
    		String zombieRow = zombies[i];
    		for(int j=0; j < zombieRow.length(); j ++){
    			if(zombieRow.charAt(j) == '1'){
    				isZombieConntected[i][j]= true;
    				connections.add(i+"+"+j);
    			}
    		}
    	}
    	
    	for(String eachZombie: connections ){
    		int row = Integer.parseInt(eachZombie.split("\\+")[0]);
    		int col = Integer.parseInt(eachZombie.split("\\+")[1]);
    		if(isZombieConntected[row][col]){
    		dfs(eachZombie,isZombieConntected,zombies);
    		result += 1;
    		}
    	}
    	
    	return result; 
    }


	private static void dfs(String eachZombie, boolean[][] isZombieConntected,String[] zombies ) {
		int row = Integer.parseInt(eachZombie.split("\\+")[0]);
		
		String zombieRow = zombies[row];
		isZombieConntected[row][row] = false;
		for(int j=0;j<zombieRow.length();j ++){
			
			if(isZombieConntected[row][j]){
				isZombieConntected[row][j] = false;
				dfs(j+"+"+row,isZombieConntected,zombies);
			}
		}
	}

   
}