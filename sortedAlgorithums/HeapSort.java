package sortedAlgorithums;

import java.util.*;

public class HeapSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int array[] = new int[n];
		for(int i =0; i < n ; i ++){
			array[i] = in.nextInt();
		}
		for(int i=(array.length/2)-1;i>=0; i--){
			maxHeapify(array,i,array.length-1);	
		}
		int heapSize = array.length - 1;
		while(heapSize > 0){
			int temp = array[0];
			array[0] = array[heapSize];
			array[heapSize] = temp;
			heapSize --;
			maxHeapify(array, 0,heapSize);
			
		}
		
		for(int i=0;i<n;i ++){
			System.out.println(array[i]);
		}
		in.close();
	}

	private static void maxHeapify(int[] array,int i,int n ){
		// TODO Auto-generated method stub
		
		int parent = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		int max = parent;
		if(left <= n && array[parent] < array[left]){
			max = left;
		}
		if( right <= n && array[max] < array[right] ){
			max = right;
		}
		if(max != parent){
			int temp = array[max];
			array[max] = array[parent];
			array[parent] = temp;
			maxHeapify(array,max,n);
		}
			
		
	}
}
