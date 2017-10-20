package weekofcode31;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NominatingGroupLeaders {
	

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            int[] v = new int[n];
	            HashMap<Integer,Integer> keys = new HashMap<>();
	            boolean isUpdated[] = new boolean[n];
	            for(int v_i=0; v_i < n; v_i++){
	                v[v_i] = in.nextInt();
	                keys.put(v_i, v_i);
	                
	            }
	            
	            Arrays.sort(v);
	            
	            
	            for(int i= v.length -1 ;i >= 0; i --){
	            	int value = v[i];
	            	if(value == 0){
	            		break;
	            	}
	            	if(!isUpdated[value]){
	            		keys.put(value, i);	
	            		isUpdated[value] = true;
	            	}
	            }
	            
	            for(int i= 0 ;i < v.length; i ++){
	            	int value = v[i];	
	            	if(!isUpdated[i]){
	            		keys.put(i, keys.get(value));
	            		isUpdated[value] = true;	
	            	}
	            }
	            
	            
	            int g = in.nextInt();
	            for(int a1 = 0; a1 < g; a1++){
	                int l = in.nextInt();
	                int r = in.nextInt();
	                int x = in.nextInt();
	                int left = keys.get(l);
	                int right = keys.get(r);
	                int count = 0;
	                int currentNo = v[left];
	                int searchStudent = -1;
	                if(x != 0){
		                for(int i = left; i <= right; i ++){
		                	if(v[i] == currentNo){
		                		count ++;
		                	}else{
		                		if(count == x){
		                			searchStudent = currentNo;
		                			break;
		                		}else{
		                			currentNo = v[i];
		                			count = 0;
		                			count ++;
		                		}
		                	}
		                }
	                }else{
	                	searchStudent = searchStudentWithNoVotes(left,right,v);
	                }
	                System.out.println(searchStudent);
	            }
	        }
	    }

		private static int searchStudentWithNoVotes(int left, int right, int[] v) {
			int searchStudent = -1;
			if(v[0] != 0){
				return 0;
			}
			for(int i =0;i< v.length-2; i++){
				if(!(v[i] == v[i+1] || (v[i]+1) == v[i+1])){
					searchStudent = v[i]+1;
					break;
				}
			}
			
			return searchStudent;
		}

		private static int binarySearchRightIndex(int searchKey, int[] v) {
			int middle = v.length / 2;
			int start = 0;
			int end = v.length;
			while(v[middle] != searchKey){
				if(v[middle] > searchKey){
					end = middle;
					middle = (end - start) / 2;
				}else{
					start = middle;
					middle = middle + (end - start ) / 2;
				}
			}
			while(middle < v.length-2 && v[middle] == searchKey){
				if(v[middle + 1] == searchKey){
					middle ++;
				}else{
					break;
				}
			}
			return middle;
		}

		private static int binarySearchLeftIndex(int searchKey, int[] v) {
			int middle = v.length / 2;
			int start = 0;
			int end = v.length;
			while(v[middle] != searchKey){
				if(v[middle] > searchKey){
					end = middle;
					middle = (end - start) / 2;
				}else{
					start = middle;
					middle = (end - start ) / 2;
				}
			}
			while(middle > 0 && v[middle] == searchKey){
				if(v[middle - 1] == searchKey){
					middle --;
				}else{
					break;
				}
			}
			return middle;
		}
	}


