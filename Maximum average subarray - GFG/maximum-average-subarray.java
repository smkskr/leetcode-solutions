// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxAverage(arr, n, k);
            for(int i=ans; i<ans+k; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxAverage(int[] arr, int n, int k) {
        // code here
        int maxSum = Integer.MIN_VALUE;
        int index  = 0;
        int start = 0;
        int end = 0;
        int len = arr.length;
        int sum = 0;
        
        while(end < len){
            
            sum += arr[end];
            
            if(end - start + 1 == k){
                
                if(sum > maxSum){
                    maxSum = sum;
                    index = start;
                    
                }
                
                //if(arr[start] < 0)sum = sum + arr[start];
                //else 
                sum = sum - arr[start];
                start++;
                //System.out.println(sum + ", maxSUM : " + maxSum);
            }
            
            end++;
        }
        
        return index;
    }
}
