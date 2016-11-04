package main;

import java.util.Random;
import java.util.Scanner;

public class HeapSort {
	static int heapSize;
	//static int a[];
	public void buildHeap(int a[]){
		for(int i = heapSize/2; i >= 0; i --){
			heapMaxify(a,i);
		}
		heapSort(a);
	}
	public void heapMaxify(int a[],int i) {
		int left = 2*i + 1;
        int right = 2*i + 2;
        int max = i;
        if (left <= heapSize && a[left] > a[i])
            max = left;
        if (right <= heapSize && a[right] > a[max])        
            max = right;
        
        if(i != max){
        	int temp = a[i];
        	a[i] = a[max];
        	a[max] = temp;
        	heapMaxify(a, max);
        }
        
	}
	
	public void heapSort(int[] a){
		while(heapSize > 0){
			int temp = a[0];
			a[0] = a[heapSize];
			a[heapSize] = temp;
			heapSize --;
			heapMaxify(a, 0);
			
		}
	}
public static void main(String args[]) {
	Scanner scan = new Scanner(System.in);
	System.out.println("enter Size of the array");
	int size = scan.nextInt(); 
	int a[] = new int[size];
	heapSize = a.length - 1;
	for(int i =0; i < size; i ++){
		a[i] = (int) (Math.random() * 100);
	}
	
	System.out.println("array to be sorted");
	
	for(int i =0; i < size; i++){
		System.out.print(" "+ a[i]);
	}
	HeapSort sort = new HeapSort();
	sort.buildHeap(a);
	System.out.println();
	System.out.println("maxheapify done");
	
	System.out.println("array after sorting");
	for(int i =0; i < size; i++){
		System.out.print(" "+ a[i]);
	}
}
}
