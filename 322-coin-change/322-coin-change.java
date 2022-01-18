class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        int[] dp = new int[amount + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        
        for(int i = 1;i <= amount;i++){
            
            for(int j = 0;j < n;j++){
                
                if(coins[j] <= i)
                   
                dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        
        /*
        *
        * To be used when calling recursive function
        *
        int res = solve(coins, coins.length, amount);
        return res == Integer.MAX_VALUE - 1 ? -1 : res;
        */
        
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
    
    
    //recursive function
    public int solve(int[] coins, int n, int amount){
        
       if(amount == 0)return 0;
       
        
        int result = Integer.MAX_VALUE -1 ;
        
        for(int i = 0; i < n; i++){
            
            //int subResult ;
            if(coins[i] <= amount){
               int subResult = solve(coins, n, amount - coins[i]);
                //if(subResult != Integer.MAX_VALUE){
                    result = Math.min(result, subResult + 1);
                //}
                
            }
        }
        
        return result;
    }
   
}