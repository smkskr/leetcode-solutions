class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        return usingDP(prices, n);
        //return solve(prices, 0, 1, 2);   
    }
    
    //using dp
    public int usingDP(int[] prices, int n){
        
        int[][][] dp = new int[n+1][2][3];
        
        for(int index = n - 1; index >= 0;index--){
            for(int cap = 1;cap < 3;cap++){
                dp[index][1][cap] =  Math.max(-prices[index] + dp[index + 1][0][cap], dp[index + 1][1][cap]);
                dp[index][0][cap] =  Math.max(prices[index] + dp[index + 1][1][cap - 1], dp[index + 1][0][cap]);
            }
            
        }
        
        return dp[0][1][2];
    }
    
    //using recursion
    public int solve(int[] prices,int index, int buy, int cap){
		
		if(index == prices.length)return 0;
		if(cap == 0)return 0;
		
		int profit = 0;
		if(buy == 1){
			profit = Math.max(-prices[index] + solve(prices, index + 1, 0, cap), solve(prices, index + 1, 1,cap));
		}else{
			profit = Math.max(prices[index] + solve(prices, index + 1, 1, cap - 1), solve(prices, index + 1, 0,cap));
		}
		
		return profit;
	}
}