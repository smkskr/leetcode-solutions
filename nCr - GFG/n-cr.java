// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int nCr(int n, int r)
    {
        // code here
        //nCr = nC0 + nC1 + nC2 + ..... + nCr-2 + nCr-1 + nCr
        //nC0 = nCr
        //nC1 = nCr-1
        //nC2 = nCr-2
        //This problem kind of follows the solution of Pascal Triangle
        
        /**
         * e.g. value of 4C2 = 6 ?
         * 
         * 1
         * 1 2 1
         * 1 3 3 1
         * 1 4 6 4 1
         * 
         * 
         */
         
        int mod = 1000000007;
        int[] cache = new int[r + 1];
        cache[0] = 1;
        
        for(int value = 1;value <= n;value++){
            
            for(int cacheIndex = Math.min(r,value);cacheIndex > 0;cacheIndex--){
                cache[cacheIndex] = (cache[cacheIndex] + cache[cacheIndex - 1])%mod;
            }
        }
        
        return cache[r];
    }
}