// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;


 // } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to return the total number of possible unique BST.
    static int numTrees(int N)
    {
        // Your code goes here
        long[] catalanNum = new long[N + 1];
        catalanNum[0] = 1;
        catalanNum[1] = 1;
        int mod = 1000000007;
        
        
        for(int i = 2;i <= N;i++){
            long sum = 0;
            for(int j = 0;j < i;j++){
                sum += (catalanNum[j]%mod * catalanNum[i - 1 - j]%mod)%mod;
            }
            catalanNum[i] = sum%mod;
        }
        
        return (int)catalanNum[N];
        
    }
}


// { Driver Code Starts.

class GFG
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking n
            int n =sc.nextInt();
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling method numTrees() of 
            //class Solution
            System.out.println(ob.numTrees(n));
        }
    }
}
  // } Driver Code Ends