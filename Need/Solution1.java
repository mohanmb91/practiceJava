package Need;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer,List<Integer>> maps = new HashMap<Integer,List<Integer>>();
        for(int i=0; i < n; i++){
            int input = in.nextInt();
            if(maps.containsKey(input)){
                List<Integer> lists = maps.get(input);
                lists.add(i);
                maps.put(input,lists);
            }else{
                List<Integer> lists = new ArrayList<>();
                lists.add(i);
                maps.put(input,lists);
            }
        }
        int minimum = Integer.MAX_VALUE;
        for(int eachKey: maps.keySet()){
            List<Integer> lists = maps.get(eachKey);
            for(int i = 0; i < lists.size()-1; i ++){
              int current = lists.get(i);
              int next = lists.get(i+1);
               int diff = Math.abs(current - next);
              if(diff < minimum){
                minimum =    diff;
              }
            }
        }
        System.out.println(minimum);
    }
}
