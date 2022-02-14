//This problem can be solved in the same way as unbounded knapsack is solved
class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        
        //if amount is zero, then there is one way to make the sum zero
        for(int row = 0;row <= len;row++){
            dp[row][0] = 1;
        }
        
        //if there are no coins, then there is no way to make the sum
        for(int col = 0;col <= amount;col++){
            dp[0][col] = 0;
        }
        
        
        for(int row = 1;row <= len;row++){
            for(int col = 1;col <= amount;col++){
                 if(coins[row - 1] <= col){
                   dp[row][col] = dp[row][col - coins[row - 1]] + dp[row -1][col];
               }
              else{
                   dp[row][col] = dp[row - 1][col];
               }     
            }
        }
       
        return dp[len][amount];
        //function call for recursive code
        //return recursiveCode(coins, coins.length, amount);
    }
    
    public int recursiveCode(int[] coins, int n, int amount){
        
        if(amount == 0)return 1;
        if(n == 0)return 0;
        
        if(coins[n - 1] <= amount){
            return recursiveCode(coins, n, amount - coins[n - 1]) + recursiveCode(coins, n - 1, amount); 
        }else{
            return recursiveCode(coins,n - 1, amount);
        }
    }
}