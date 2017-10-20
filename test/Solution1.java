package test;

import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            boolean[] included = new boolean[n+1];
            HashSet<Integer> primeMap = new HashSet<Integer>();
            for(int i =2; i <= n; i++){
            	if(!included[i]){
                	primeMap.add(i);
                	int multiples = i+ i;
                	while(multiples <=n){
                		included[multiples] = true;
                		multiples += i;
                	}
            	}
            }
            
            if(primeMap.size() % 2 == 0) System.out.println("Bob");
            else System.out.println("Alice");
        }
        in.close();
    }
}