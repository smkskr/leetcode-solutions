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
         //store indexes of next greater element
        Stack<Integer> stack = new Stack<>();
        long[] result = new long[n];
        stack.push(0);
        for(int i = 1;i < n;i++){
            
            //popping out elements if the current array element is greater than the top of stack element
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        
        //if any elements are left in stack that means they have no next greater element
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
            return result;        
        
    } 
    
    
}