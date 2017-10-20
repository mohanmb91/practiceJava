package DP;
import java.util.*;

public class SherlockAndCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-->0){
			int N = in.nextInt();
			int b[] = new int[N];
			for(int i=0; i < N; i ++){
				b[i] = in.nextInt();
			}
			
			long[][] dp = new long[2][N];
			for (int j = 1; j < N; j++) {
				long previous = dp[0][j - 1];
				long previous1 = dp[1][j - 1];
				long bothMax = Math.abs(b[j] - b[j - 1]);
				long currentMaxPreviousMin = Math.abs(b[j] - 1);
			    dp[0][j] = Math.max( previous + bothMax ,
			    		previous1 + currentMaxPreviousMin);
			
			    long previousMaxCurrentMin = Math.abs(b[j - 1] - 1);
			    long bothMin = Math.abs(1 - 1);
			    dp[1][j] = Math.max(dp[0][j - 1] + previousMaxCurrentMin,
			    		previous1 + bothMin);
			}
			System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
		}
		
		in.close();
	}

}
