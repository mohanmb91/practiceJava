package bitManipulation;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Two Numbers");
		int x = in.nextInt();
		int y = in.nextInt();
		
		System.out.println(x|y);
		in.close();
	}

}
