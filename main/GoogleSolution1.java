package main;

public class GoogleSolution1 {
	
		public static void main(String[] rgas){

			int x = 623315;
			String y = ""+x;
			int maxValue =0 ;
			for(int i=0; i<y.length()-1; i++){
				String one = y.substring(0,i);
				double a = Double.parseDouble(String.valueOf(y.charAt(i)));
				double b = Double.parseDouble(String.valueOf(y.charAt(i+1)));
				double avg = Math.round((a+b)/2.0);

				String last = y.substring(i+2);
				int value = Integer.parseInt(one+(int)avg+last);
				maxValue = Math.max(value, maxValue);
			}
				System.out.println(maxValue);
		}
	}

