package Need;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T > 0){
            int n = in.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
               a[i] = in.nextInt();
            }
            int counter[] = new int[n];
            
            for(int i=0;i<n;i++){
                int count = 0;
                for(int j=0;j<n;j++){
                    if(a[j] >= a[i]){
                        count += 1;
                    }
                }
                counter[i] = count;
            }
            BigDecimal result = new BigDecimal("0.0");
            for(int i=0;i<n;i++){
            	double k = counter[i]+1.0;
            	double N = (n+1);
            	double resultF = N/k;
                result = result.add( new BigDecimal(resultF)) ;
            }
             
            System.out.println( result.setScale(2, RoundingMode.HALF_DOWN) );
            T--;
        }
        in.close();
    }
    
}