package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import javax.print.attribute.ResolutionSyntax;


	

public class TopKFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> result = new ArrayList<>();
    	HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i < nums.length; i ++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1 );
            }else{
                map.put(nums[i], 1 );
            }
        }
        
        int maxFrequency = 0;
        
        for(Map.Entry<Integer, Integer> eachEntry: map.entrySet()){
        	maxFrequency = Math.max(maxFrequency, eachEntry.getValue());
        }
    	
        ArrayList<Integer>[] arr =  (ArrayList<Integer>[]) new ArrayList[maxFrequency + 1];
        for(int i = 1; i <= maxFrequency; i ++){
        	arr[i] = new ArrayList<Integer>();
        }
        
        
        for(Map.Entry<Integer, Integer> eachEntry: map.entrySet()){
        	arr[eachEntry.getValue()].add(eachEntry.getKey());
        }
        
        for(int i = maxFrequency; i > 0; i --){
        	if(arr[i].size() > 0){
        		result.addAll(arr[i]);
        	}
        	if(result.size() >= k){
        		break;
        	}
        }
    	return result;
    }
    
    public static void main(String args[]){
    	TopKFrequent.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}