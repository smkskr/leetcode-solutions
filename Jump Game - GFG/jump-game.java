// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] A, int N) {
        // code here
        
        int[] dp = new int[N];
        dp[N - 1] = 1;
        int target = N - 1;
        for(int i = N - 2;i >= 0;i--){
            if(A[i] + i >= target){
                dp[i] = 1;
                target = i;
            }else{
                dp[i] = 0;
            }
        }
        
        return dp[0];
    }
};