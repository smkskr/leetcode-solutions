// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.posIntSol(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long posIntSol(String s)
    {
        //code here.
        int numOfVariables = -1;
        int index = 0;
        int length = s.length();
        
        while(s.charAt(index) != '='){
            
            if(s.charAt(index) != '+')numOfVariables++;
            index++;
            
        }
        
        int N = 0;
        index++;
        while(index < length){
            N = N*10 + s.charAt(index++) - '0';
        }
       
        N = N - 1;
        return nCr(N, numOfVariables);
    }

    long nCr(int N, int R){
        
        long[] cache = new long[R + 1];
        cache[0] = 1;
        
        for(int value = 1;value <= N;value++){
            
            for(int cacheIndex = Math.min(R,value);cacheIndex > 0;cacheIndex--){
                cache[cacheIndex] = (cache[cacheIndex] + cache[cacheIndex - 1]);
            }
        }
        
        return cache[R];
    }
  
    
    
}