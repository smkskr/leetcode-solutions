class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return spaceOptimizedDP(prices, n);
        //return usingDP(prices, n);
        //return solve(prices,0,1);
    }
    
    //space optimized DP
    public int spaceOptimizedDP(int[] prices, int n){
         
         int[] currProfit = new int[2];
         int[] prevProfit = new int[2];
        
         prevProfit[0] = 0;
         prevProfit[1] = 0;
         
         for(int index = n - 1;index >= 0;index--){
            for(int buy = 0;buy < 2;buy++){
                if(buy == 1){
                     currProfit[buy] = Math.max(-prices[index] +prevProfit[0], 0 + prevProfit[1]);
                }else{
                     currProfit[buy] = Math.max(prices[index] + prevProfit[1], 0 + prevProfit[0]);
                }
                
               
            }
             
             prevProfit = currProfit;
        }
        
        return currProfit[1];
        
    }
    //using DP
    public int usingDP(int[] prices,int n){
        
        
        int[][] dp = new int[n + 1][2];
        
        dp[n][0] = 0;
        dp[n][1] = 0;
        
        for(int index =n-1;index >= 0;index--){
            for(int buy = 0;buy < 2;buy++){
                if(buy == 1){
                    dp[index][buy] = Math.max(-prices[index] + dp[index+1][0], 0 + dp[index+1][1]);
                }else{
                    dp[index][buy] = Math.max(prices[index] + dp[index+1][1], 0 + dp[index+1][0]);
                }
            }
        }
        return dp[0][1];
    }
    
    
    //recursion
    public int solve(int[] prices,int index, int buy){
        
        if(index == prices.length)return 0;
        int profit = 0;
        
        if(buy == 1){
            profit = Math.max(-prices[index] + solve(prices, index + 1, 0), 0 + solve(prices, index + 1,1));
        }else{
            profit = Math.max(prices[index] + solve(prices, index + 1,1), 0 + solve(prices, index + 1, 0));
        }
        
        return profit;
    }
}