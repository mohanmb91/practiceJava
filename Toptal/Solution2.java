package Toptal;

class Solution2 {
	public static void main(String[] args){
		System.out.println(solution("(())()("));
		//   (())()(
	}
	
    public static int solution(String S) {
        // write your code in Java SE 8
    	int oB = 0, cB = 0;
    	for(int i=0;i<S.length(); i++){
    		if(S.charAt(i) == '('){
    			oB +=1;
    		}
    		if(S.charAt(i) == ')'){
    			cB += 1;
    		}
    	}
        int OB = 0;
        for(int i=0;i<S.length(); i++){
        	if(S.charAt(i) == '('){
    			oB -=1;
    			OB+=1;
    		}
    		if(S.charAt(i) == ')'){
    			cB -= 1;
    		}
    		if(OB == cB){
        		return i;
        	}
        }
        return 0;
    }
}