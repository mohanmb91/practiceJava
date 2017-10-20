package twitterU;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(decrypt("Atvt hrqgse, Cnikg"));
	}
	 static String decrypt(String input) {
	        int key[] = {2,5,1,2,2,0,8};
	        StringBuilder result = new StringBuilder("");
	        int pointer = 0;
	        for(int i=0; i < input.length(); i ++){
	            int c = (int) input.charAt(i);
	            if(Character.isAlphabetic(input.charAt(i))){
	            boolean isCaps = isCapsInrange(c);
	            
	            
	            int newValue = c - key[pointer];
	            if(isCaps){
	            	if(isCapsInrange(newValue)){
	            		result.append((char) newValue);
	            	}else{
	            		int decrement = newValue + 26;
	            		
	            		result.append((char) decrement);
	            	}
	            }else{
	            	if(isSmallInRange(newValue)){
	            		result.append((char) newValue);
	            	}else{
	            		int decrement = newValue + 26;
	            		result.append((char) decrement);
	            	}
	            }
	            pointer ++;
	            if(pointer == key.length){
	            	pointer =0;
	            }
	            }else{
	            	result.append(input.charAt(i));
	            }
	           
	        }
	        return result.toString();
	    }
	private static boolean isCapsInrange(int c) {
		return c >= 65 && c <= 90;
	}
	private static boolean isSmallInRange(int c){
		return c >= 97 && c <= 122;
	}
}
