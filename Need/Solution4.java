package Need;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Beautifull{
    String value;
    int currentIndex;
    int noOfMovesMade;
    public Beautifull(String value, int i,int moves){
        this.value = value;
        this.currentIndex = i;
        this.noOfMovesMade = moves;
    }
}
class Checker1 implements Comparator<Beautifull>{
	public int compare(Beautifull b1, Beautifull b2){
		if(b1.noOfMovesMade > b2.noOfMovesMade){
			return 1;
		}else if(b1.noOfMovesMade < b2.noOfMovesMade){
			return -1;
		}
		else{
			return 0;
		}
	}
}
public class Solution4 {
    public static void main(String[] args) {
        
        PriorityQueue<Beautifull> frontier = new PriorityQueue<>(10, new Checker1()); 
        frontier.add(new Beautifull("", 0, 1));
        frontier.add(new Beautifull("", 0, 2));
        frontier.add(new Beautifull("", 0, 3));
        frontier.add(new Beautifull("", 0, 4));
        frontier.add(new Beautifull("", 0, 5));
        frontier.add(new Beautifull("", 0, 6));
        while(!frontier.isEmpty()){
        	Beautifull current = frontier.poll();
        	System.out.println(current.noOfMovesMade);
        }
    }
}
