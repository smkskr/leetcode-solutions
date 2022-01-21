class Solution {
    public int climbStairs(int n) {
        
       int[] dp = new int[n+1];
       Arrays.fill(dp, -1);
       return solve(n, dp);
       
    }
    
    //memoized solution
    public int solve(int n, int[] dp){
        
        
        if(n == 1 || n == 2 || n == 0)return dp[n] = n;
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
        
        return dp[n];
    }
}