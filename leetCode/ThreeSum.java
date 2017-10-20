package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	 public static List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> results = new ArrayList<List<Integer>>();
	        Arrays.sort(nums);
	        if(nums.length == 3 ){
	        	if(nums[0] + nums[1] + nums[2] == 0){
	        		List<Integer> temp = new ArrayList<>();
	        		temp.add(nums[0]);
	        		temp.add(nums[1]);
	        		temp.add(nums[2]);
	        		results.add(temp);
	        		return results;
	        	}
	        	return results;
	        }
	        for(int start =0; start < nums.length-3; start ++){
	            if(start == 0 || nums[start-1] < nums[start]){
	                int runner = start + 1;
	                int end = nums.length-1;
	                while(runner < end){
	                    int sum = nums[start] + nums[runner] + nums[end];
	                    if(sum == 0){
	                        List<Integer> temp = new ArrayList<Integer>();
	                        temp.add(nums[start]);
	                        temp.add(nums[runner]);
	                        temp.add(nums[end]);
	                        results.add(temp);
	                    }
	                    if(sum >= 0){
	                        int currentEnd = end;
	                        while(nums[currentEnd] == nums[end] && runner < end){
	                            end --;
	                        }
	                    }else{
	                        int currentRunner = runner;
	                        while(nums[currentRunner] == nums[runner] && runner < end){
	                            runner ++;
	                        }
	                    }
	                }
	            }
	        }
	        return results;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		threeSum(new int[]{0,0,0,0});
	}

}
