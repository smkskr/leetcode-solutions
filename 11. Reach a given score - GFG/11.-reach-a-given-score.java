// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total number of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking score
		    int n=sc.nextInt();
		    
		    //calling method count()
		    //and printing the result
		    System.out.println(count(n));
		}
		
	}
	


 // } Driver Code Ends
//User function Template for Java


//Function to find the number of distinct combinations to reach the given score.
public static int count(int n)
{
    //Your code here
    int[] value = {3,5,10};
    return solve(n, value, 2);
}

public static int solve(int target, int[] value, int index){
    
    if(target == 0)return 1;
    if(index == -1){
        return target == 0 ? 1 : 0;
    }
    if(value[index] <= target){
        return solve(target - value[index], value, index) + solve(target, value, index - 1);
    }
    return solve(target, value, index - 1);
}

// { Driver Code Starts.


    
}  // } Driver Code Ends