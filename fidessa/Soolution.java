package fidessa;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Soolution {
	
	static int findMinGates(int[] arrival, int[] depatures, int flights){
		int result = 0;
		 PriorityQueue<String> frontier = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String flightTimes[] = o1.split("-");
				String flightTimes2[] = o2.split("-");
				int flight1Time = Integer.parseInt(flightTimes[0]);
				int flight2Time = Integer.parseInt(flightTimes2[0]);
				if(flight1Time < flight2Time){
					return -1;
				}else if(flight1Time > flight2Time){
					return 1;
				}
				return 0;
			}
			 
		});
		 
		 
		 for(int i=0;i<flights; i++){
			 frontier.add(arrival[i]+"-"+"{");
			 frontier.add(depatures[i]+"-"+"}");
		 }
		 int minNoGates = 0;
		 while(!frontier.isEmpty()){
			 String current = frontier.poll();
			 if(current.split("-")[1].equals("{") ){
				 result += 1;
			 }else{
				 result -= 1;
			 }
			 if(minNoGates < result){
				 minNoGates = result;
			 }
		 }
		 return minNoGates;
		
	}
	public static void main(String[] args) {
		int arrival[] = new int[]{900,
				910,
				920
};
		int depature[] = new int[]{930,
				915,
				925
				};
		System.out.println(findMinGates( arrival, depature, 3));
	}

}

