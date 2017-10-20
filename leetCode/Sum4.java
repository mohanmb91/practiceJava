package leetCode;

import java.util.HashMap;

public class Sum4 {
	enum arrayEnum{
		A,B,C,D,END
	}
	static HashMap<String, Integer> mimoize = new HashMap<String, Integer>();
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	if(A.length > 1){
    		return fourSumCountHelper(A,B,C,D,0,arrayEnum.A);
    	}else if(A.length == 1){
    		return (A[0]+B[0]+C[0]+D[0]) == 0 ? 1: 0; 
    	}
    	return 0;
    }

	private int fourSumCountHelper(int[] a, int[] b, int[] c, int[] d, int sum, arrayEnum arrayState) {
		int result = 0;
		if(arrayState == arrayEnum.END && sum == 0){
			return 1;
		}
		else if(arrayState == arrayEnum.END && sum != 0){	
			return 0;
		}
		else if(mimoize.containsKey(arrayState.ordinal() + "+" + sum)){
			return mimoize.get(arrayState.ordinal() + "+" + sum);
		}
		else{
			for(int i=0;i<a.length; i ++){
				if(arrayState == arrayEnum.A){
					result = result + fourSumCountHelper(a, b, c, d, sum + a[i], arrayEnum.B);
				}
				else if(arrayState == arrayEnum.B){
					result = result + fourSumCountHelper(a, b, c, d, sum + b[i], arrayEnum.C);
				}
				else if(arrayState == arrayEnum.C){
					result = result + fourSumCountHelper(a, b, c, d, sum + c[i], arrayEnum.D);
				}
				else if(arrayState == arrayEnum.D){
					result = result + fourSumCountHelper(a, b, c, d, sum + d[i], arrayEnum.END);
				}
			}
			if(!mimoize.containsKey(arrayState.ordinal() + "+" + sum)){
				mimoize.put(arrayState.ordinal() + "+" + sum, result);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Sum4 obj = new Sum4();
		System.out.println(obj.fourSumCount(new int[]{-1,-1} ,new int[]{-1,1}, new int[]{-1,1}, new int[]{1,-1}));

	}

}
