// { Driver Code Starts


import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        
        int[][] dp = new int[n+1][n+1];
        
        for(int index = 1;index <= n;index++){
            for(int length = 1;length <=n;length++){
                 if(index <= length){
                    dp[index][length] = Math.max(price[index - 1] + dp[index][length - index], dp[index - 1][length]);
                 }else{
                     dp[index][length] =dp[index - 1][length];
                 }
            }
        }
        
        return dp[n][n];
        //return solve(price, n - 1, n);
    }
    
    //using recursion
    public int solve(int[] price, int index,int length){
        
        if(index == -1)return 0;
        if(length == 0)return 0;
        int profit = 0;
        if(index + 1 <= length){
            profit = Math.max(price[index] + solve(price, index, length - (index + 1)), solve(price, index - 1, length));
        }else{
            profit = solve(price, index - 1, length);
        }
        
        return profit;
    }
}