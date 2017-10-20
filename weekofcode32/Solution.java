package weekofcode32;

import java.util.*;


public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        String result = "01";
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            if(result.length()-1 >= x){
                System.out.println(result.charAt(x));
            }else{
                while(result.length()-1 < x){
                    result = result + ~(Integer.parseInt(result));
                }
                System.out.println(result.charAt(x));
            }
        }
        in.close();
    }
}
