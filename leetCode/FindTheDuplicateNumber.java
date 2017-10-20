package leetCode;

public class FindTheDuplicateNumber {
	
	    public int findDuplicate(int[] a) {
	    
	    	int index = a[0];
	    	
	    	while(a[Math.abs(index)] > 0){
	    		if(a[Math.abs(index)] > 0){
	    			a[Math.abs(index)] = -1 * a[Math.abs(index)];
	    		}
	    		index = a[Math.abs(index)];
	    	}
	    	
	        return Math.abs(index);
	    }
	    
	    public static void main(String args[]){
	    	FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
	    	System.out.println(obj.findDuplicate(new int[]{6,8,}));
	    }
	
}
