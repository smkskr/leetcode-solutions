// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        //return solve(arr,0,N - 1);
        int[][] dp = new int[N][N];
        
        for(int gap = 2;gap < N;gap++){
            for(int i = 0;i + gap < N;i++){
                
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;        
               
                for(int k = i + 1;k < j;k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + arr[i]*arr[k]*arr[j]); 
                } 
            }
        }
        
        
        return dp[0][N - 1];
      
    }
    
    //recursive solution
    static int solve(int[] arr, int start,int end){
        
        if(start + 1 == end)return 0;
        if(start + 2 == end)return arr[start]*arr[start+1]*arr[end];
        
        int res = Integer.MAX_VALUE;
        
        for(int k = start + 1;k < end;k++){
            
            res = Math.min(res, solve(arr, start, k) + solve(arr, k, end) + arr[start]*arr[k]*arr[end]); 
        }
        
        return res;
    }
}



