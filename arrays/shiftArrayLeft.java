package arrays;

public class shiftArrayLeft {

	public static void main(String args[]){
		int arr[] = {1};
		if(arr.length > 0){
			shiftLeft(arr);
		}
		
		for(int eachElement: arr){
			System.out.println(eachElement);
		}
	}

	private static void shiftLeft(int[] arr) {
		int start = arr[0];
		for(int i =1; i < arr.length; i ++){
			arr[i-1] = arr[i];
		}
		arr[arr.length-1] = start;
	}

}
