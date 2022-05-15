// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{

  public static void main (String[] args)  {
     Scanner s=new Scanner(System.in);
     int t=s.nextInt();
     while(t-->0){
         int n=s.nextInt();
         Solution obj = new Solution();
         System.out.println(obj.countWays(n));
     }

   }
}
// } Driver Code Ends




class Solution
{
    // function to count ways in which n can be
    // expressed as the sum of two or more integers
    int countWays(int n)
    {
        
         int mod = 1000000007;
         // your code here
         //row is for numbers
         //column is for sum
         int[][] dp = new int[n][n+1];
         //fill first column with 1 as sum = 0 will have 1 way
         for(int num = 0;num < n;num++){
             dp[num][0] = 1;
         }
         
         for(int num = 1;num < n;num++){
             for(int sum = 1;sum <= n;sum++){
                if(num <= sum){
                    dp[num][sum] = (dp[num][sum - num]%mod + dp[num - 1][sum]%mod)%mod;
                }else{
                    dp[num][sum] = dp[num - 1][sum]%mod;
                }     
             }
         }
         
         return dp[n-1][n];
         //return solve(n-1, n);
    }
    
    //recursive code
    int solve(int num, int target){
        
        if(target == 0)return 1;
        if(num == 0){
            return target == 0 ? 1 : 0;
        }
        if(num <= target){
         return solve(num, target - num) + solve(num - 1, target);
        }
        return solve(num - 1, target);
    }
}
