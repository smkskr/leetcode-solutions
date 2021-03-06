class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int n = prices.length;
        return usingSpaceOptimizedDP(prices, n, fee);
        //return usingDP(prices, n, fee);
       // return solve(prices, 0, 1, fee);
    }
    
    
    //using space optimized DP
     public int usingSpaceOptimizedDP(int[] prices, int n, int fee){
        
        int[] prevProfit = new int[2];
        int[] currProfit = new int[2];
        
        for(int index = n - 1;index >= 0;index--){
           
                currProfit[1] = Math.max(-prices[index] + prevProfit[0],  prevProfit[1]); 
                currProfit[0] = Math.max(prices[index] - fee + prevProfit[1],  prevProfit[0]);
                prevProfit = currProfit;
        }
        
        return currProfit[1];
    }
    
    //using dp
    public int usingDP(int[] prices, int n, int fee){
        
        int[][] dp = new int[n + 1][2];
        
        for(int index = n - 1;index >= 0;index--){
           
                dp[index][1] = Math.max(-prices[index] + dp[index + 1][0],  dp[index + 1][1]); 
           
                dp[index][0] = Math.max(prices[index] - fee + dp[index + 1][1],  dp[index + 1][0]);
            
        }
        
        return dp[0][1];
    }
    
    //using recursion
    public int solve(int[] prices, int index, int buy,int fee){
        
        if(index == prices.length)return 0;
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[index] + solve(prices, index + 1, 0, fee), solve(prices, index + 1, 1, fee)); 
        }else{
            profit = Math.max(prices[index] - fee + solve(prices, index + 1, 1, fee), solve(prices, index + 1, 0, fee));
        }
        
        return profit;
    }
}