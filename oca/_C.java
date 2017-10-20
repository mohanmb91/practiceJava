package oca;

class i1{
	public static String getName() {
		return null;
	}
}

public class _C extends i1{
	public static void main(String[] main) {
	int n = 8;
	int i = 0;
	while(n != 0){
		n = n & (n-1);
		i++;
	}
	System.out.println(i);
	System.out.println((new _C()).getName());
	} 
	
	public static String getName(){
		return "Mohan";
	}
}	




 