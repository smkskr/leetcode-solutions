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
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        
        int[][] cache = new int[n + 1][m + 1];
        int maxLen = 0;
        for(int len1 = 1;len1 <= n;len1++){
            for(int len2 = 1;len2 <= m;len2++){
                if(S1.charAt(len1 - 1) == S2.charAt(len2 - 1)){
                    cache[len1][len2] = 1 + cache[len1 - 1][len2 - 1]; 
                }
                maxLen = Math.max(maxLen, cache[len1][len2]);
            }
        }
        
        return maxLen;
        /**        
         *
        int[] maxLen = new int[1];
        usingRecursion(S1, S2, n, m, 0, maxLen);
        return maxLen[0];
        */
    }
    
    void usingRecursion(String S1, String S2, int index1, int index2, int currLen, int[] maxLen){
        
        if(index1 == 0 || index2 == 0){
            maxLen[0] = Math.max(currLen, maxLen[0]);
            return;
        }
        //int maxLen = 0;
        if(S1.charAt(index1 - 1) == S2.charAt(index2 - 1)){
            usingRecursion(S1, S2, index1 - 1, index2 - 1, currLen + 1, maxLen);
        }else{
            maxLen[0] = Math.max(currLen, maxLen[0]);
            usingRecursion(S1, S2, index1 - 1, index2, 0, maxLen);
            usingRecursion(S1, S2, index1, index2 - 1, 0, maxLen);
        }
        
    }
}