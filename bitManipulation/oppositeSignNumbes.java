package bitManipulation;

import java.util.Scanner;

public class oppositeSignNumbes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Two Numbers");
		int x = in.nextInt();
		int y = in.nextInt();
		
		System.out.println(isOppositeSign(x,y));
		in.close();
	}

	private static boolean isOppositeSign(int x, int y) {
		// TODO Auto-generated method stub
		return (x ^ y) < 0;
	}

}
