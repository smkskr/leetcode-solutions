class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
       
        int n = cost.length;
        
        //base cases
        if(n == 0)return 0;
        if(n == 1)return cost[0];
        if(n == 2)return Math.min(cost[0], cost[1]);
            
        int[] dp = new int[n];
        dp[n - 1] = cost[n - 1];
        dp[n - 2] = Math.min(cost[n - 2],cost[n - 2] + dp[n - 1]);
        
        //fill it from backwards
        for(int i = n - 3;i >=0;i--){
            dp[i] = Math.min(cost[i] + dp[i+1],cost[i] + dp[i + 2]);
        }
        
        return Math.min(dp[0],dp[1]);
    }
}