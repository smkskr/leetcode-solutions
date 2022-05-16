// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s)
    {
    //Your code here
     long mf = 1;
     long sum = 0;
     long mod = 1000000007;
     
     for(int i = s.length() - 1;i >= 0;i--){
        
        sum = (sum%mod + ((s.charAt(i) - '0')*(i + 1)*mf)%mod)%mod;
        mf = (mf*10 + 1)%mod;
        
     }
     
     return sum;
     
    }
    
   
}