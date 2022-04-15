// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
import java.lang.*;


class GFG {
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine()); // input size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split("\\s+");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    Solve T = new Solve();
            long ans = T.maxArea(arr,n);
            System.out.println(ans);
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solve{
    
    long maxArea(int A[], int len){
        // Code Here
        
        int leftPointer = 0;
        int rightPointer = len - 1;
        long maxArea = 0;
        
        while(leftPointer < rightPointer){
            
            maxArea = Math.max(maxArea, (rightPointer - leftPointer)*Math.min(A[leftPointer],A[rightPointer]));
            if(A[leftPointer] < A[rightPointer]){
                leftPointer++;
            }else{
                rightPointer--;
            }
        }
        
        return maxArea;
    }
    
    
    
}