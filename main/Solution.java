package main;

import java.util.*;

public class Solution {
	static Stack<Integer> phNo = new Stack<Integer>();
	static int i = 0;
	static String phoneNo;
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		
        Scanner scan = new Scanner(System.in);
        
        
        boolean hasplus = false;
        String email;
        String[] emailId;
        String userName,maskedUserName = "",dumphoneNo;
        while(scan.hasNextLine()){
        String input = scan.nextLine();
        if(input.substring(0,2).contains("E")){	
	        
        	email = input;
	        emailId = email.split("@");
	        userName = emailId[0];
	        userName = userName.substring(2);
	        maskedUserName = userName.charAt(0) + generateStars(5) + userName.charAt(userName.length()-1);
	        maskedUserName = "E:" + maskedUserName +"@"+ emailId[emailId.length -1];
	        System.out.println(maskedUserName);
	        
        }else{
       
	        i=0;
	        dumphoneNo = input;
	        hasplus = dumphoneNo.contains("+");
	        phoneNo = "";
	        getPhoneNo(dumphoneNo);
	        System.out.println(getMaskedPhNo(hasplus));
	       
        }
        }
        scan.close();
        
    }
	private static String getMaskedPhNo(boolean hasplus) {
		String maskedPhNo = "";
		int countryCodeLength =0;
		if(phoneNo.length() <= 10){
        	maskedPhNo = "P:" + generateStars(3) + "-" + generateStars(3) + "-" + phoneNo.substring(phoneNo.length() -4);
        }else{
        	if(hasplus){
        		countryCodeLength = phoneNo.substring(0,phoneNo.length() - 10).length();
        		maskedPhNo = "P:+" +generateStars(countryCodeLength)+"-"+ generateStars(3) + "-" + generateStars(3) + "-" + phoneNo.substring(phoneNo.length() -4);
        	}else{
        		maskedPhNo = "P:" +generateStars(countryCodeLength)+"-"+ generateStars(3) + "-" + generateStars(3) + "-" + phoneNo.substring(phoneNo.length() -4);
        	}
        }
		return maskedPhNo;
	}
	private static void getPhoneNo(String phoneNo1) {
		 try{
	        for(;i< phoneNo1.length();){
	        	String eachPhNo = String.valueOf(phoneNo1.charAt(i));
	        	phNo.push(Integer.parseInt(eachPhNo));
	        	i +=1;
	        }
	        }catch(NumberFormatException e){
	        	i += 1;
	        	getPhoneNo(phoneNo1);
	        	
	        }
		 while(phNo.size() != 0){
			 phoneNo =   phNo.pop() + phoneNo;
		 }
	}
	public static String generateStars(int n){
		String stars = "";
		for(int i = 0 ; i < n; i ++){
			stars += "*";
		}
		return stars;
	}
}

/*
E:jackAndJill@twitter.com
P:(333)456-7890
P: +1(333) 456-7890
*/

