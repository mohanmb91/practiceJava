package main;
import java.util.*;
public class Dir{
	
	public static int count_spaces(String line){
		int spaces = 0;
		char[] arr = line.toCharArray();
		for(char c : arr){
			if(c != ' '){
				break;
			}
			else{
				spaces++;
			}
		}
		return spaces;
	}
	public static void main(String[] agrs){
		String main = "dir1\n dir11\n dir12\n dir13\n  dir121\n dir14\n  dir141\n   dir1211\n    picture.jpeg\n file1.jpeg\ndir2\n dir21\n  dir211\n   dir2111\n    file2.gif";
		String[] arr = main.split("\n");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]+" "+count_spaces(arr[i]));
		}
		int max = 0;
		int max_pos =0;
		
		for(int i=0;i<arr.length;i++){
			if(count_spaces(arr[i])> max){
				max = count_spaces(arr[i]);
				max_pos = i;
			}
		}
		System.out.println(max_pos);
		String path = "";
		
		
		int k=1;
		ArrayList<String> paths = new ArrayList<String>();
		while(k<arr.length){
			if ((count_spaces(arr[k-1])+1) == count_spaces(arr[k])) {
				path+=arr[k-1];
			}
			//if(arr[k].contains(".jpeg") || arr[k].contains(".png")){
			if(count_spaces(arr[k]) == 0){
				System.out.println(path);
				path="";
			}
			k++;
		}
		
		
	}
}