package weekofcode33;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Element{
    int index;
    int value;
    public Element(int i, int e){
        this.index = i;
        this.value = e;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar1 = new int[n];
        Element first1 = new Element(-1,Integer.MAX_VALUE);
        Element second1 = new Element(-1,Integer.MAX_VALUE);
        Element first2 = new Element(-1,Integer.MAX_VALUE);
        Element second2 = new Element(-1,Integer.MAX_VALUE);
        int index = 0;
        
        for(int ar1_i = 0; ar1_i < n; ar1_i++){
            ar1[ar1_i] = in.nextInt();
           if (ar1[ar1_i] < first1.value)
            {
                second1 = new Element(first1.index,first1.value);
                first1.value = ar1[ar1_i];
                first1.index = ar1_i;
            }else if (ar1[ar1_i] < second1.value){
                second1.value = ar1[ar1_i];
            	second1.index = ar1_i;
            }
        }
        int min2 = Integer.MAX_VALUE;
        int[] ar2 = new int[n];
        for(int ar2_i = 0; ar2_i < n; ar2_i++){
            ar2[ar2_i] = in.nextInt();
            if (ar2[ar2_i] < first2.value)
            {
                second2 = new Element(first2.index,first2.value);
                first2.value = ar2[ar2_i];
                first2.index = ar2_i;
            }else if (ar2[ar2_i] < second2.value ){
                second2.value = ar2[ar2_i];
            	second2.index = ar2_i;
            }
        }
        int minValue = Integer.MAX_VALUE;
        //first Possible
        if(first1.index != first2.index){
        if(minValue > (first1.value + first2.value)){
        	minValue = first1.value + first2.value;
        }
        }else{
        	int fp1 = first1.value + second2.value;
        	int fp2 = first2.value + second1.value;
        	if(fp1 < fp2){
        		minValue = fp1;
        	}else{
        		minValue = fp2;
        	}
        }
        
        
        System.out.println(minValue);
    }
}
