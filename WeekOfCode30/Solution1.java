package WeekOfCode30;

import java.util.*;
class Stack{
	int x;
	int w;
	public Stack(int x, int w){
		this.x = x;
		this.w = w;
	}
}
public class Solution1 {
	static int n;
	static int k;
	static int count =0;
	static HashMap<String, Integer> mimoize = new HashMap<String, Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack[] stacks;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		stacks = new Stack[n];
		k = in.nextInt();
		int altitueSum = 0;
		for(int i=n-1;i >=0;i --){
			int altitude = in.nextInt();
			int weight = in.nextInt();
			stacks[i] = new Stack(altitude,weight);
			altitueSum += altitude;
		}
		System.out.println(findMinimum(stacks,0,n,0,altitueSum));
		System.err.println(count);
		in.close();
	}
	public static int findMinimum(Stack[] stacks,int totalCost,int noOfStacks,int top,int totalAltitude ){
		count ++;
		if(mimoize.containsKey(totalAltitude+""+totalCost)){
			return mimoize.get(totalAltitude+""+totalCost);
		}
		else{
			if(noOfStacks == k){
				return totalCost;
			}else{
				int result = Integer.MAX_VALUE;
				while(top < n -1){
					Stack topPole = stacks[top];	
					Stack bottomPole = stacks[top+1];
					int cost = (topPole.x - bottomPole.x)* topPole.w;
					bottomPole.w += topPole.w;
					stacks[top+1] = bottomPole;
					result= Math.min(result, findMinimum(stacks, totalCost+cost, noOfStacks - 1,top + 1,(totalAltitude - topPole.x) ));
					bottomPole.w -= topPole.w;
					stacks[top+1] = bottomPole;
					stacks[top] = topPole;	
					top += 1;
					}
				mimoize.put(totalAltitude+""+totalCost, result);
				return result;
			}
		}
	}
}
/*
5 2
5 1
10 1
25 1
35 1
50 1

3 1
20 1
30 1
40 1
*/