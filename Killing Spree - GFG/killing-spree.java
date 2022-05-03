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
            String input_line[] = read.readLine().trim().split("\\s+");
            long N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            long ans = ob.killinSpree(N);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    long killinSpree(long n)
    {
        // Code Here
        long low = 1;
        long high = (long)Math.sqrt(n) + 1;
        long ans = 0;
        while(low <= high){
            
            long mid = low + (high - low)/2;
            long value = sumOfSquaresOfNaturalNumbers(mid);
            if(value <= n){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
      
        
        return ans;
    }
    
    long sumOfSquaresOfNaturalNumbers(long n){
        
        return (n*(n + 1)*(2*n + 1))/6;
    }
}