package codeSprint;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    static BigInteger getMagicNumber(String s,int k,BigInteger b,BigInteger m){
        List<String> possibleSubString = new ArrayList<>();
        HashMap<String,BigInteger> mimoize = new HashMap<>();
        for (int i =0 ; i <= s.length() - k; i ++){
        	int end = i+k;
        	if(end > s.length()){
        		end = s.length();
        	}
        	possibleSubString.add(s.substring(i,end));
        }
        BigInteger result = new BigInteger("0");
        for(String eachSubString: possibleSubString){
        	if(mimoize.containsKey(eachSubString)){
        		result = result.add(mimoize.get(eachSubString));
        	}else{
        		BigInteger temp = convertTorequiredBase(eachSubString,b,m);
        		mimoize.put(eachSubString, temp);
        		result = result.add(temp);
        	}
        }
        return result;
    }
    
    static BigInteger convertTorequiredBase(String s,BigInteger b,BigInteger m){
        int start = 0;
        BigInteger result = new BigInteger("0");
        for(int i= s.length() - 1; i >= 0; i --){
        	result = result.add( (b.pow(start)).multiply(new BigInteger(s.charAt(i) + "")) );
            //result = (long) (result + (Math.pow(b,start)  * Long.parseLong(s.charAt(i) + "")));
            start = start + 1;
        }
        result = result.mod(m);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        BigInteger b = in.nextBigInteger();
        BigInteger m = in.nextBigInteger();
        BigInteger result = getMagicNumber(s, k, b, m);
        System.out.println(result.toString());
        in.close();
    }
}
