package Hiya;

import java.util.*;


public class Solution {
	static List<Integer> inputs;
	static HashMap<String,Integer> jumpCountMap =new HashMap<String,Integer>();
	static HashMap<String,String> subResultsMimoization =new HashMap<String,String>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        inputs = new ArrayList<Integer>();
        int size = 12;
        while(size-->0){
        //while(in.hasNext()){
        	inputs.add(in.nextInt());
        }
        jumpCountMap = new HashMap<String,Integer>();
        subResultsMimoization = new HashMap<String,String>();
        System.out.println(f("",0,0));
        in.close();
    }
    public static String f(String indeces ,int currentPosition, int jumpCount){
    	if(subResultsMimoization.containsKey(currentPosition + "+" + jumpCount)){
    		return subResultsMimoization.get(currentPosition + "+" + jumpCount);
    	}
    else{
    	if(currentPosition >= inputs.size()){
    		jumpCountMap.put(indeces+", "+"out", jumpCount);
    		return indeces+", "+"out";
    	}else{
    		String result = "";
	    	int flightPower = inputs.get(currentPosition);	
	    	for(int i = flightPower;i >0 ; i-- ){
	    		if(inputs.get(currentPosition) != 0){
	    		String temp = f( (indeces.equals("")) ?  currentPosition+"" : (indeces + ", " +currentPosition),currentPosition+i , jumpCount + 1);
	    		if(result.equals("")){
	    			result = temp;
	    		}else{
	    			if(!temp.equals("failure")){
	    				if(jumpCountMap.containsKey(result) && jumpCountMap.get(temp) < jumpCountMap.get(result)){
	    					result = temp;
	    				}
	    			}
	    		}
	    		}
	    	}
	    	result = (result.equals("")) ? "failure" : result;
	    	subResultsMimoization.put(currentPosition + "+" + jumpCount,result);
	    	return result;
    	}
    }
    }
}


/*




2
1
9
0
2
3
4
0
8
6
5
2
6
9
3
2
1
9
6
1
3
0
1
8
2
3
1
0
2
3
0
2
1
9
0
2
3
4
0
8
6
5
2
6
9
3
2
1
9
6
1
3
0
1
8
2
3
1
0
2
3
0
2
1
9
0
2
3
4
0
8
6
5
2
6
9
3
2
1
9
6
1
3
0
1
8
2
3
1
0
2
3
0
2
1
9
0
2
3
4
0
8
6
5
2
6
9
3
2
1
9
6
1
3
0
1
8
2
3
1
0
2
3
0
*/