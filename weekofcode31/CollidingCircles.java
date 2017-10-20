package weekofcode31;
import java.util.*;
public class CollidingCircles {
	static int noOfterminalState = 0;
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] r = new int[n];
        for(int r_i=0; r_i < n; r_i++){
            r[r_i] = in.nextInt();
        }
        Arrays.sort(r);
        int minFixed = n-k;
        noOfterminalState = 0;
        double total = collidingCirclesDP(r,-1,0,0,false,-1,r.length,minFixed,0);
        total = total/noOfterminalState;
        System.out.println(total);
        in.close();
    }

	public static double collidingCirclesDP(int[] a,int index, long sum, double totalSum , boolean isCarryForward, int isFixed, int length,int minFixed,int isFixedCount) {
		double result = 0.0;
		if(isFixedCount == minFixed && index != a.length -1 ){ 
			return Double.valueOf("0");
		}
		if(index == a.length -1){
			if(isFixedCount < minFixed){
				return Double.valueOf("0");
			}else{
				noOfterminalState += 1;
				System.out.println(totalSum + circleArea(a[index] + sum));
				return totalSum + circleArea(a[index] + sum);	
			}  
		}
		else if(index < a.length){
			if(isFixed == 0){// not Fixed
				if(!isCarryForward){
					if(index+1 != a.length -1){
						result += collidingCirclesDP(a, index + 1, sum + a[index], totalSum,((length -1) <= minFixed) ? true: false, 0, length-1, minFixed,isFixedCount);
					}
					result += collidingCirclesDP(a, index + 1,  sum + a[index], totalSum, false, 1, length-1, minFixed,isFixedCount+1);
				}else{
					if(index+1 != a.length -1){
						result += collidingCirclesDP(a, index + 1, sum, totalSum + circleArea(a[index]), true, 0, length-1, minFixed,isFixedCount);
					}
					result += collidingCirclesDP(a, index + 1, sum, totalSum + circleArea(a[index]), false, 1, length-1, minFixed,isFixedCount+1);
				}
			}else if(isFixed == 1){ // fixed
				if(index+1 != a.length -1){
					result += collidingCirclesDP(a, index + 1, 0, totalSum + circleArea(a[index] + sum), false, 0, length-1, minFixed,isFixedCount);
				}
				result += collidingCirclesDP(a, index + 1, 0, totalSum + circleArea(a[index] + sum), false, 1, length-1, minFixed,isFixedCount+1);
			}else{
				result += collidingCirclesDP(a, index + 1, sum , totalSum, false, 0, length, minFixed,isFixedCount);
				result += collidingCirclesDP(a, index + 1, sum , totalSum, false, 1, length, minFixed,isFixedCount+1);
			}
		}
		return result;
	}
	public static double circleArea(long radius){
		return Math.PI * radius * radius;
	}
}
