package main;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class ExtraLong {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        BigInteger result = new BigInteger("1");
        while(n.compareTo(new BigInteger("0")) != 0 ){
        	result =  result.multiply(n);
        	n = n.subtract(new BigInteger("1"));
        }
        System.out.println(result.toString());
        in.close();
    }
}