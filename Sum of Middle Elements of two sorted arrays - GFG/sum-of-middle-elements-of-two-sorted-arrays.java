// { Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar1 = new int[n], ar2 = new int[n];
            String[] inputLine = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                ar1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                ar2[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().findMidSum(ar1, ar2, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMidSum(int[] ar1, int[] ar2, int n) {
        // code here
        //follow the approach of finding median of two sorted arrays
        
        int start = 0;
        int end = n;
        int sum = 0;
        while(start <= end){
            
            int part1 = (start + end)/2;
            int part2 = (2*n + 1)/2 - part1;
            
            int maxLeft1 = part1 == 0 ? Integer.MIN_VALUE : ar1[part1 - 1];
            int minRight1 = part1 == n ? Integer.MAX_VALUE : ar1[part1];
            
            int maxLeft2 = part2 == 0 ? Integer.MIN_VALUE : ar2[part2 - 1];
            int minRight2 = part2 == n ? Integer.MAX_VALUE : ar2[part2];
            
            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                sum = Math.max(maxLeft1,maxLeft2) + Math.min(minRight1,minRight2);break;
            }else if(maxLeft1 > minRight2)end = part1 - 1;
            else start = part1 + 1;
        }
        
        return sum;
    }
}