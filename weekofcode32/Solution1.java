package weekofcode32;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class CurrentState{
	int jumpMade;
	int currentIndex;
	public CurrentState(int jumpMade,int currentIndex){
		this.jumpMade = jumpMade;
		this.currentIndex = currentIndex;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentIndex;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrentState other = (CurrentState) obj;
		if (currentIndex != other.currentIndex)
			return false;
		return true;
	}
}
public class Solution1 {
	static HashSet<Integer> unVisitedNodeIndex = new HashSet<Integer>();
	static HashSet<Integer> visitedNodeIndex = new HashSet<Integer>();
    static int R[];
    static int circularWalk(int n, int start, int end, int r_0, int g, int seed, int p){
    	if(start == end){
    		return 0;
    	}
    	unVisitedNodeIndex.add(0);
        for(int i=1;i<n;i++){
            R[i] = getRValue(i,g,seed,p);
            unVisitedNodeIndex.add(i);
            if(i == start){
            	if(R[i] == 0){
            		return -1;
            	}
            }
        }
        
        Queue<CurrentState> frontier = new LinkedList<CurrentState>();
        frontier.add(new CurrentState(0, end));
        while(! frontier.isEmpty()){
        	CurrentState current = frontier.poll();
        	unVisitedNodeIndex.remove(current.currentIndex);
        	visitedNodeIndex.add(current.currentIndex);
        	for(int eachUnVisitedNodeIndex: unVisitedNodeIndex){
        		if(isInRange(eachUnVisitedNodeIndex,current) && ! visitedNodeIndex.contains(eachUnVisitedNodeIndex)){ 
        			visitedNodeIndex.add(eachUnVisitedNodeIndex);
        			CurrentState temp = new CurrentState(current.jumpMade + 1, eachUnVisitedNodeIndex);
        			if(temp.currentIndex == start){
        				return temp.jumpMade;
        			}
        			frontier.add(temp);
        		}
        	}
        }
        
        return -1;
    }

	private static boolean isInRange(int eachUnVisitedNodeIndex, CurrentState current) {
		int jumpValue = R[eachUnVisitedNodeIndex];
		if(jumpValue == 0){
			return false;
		}
		if(jumpValue >= (R.length -1)/2 ){
			return true;
		}
		int clockWiseMaxRange = eachUnVisitedNodeIndex + jumpValue;
		if(clockWiseMaxRange > R.length -1){
			clockWiseMaxRange = clockWiseMaxRange % R.length;
		}
		if(current.currentIndex <= clockWiseMaxRange ){
			if(eachUnVisitedNodeIndex > clockWiseMaxRange){
				return true;
			}else{
			if(current.currentIndex >=eachUnVisitedNodeIndex){
				return true;	
			}
			}
		}
		int antiClockWiseMaxRange = eachUnVisitedNodeIndex - jumpValue;
		if(antiClockWiseMaxRange < 0){
			antiClockWiseMaxRange = antiClockWiseMaxRange % R.length;
			antiClockWiseMaxRange = R.length + antiClockWiseMaxRange;
		}
		if(current.currentIndex >= antiClockWiseMaxRange ){
			if(eachUnVisitedNodeIndex < antiClockWiseMaxRange){
				return true;
			}else{
			if(current.currentIndex <=eachUnVisitedNodeIndex){
				return true;	
			}
			}
		}
		if(antiClockWiseMaxRange <= current.currentIndex){
			return true;
		}
		return false;
	}

	static int getRValue(int i,int g,int seed,int p){
        return ((R[i-1]*g) + seed) % p;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        R = new int[n];
        int s = in.nextInt();
        int t = in.nextInt();
        int r_0 = in.nextInt();
        R[0]= r_0;
        int g = in.nextInt();
        int seed = in.nextInt();
        int p = in.nextInt();
        int result = circularWalk(n, s, t, r_0, g, seed, p);
        System.out.println(result);
        in.close();
    }
}