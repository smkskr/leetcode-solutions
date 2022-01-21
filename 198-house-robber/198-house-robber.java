class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return solve(nums, nums.length - 1, dp);
    }
    
    //using memoization
    public int solve(int[] nums, int n, int[] dp){
        
        if(n == 0)return dp[0] = nums[0];
        
        if(n == 1)return dp[1] = Math.max(nums[0], nums[1]);
        
        if(dp[n] != -1)return dp[n];
        
        dp[n] = Math.max(solve(nums, n - 1, dp), nums[n] + solve(nums, n - 2, dp));
        
        return dp[n];
    }
}