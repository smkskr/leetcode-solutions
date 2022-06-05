// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}



// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        Stack<Integer> stack = new Stack<>();//store indices
        long[] result = new long[n];
        result[n - 1] = -1;
        int greaterElemIndex = 0;
        stack.push(0);//store first index
        for(int index = 1;index < n;index++){
            
            while(!stack.isEmpty() && arr[index] > arr[stack.peek()]){
                result[stack.pop()] = arr[index];
            }
            stack.push(index);
        }
        
        
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        
        return result;
    } 
    
    
}