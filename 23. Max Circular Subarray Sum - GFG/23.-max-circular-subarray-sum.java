// { Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}


// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
        // Your code here
        
        
        int kadane = kadane(a,n);
        
        if(kadane < 0)return kadane;
        
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum += a[i];
            a[i] = -1 * a[i];
        }
        
        int reverseKadane = kadane(a,n);
        
        reverseKadane = sum + reverseKadane;
        
        return Integer.max(kadane, reverseKadane);
    }
    
    static int kadane(int[] a, int n){
        
        int maxSum = a[0];
        int sum = a[0];
        
        for(int i = 1;i < n;i++){
            sum = sum + a[i];
            sum = Math.max(sum, a[i]);
            maxSum = Math.max(sum, maxSum);
        }
        
        return maxSum;
    }
    
}



