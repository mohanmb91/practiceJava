package Strings;
import java.io.*;
import java.util.*;

public class Panagrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        str = str.toLowerCase();
        HashSet<Character> alphabets = new HashSet<Character>();
        for(int i=0; i < str.length(); i ++){
            int asciiValue = (int) str.charAt(i);
            if(asciiValue >= 97 && asciiValue <= 122){
                alphabets.add(str.charAt(i));
                if(alphabets.size() == 26){
                    break;
                }
            }
        }
        if(alphabets.size() == 26){
            System.out.println("pangram");
        }else{
            System.out.println("not pangram");
        }
        in.close();
    }
}