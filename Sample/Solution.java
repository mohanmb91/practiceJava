package Sample;


import java.util.*;

public class Solution {
	static int N;static int T;
	static HashMap<String, Integer> memoize = new HashMap<String,Integer>();
	static int primeCount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		while(T-->0){
			N = in.nextInt();	
			int combinations = f(""); 
			memoize = new HashMap<String,Integer>();
			for(int i=2;i<=combinations;i++){
				if(isPrime(i)){
					primeCount +=1;
				}
			}
			System.out.println(primeCount);
			primeCount = 0;
		}
		in.close();
	}
	private static int f(String bricks) {
		if(bricks.length() == N){
			return 1;
		}else if(bricks.length() > N){
			return 0;
		}else{
			if(memoize.containsKey(bricks)){
				return memoize.get(bricks);
			}else{
				int answer = 0;
				int temp =0;
				if(bricks.length() < N)
					answer = answer + f(bricks+"1");
				if(bricks.length() + 4 <= N)
					answer = answer + f(bricks+"0000");
				memoize.put(bricks,answer);
				return answer;
			}
		}
	}
	private static boolean isPrime(int answer) {
		for(int i =2;i <= Math.sqrt(answer);i++){
			if(answer % i == 0){return false;}
		}
		return true;
	}

}
