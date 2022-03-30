class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        
        return usingDP(prices, n);
        //return solve(prices, 0, 1, 2);
    }
    
    //using DP
    public int usingDP(int[] prices, int n){
        
        int[][][] dp = new int[n+1][2][3];
        
        int profit = 0;
        for(int index = n - 1;index >= 0;index--){
            for(int buy = 0;buy < 2;buy++){
                for(int cap = 1;cap < 3;cap++){
                    if(buy == 1){
                        dp[index][buy][cap] = Math.max(-prices[index] + dp[index + 1][0][cap], 0 + dp[index + 1][1][cap]);   
                    }
                    else{
                        dp[index][buy][cap] = Math.max(prices[index] + dp[index+1][1][cap - 1], 0 + dp[index + 1][0][cap]);
                    }
                }
                
                
            }
        }
        
        return dp[0][1][2];
        
    }
    
    
    //using recursion
    public int solve(int[] prices, int index, int buy, int cap){
        
        
        if(index == prices.length || cap == 0)return 0;
        int profit = 0;
        
        if(buy == 1){
            profit = Math.max(-prices[index] + solve(prices, index + 1, 0, cap), 0 + solve(prices, index + 1, 1, cap));   
        }else{
            profit = Math.max(prices[index] + solve(prices, index + 1, 1, cap-1), 0 + solve(prices, index + 1, 0, cap));
        }
        
        return profit;
    }
}