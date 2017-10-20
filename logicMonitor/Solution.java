package logicMonitor;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pointer{
    int i,j,value;
    Pointer(int i, int j,int value){
        this.i = i;
        this.j = j;
        this.value = value;
    }
}
class Checker implements Comparator<Pointer>{
	public int compare(Pointer p1, Pointer p2){
		if(p1.value < p2.value){
			return -1;
		}else if(p1.value == p2.value){
			return 0;
		}
		return 1;
	}
}
public class Solution {
    public static int kthSmallest(int[][] matrix, int k) {
    	int n= matrix.length,result = 0,kIndex = 0;
    	PriorityQueue<Pointer> froniter = new PriorityQueue<>(new Checker());
    	for(int i =0; i < n; i ++){
    		froniter.add(new Pointer(0, i, matrix[0][i]));
    	}
    	while(!froniter.isEmpty()){
    		Pointer current = froniter.poll();
     		kIndex += 1;
    		if(k == kIndex){
    			result = current.value;
    			break;
    		}
    		if(current.i + 1 < n){
    			froniter.add(new Pointer(current.i+1, current.j, matrix[current.i+1][current.j]));
    		}
    	}
    	return result;
    }

	
	public static void main(String args[]){
		int matrix[][]= {{1,4,7,11,15},
						{2,5,8,12,19},
						{3,6,9,16,22},
						{10,13,14,17,24},
						{18,21,23,26,30}};
		
		int a = kthSmallest(matrix,5);
	}
}