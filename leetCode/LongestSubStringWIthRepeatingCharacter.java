package leetCode;

import java.util.HashMap;

public class LongestSubStringWIthRepeatingCharacter {
	
	    public static int lengthOfLongestSubstring(String s) {
	        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	        int start = 0, end =0, max =0;
	        if(s.length() == 0 || s.length() == 1){
	            return s.length();
	        }
	        for(int i=0;i<s.length();i ++){
	            end = i;
	            if(!map.containsKey(s.charAt(i))){
	                map.put(s.charAt(i),i);
	            }else{
	                int tempMax = end - start;
	                max = Math.max(max, tempMax);
	                int duplicateIndex = map.get(s.charAt(i));
	                
	                start = duplicateIndex + 1;
	                while(duplicateIndex >= 0){
	                   map.remove(s.charAt(duplicateIndex)); 
	                    break;
	                }
	                map.put(s.charAt(i),i);
	            }
	            
	        }
	        int tempMax = end - start + 1;
	        max = Math.max(max, tempMax);
	        return max;
	    }
	    public static void main(String args[]){
	    	System.out.println(lengthOfLongestSubstring("abcabcbb"));
	    }
	}

