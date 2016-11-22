package main;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution2 {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int i;
        Character op,prevChar;
        String[] split;
        String input,temp;
        StringBuilder ip;
        while(scan.hasNextLine()){
            String str = scan.nextLine();
            str = str.trim().replaceAll("\\s","");
            split=str.split("/");
            input=split[0];
            ip=new StringBuilder(split[0]);
            if(split.length>1)
               for(i=0;i<split[1].length();i++)
               {
                    op=split[1].charAt(i);
                    if(op.equals('S'))
                    {
                        temp="";prevChar='(';
                        Stack<Character> st= new Stack<Character>();
                        for(char c: input.toCharArray())
                        {
                            if(!st.empty())
                                prevChar=st.peek();
                            st.push(c);
                            if(c=='(')
                            {
                                if(prevChar!=c)
                                    temp+=c;
                              }
                           else if(c==')')
                           {
                                while(st.peek()!='(')
                                    st.peek();
                                if(!st.isEmpty()) st.pop();
                            }
                            if(!st.isEmpty())
                                if(st.peek()!='(')
                                 temp+=c;
                        }
                             input=new String(temp);
                             ip= new StringBuilder(input);
                        }else if(op.equals('R'))
                        {
                        
                            temp="";
                            ip=ip.reverse();
                            input=new String(ip);
                            for(char c: input.toCharArray())
                                temp+=c=='('?')':c==')'?'(':c;
                            input=new String(temp);
                        }
               }
            
            System.out.println(input);
           }
        scan.close();
    }
}