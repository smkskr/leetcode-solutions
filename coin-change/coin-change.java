class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;
        for(int value = 1;value <= amount;value++){
            
            for(int coin = 0;coin < coins.length;coin++){
                int subRes = 0;
                if(coins[coin] <= value){
                    subRes = cache[value - coins[coin]];
                    if(subRes != Integer.MAX_VALUE){
                        cache[value] = Math.min(cache[value], 1 + subRes);
                    }
                }
            }
        }
        
        
        return cache[amount] == Integer.MAX_VALUE ? -1 : cache[amount];
    }
}