// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int len = S.length();
        int start = 0;
        int end = 0;
        
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        
        int[] countDigit = new int[3];//store digit count from zero to two
        Arrays.fill(countDigit,1);
        
      
        while(end < len){
            
            int digit = S.charAt(end) - '0';
            countDigit[digit]--;
            if(countDigit[digit] == 0){
                count++;
            }
            
            while(count == 3 && start < len){
                minLen = Math.min(minLen, end - start + 1);
                int firstDigit = S.charAt(start) - '0';
                countDigit[firstDigit]++;
                if(countDigit[firstDigit] > 0)count--;
                start++;
            }
            end++;
        }
        
        if(minLen == Integer.MAX_VALUE)return -1;
        return minLen;
    }
};
