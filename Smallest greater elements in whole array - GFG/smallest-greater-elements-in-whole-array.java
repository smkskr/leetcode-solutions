// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Complete obj = new Complete();
		    arr = obj.greaterElement(arr, sizeOfArray);
		    for(int i=0; i< sizeOfArray;i++){
		        if(arr[i] == -10000000)
		            System.out.print("_ ");
		        else
		            System.out.print(arr[i] + " ");
		    }
		    System.out.println();
		}
	}
}


// } Driver Code Ends


//User function Template for Java

//User function Template for Java

//User function Template for Java

            

class Complete{
    
   
    // Function for finding maximum and value pair
    public static int[] greaterElement (int arr[], int n) {
        // Complete the function
        Set<Integer> set = new HashSet<Integer>();
        for(int num : arr){
            set.add(num);
        }
        int size = set.size();
        int[] copyArr = new int[size];
         int index = 0;
        for(int num : set){
            copyArr[index] = num;
            index++;
        }
        Arrays.sort(copyArr);
        int[] result = new int[n];
       index = 0;
        for(int num : arr){
            int keyIndex = binarySearch(copyArr, num, size);
            result[index] = keyIndex + 1 == size ? -10000000 : copyArr[keyIndex + 1];
            index++;
        }
        return result;
       
    }
//  6,7,12,13
    public static int binarySearch(int[] arr, int key, int n){
        
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid] < key){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return -1;
    }
}


