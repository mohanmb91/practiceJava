package arrays;

public class ReverseInPlace {
	public static void main(String args[]){
		int arr[] = {1,2,3,4,5,6,7};
		reverse(0,arr,arr.length-1,arr.length/2);
		for(int eachElement: arr){
			System.out.println(eachElement);
		}
	}

	private static void reverse(int left, int[] arr, int right, int mid) {
		if(left <= mid){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			reverse(++left,arr,--right,mid);
		}
	}
	
}
