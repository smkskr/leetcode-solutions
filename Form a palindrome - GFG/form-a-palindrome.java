// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

/**
 * This question is similar to finding LCS of two strings
 * Instead of finding LCS of two different strings, 
 * here we need to find LCS between the original string and the reverse of this string
 * 
 * Minimum insertions to make a string will be the difference between length of the original string and LCS of them
 */
class Solution{
    int findMinInsertions(String S){
        // code here
        int len = S.length();
        if(len == 1)return 0;
        String R = reverse(S, len);
        int[][] dp = new int[len + 1][len + 1];
        
        for(int row = 1;row <= len;row++){
            for(int col = 1;col <= len;col++){
                if(S.charAt(row - 1) == R.charAt(col - 1)){
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                }else{
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        
        return len - dp[len][len];
        
    }
    
    //recursive solution
    public int findLCS(String S, String R, int indexS, int indexR){
        
        if(indexS == 0 || indexR == 0){
            return 0;
        }
        
        if(S.charAt(indexS) == R.charAt(indexR)){
            return 1 + findLCS(S, R, indexS - 1, indexR - 1);
        }
        return Math.max(findLCS(S, R, indexS - 1, indexR), findLCS(S, R, indexS, indexR - 1));
    }
    
    
    public String reverse(String S, int len){
        char[] arr = S.toCharArray();
        int left = 0;
        int right = len - 1;
        while(left <= right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
      return String.valueOf(arr);
    }
    
   
}