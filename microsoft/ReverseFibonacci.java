package microsoft;

import java.util.Scanner;

public class ReverseFibonacci {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long first = in.nextLong();
		long second = in.nextLong();
		
		long third;
		
		if(second>first)
		{
			third=first;
			first=second;
			second=third;
		}
		
		while(true){
			 third = first - second;
			first = second;
			second = third;
			
			if(second < 0){
				break;
			}else{
				System.out.println(second);
			}
				
			
		}
		
		in.close();
	}

}
