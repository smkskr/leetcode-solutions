class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1]; //array for storing minimum number of coins for a particular amount
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for(int amt = 1;amt < dp.length;amt++){
            for(int coin = 0;coin < coins.length;coin++){
                
                if(coins[coin] <= amt){
                    if(dp[amt - coins[coin]] != Integer.MAX_VALUE)
                    dp[amt] = Math.min(dp[amt],1 + dp[amt - coins[coin]]);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        
        /**
        * recursive call
        int res = solve(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
        */
    }
    
    //recursive solution
    public int solve(int[] coins, int amount){
        
        if(amount == 0)return 0;
        
        int res = Integer.MAX_VALUE;
        
        for(int i = 0;i < coins.length;i++){
            
            int sub_res;
            if(coins[i] <= amount){
                sub_res = solve(coins, amount - coins[i]);
                if(sub_res != Integer.MAX_VALUE)
                res = Math.min(res, 1 + sub_res);
            }
        }
        
        return res;
        
    }
}