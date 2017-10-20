package leetCode;

import java.util.TreeMap;

public class MostWater {
    public int maxArea(int[] h) {
        int maxOne = 0,maxTwo = 0,maxOneIndex = -1,maxTwoIndex = -1;
        
           
        for(int i=0;i<h.length;i++){
        	 if(maxOne < h[i]){
                 maxTwo = maxOne;
                 maxOne =h[i];
                 maxTwoIndex = maxOneIndex;
                 maxOneIndex = i;
             } else if(maxTwo < h[i]){
                 maxTwo = h[i];
                 maxTwoIndex = i;
             }
        }
        int maxArea = 0;
        for(int i=0;i<h.length;i++){
            if(i != maxOneIndex){
                int tempArea = Math.min(maxOne,h[i]) * Math.abs(i - maxOneIndex);
                if(tempArea > maxArea){
                	maxArea = tempArea;
                }
            }
            if(i != maxTwoIndex){
                int tempArea = Math.min(maxTwo,h[i]) * Math.abs(i - maxTwoIndex);
                if(tempArea > maxArea){
                	maxArea = tempArea;
                }
            }
        }
        return maxArea;
    }
    public static void main(String args[]){
    	MostWater obj =  new MostWater();
    	System.out.println(obj.maxArea(new int[]{1,2,1}));
    }
}