class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1;i <= amount;i++){
            for(int coin = 0;coin < coins.length;coin++){
                if(coins[coin] <= i){
                    if(dp[i - coins[coin]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[coin]]);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        
        //return recursiveCode(coins, amount);
       
    }
    
    public int recursiveCode(int[] coins, int amount){
        
        if(amount == 0)return 0;
        
        int res = Integer.MAX_VALUE;
        for(int coin = 0;coin < coins.length;coin++){
            
            int subRes;
            if(coins[coin] <= amount){
                subRes  = recursiveCode(coins, amount - coins[coin]);
                if(subRes != Integer.MAX_VALUE){
                    res = Math.min(res, 1 + subRes);
                }
              
            }
            
             
           
            
            
        }
        
        return res;
    }
}