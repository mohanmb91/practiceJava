package main;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.IntStream;

class Solution2 {
static int maxLength(int[] a, int k) {
	int maxCount = 0,count =0,sum = 0,head = 0;
	for(int i =0; i < a.length; i ++){
		sum += a[i];
		count += 1;
		if(sum > k){
			while(sum > k){
				sum = sum - a[head];
				head += 1;
				count = count -1;
			}
		}
		if(count > maxCount){
			maxCount = count;	
		}
	}
	return maxCount;
}


public static int maxSequenceSum(int[] arr,int k)
{        
    int maxSoFar = arr[0], maxEndingHere = arr[0],count=1,maxCount=0,_i;

    for (int i = 1; i < arr.length; i++)
    {
    	_i=i;
        /* calculate maxEndingHere */
    	maxEndingHere += arr[i];
    	
        if (maxEndingHere >k){
            maxEndingHere = arr[i];
            count=0;
        }
      
        if (maxEndingHere <= k)
        	count++;
        
        if(count > maxCount)
        	{
        	maxCount = count;
        	i=_i;
        	}
    }
    return count;
}  

	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        
        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }
        
        int _k;
        _k = Integer.parseInt(in.nextLine().trim());
        
        res = maxLength(_a, _k);
//        bw.write(String.valueOf(res));
//        bw.newLine();
//        
//        bw.close();
    }

}

//  1 2 1 3 1 --> 4
/*
11
1
2
3
4
5
3
4
1
1
1
1
4

4
3
1
2
1
4

int maxPhrase = 0;
	
	List<String> values = new ArrayList<>();
	int  i=1;
		while(i <= a.length){
		for(int j=0;j <= a.length - i; j ++){
			int sum =0;
			int arraySubSet[] =  Arrays.copyOfRange(a, j, j +i);
			int length = arraySubSet.length;
			if(maxPhrase < length){
					sum = Arrays.stream(arraySubSet).sum();
					if(sum <= k){
					maxPhrase = length;
				}
			}
		}
		i += 1;
	}
	return maxPhrase;
	
	
	
	a = Arrays.stream(a).filter(x -> x <= k).toArray();
	int  i=a.length;
	while(i >= 1){
		for(int j=0;j <= a.length - i; j ++){
			int sum =0;
			int arraySubSet[] =  Arrays.copyOfRange(a, j, j +i);
			int length = arraySubSet.length;
			if(maxPhrase < length){
					sum = Arrays.stream(arraySubSet).sum();
					if(sum <= k){
					maxPhrase = length;
					break;
				}
			}
		}
		i = i - 1;
	}
	
	
	
	int maxPhrase = 0;
	if(k > 0){
	for(int i = 0; i < a.length; i ++){
		int counter = 1;
		int sum = a[i];
		for(int j = i +1; j < a.length;j ++){
			sum = sum + a[j];
			if(sum <= k){
				counter = counter + 1;
				if(counter > maxPhrase){
					maxPhrase =  counter;
				}
			}else if(sum > k){
				break;
			}
		}
	}
}
	return maxPhrase;
	
	
	
	
	int maxPhrase = 0, sum = 0;
	int counter =0;
	for(int j = 0;j < a.length; j ++){
		counter++;
		sum += a[j];
		if(sum > k){
			sum = 0;
			counter=0;
			
		}else if(counter > maxPharse){
			
			maxPhrase = counter;
		}
	}
	
	return maxPhrase;
	
	
	
	
	int maxCount = 0,max = 0;
	A = Arrays.stream(A).filter(x -> x <= k).toArray();
	int sum[] = new int[A.length];
	for(int i=0;i< A.length; i ++){
		if(i == 0){
		sum[i] = A[i];
		max = Math.max(max, sum[i]);
		}else{
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			if(sum[i] > k){
				sum[i-1] = A[i-1];
				sum[i] = sum[i - 1] + A[i];
				if(sum[i] > k){
					sum[i] = A[i];
				}
				maxCount = 1;
			}
			max = Math.max(max, sum[i]);
		}
		maxCount ++;
	}
	
	return maxCount;
	
	
	
	int maxPhrase = 0;
	int  i=1;
	while(i <= a.length){
		for(int j=0;j <= a.length - i; j ++){
			int sum =0;
			int arraySubSet[] =  Arrays.copyOfRange(a, j, j +i);
			int length = arraySubSet.length;
			if(maxPhrase < length){
					sum = Arrays.stream(arraySubSet).sum();
					if(sum <= k){
					maxPhrase = length;
					break;
				}
			}
		}
		i = i + 1;
	}
	int res = maxSequenceSum(a,k);
	return maxPhrase;
*/

