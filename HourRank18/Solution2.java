package HourRank18;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
	static HashMap<String, Integer> memoize = new HashMap<String,Integer>();
	static String s;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        s = in.next();
        int count =0;
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i) == '0')count +=1;
        	else count = count + f(i,0);
        }
        System.out.println(count);
        in.close();
    }

	private static int f(int i, int m) {
		if(i >= s.length()){
			return 0;
		}else{
			if(memoize.containsKey(i+"+"+m) ){
				return memoize.get(i+"+"+m);
			}else{
				int x = (int) s.charAt(i);
				int ans = f(i+1, (m+x) % 3 ) + isDivisible(x,m);
				memoize.put(i+"+"+m, ans);
				return ans;
			}
		}
	}

	private static int isDivisible(int x, int m) {
		if(((m+x) % 3 == 0) && (x % 2 ==0)){
			return 1;
		}
		return 0;
	}
}
