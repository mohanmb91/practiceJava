package main;

import java.util.Scanner;

public class Expression {

	static String str1;
	
	static String[] str;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			str1 = scan.nextLine();
			str1 = str1.replaceAll(" ", "");
			str = str1.split("/");
			if (str.length >= 2) {
				for (int i = 0; i < str[1].length(); i++) {
					if (str[1].charAt(i) == 'R') {
						System.out.println("Doing opeartion Reverse");
						reverse();
					}
					if (str[1].charAt(i) == 'S') {
						System.out.println("Doing opeartion simplfy");
						simplify();
					}
				}
				System.out.println(str[0]);
			}
		}
		scan.close();
	}
	
	public static void reverse()
	{
		StringBuilder result=new StringBuilder();
		for(int k=str[0].length()-1;k>=0;k--)
		{
			if((int)str[0].charAt(k)>=65 && (int)str[0].charAt(k)<=90)
			{
				result.append(str[0].charAt(k));
			}
			if((int)str[0].charAt(k)==40)
			{
				result.append(")");
			}
			if((int)str[0].charAt(k)==41)
			{
				result.append("(");
			}
		}
		str[0]=result.toString();
	}
	
	public static void simplify()
	{
		char previous='(';
		int count =0;
		StringBuilder st=new StringBuilder();
		for(int i=0;i<str[0].length();i++)
		{
			char current = str[0].charAt(i);
			if(current=='(')
			{
				if(previous != '(')
				{
					count++;
					st.append(current);
				}
				
			}
			else if(current == ')')
			{
				if(count > 0)
				{
					count--;
					st.append(current);
				}
			}
			else
			{
				st.append(current);
			}
			previous=current;
		}
		str[0]=st.toString();
		
	}

}