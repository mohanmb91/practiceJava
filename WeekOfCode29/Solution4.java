package WeekOfCode29;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long first = in.nextLong();
        long last = in.nextLong();
        int count = 0;
        HashSet<Character> primes = new HashSet<Character>();
        primes.add('2');primes.add('3');primes.add('5');primes.add('7');
        for(long i = first; i <= last; i ++){
            String input = String.valueOf(i);
            boolean isMegaPrime = true;
        	for(int j=0;j<input.length();j++){
                if(!primes.contains(input.charAt(j))){
                	isMegaPrime = false;
                	break;
                }
            }	
        	if(isMegaPrime){
        		if(isPrime(i)){
        			count += 1;
            	}
        	}
        }
        System.out.println(count);
        in.close();
    }

	private static boolean isPrime(long num) {
		    if ( num > 2 && num%2 == 0 ) {
		        return false;
		    }
		    
		    for(long i = 3; i <= Math.sqrt(num); i+=2){
		        if(num % i == 0){
		            return false;
		        }
		    }
		    return true; 
	}
}
