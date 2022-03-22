// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{   
    
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int[] arr = new int[3];
       arr[0] = x;
       arr[1] = y;
       arr[2] = z;
       int[] res = new int[n+1];
       Arrays.fill(res, Integer.MIN_VALUE);
       res[0] = 0;
       
      for(int i = 1;i <= n;i++){
          for(int j = 0;j < arr.length;j++){
              
              if(arr[j] <= i){
                  if(res[i - arr[j]] != Integer.MIN_VALUE){
                      res[i] = Math.max(res[i],1 + res[i - arr[j]]);
                  }
              }
          }
      }
      
      return res[n] == Integer.MIN_VALUE ? 0 : res[n];
       //return solve(arr, n);
    }
    
    //recursion
    public int solve(int[] arr, int sum){
        
        if(sum == 0)return 0;
        
        int res = Integer.MIN_VALUE;
        
        for(int i = 0;i < arr.length;i++){
            
            int subRes = 0; 
            if(arr[i] <= sum){
                subRes = solve(arr, sum - arr[i]);        
            }
            if(subRes != Integer.MIN_VALUE){
                res = Math.max(res, 1 + subRes);
            }
        }
        return res;
        
    }
}
