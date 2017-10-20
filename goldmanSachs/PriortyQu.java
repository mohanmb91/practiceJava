package goldmanSachs;

import java.util.*;

public class PriortyQu {
	public static void main(String args[]){
		PriorityQueue<Integer> frontier = new PriorityQueue<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2){
					return 1;
				}else if(o1 < o2){
					return -1;
				}
				return 0;
			}
			
		});
		for(int i=1; i <= 10; i++){
			frontier.add(i);
		}
		System.out.println("=======================> ascending");
		print(frontier);
		System.out.println();
		for(int i=10; i >= 1; i--){
			frontier.add(i);
		}
		System.out.println("=======================> descending");
		print(frontier);
	}
	public static void print(PriorityQueue<Integer> frontier){
		while(!frontier.isEmpty()){
			System.out.print(frontier.poll() + "	");
		}
	}
}
