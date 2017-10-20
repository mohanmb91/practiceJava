package Need;

import java.util.*;

class Stack{
	int x;
	int w;
	public Stack(int x, int w){
		this.x = x;
		this.w = w;
	}
}
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> set = new TreeSet<>();
		set.add(6);
		set.add(5);
		set.add(4);
		set.add(3);
		set.add(2);
		set.add(1);
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext()){
			
			int a = iterator.next();
			set.remove(a);
			
			set.add(a);
			
		}
	}

}
