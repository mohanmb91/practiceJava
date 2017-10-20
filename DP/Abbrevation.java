package DP;



import java.util.*;

public class Abbrevation {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int querys = in.nextInt();
        while(querys-->0){
        	
        }
        in.close();
    }

	private static String recursiveAbbrevation(String a, String b, int currentIndexOfB,String formedString) {
		
		if(formedString.equals(b) && a.equals("")){
			return "YES";
		}else if(formedString.equals(b) && !a.equals("")) {
			for(int i=0; i<a.length(); i ++){
				int ascii =(int)a.charAt(i);
				if(!(ascii >= 97 && ascii <= 122)){
					return "NO";
				}
			}
			return "YES";
		}else{
		String result = "";
		return result;
		}
	}
   

    
}



/*
YES
NO
NO
NO <==
YES
NO
NO
NO
YES
NO <==
HIFuOPyb
HIFOP
*/


/*
YES
NO
NO
NO <==
YES
NO
NO
NO
YES
NO <==
HIFuOPyb
HIFOP

ERreEer
ERRER

*/