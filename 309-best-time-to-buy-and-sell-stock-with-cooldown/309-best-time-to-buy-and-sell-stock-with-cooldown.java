class Solution {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        
        int[] stateCoolDown = new int[len];
        int[] stateBuy = new int[len];
        int[] stateSell = new int[len];
        
        stateCoolDown[0] = 0;
        stateBuy[0] = - prices[0];//since when you buy a stock your profit decreases
        stateSell[0] = 0;
        
        for(int i = 1;i < len;i++){
            
            stateCoolDown[i] = Math.max(stateCoolDown[i - 1], stateSell[i - 1]);
            stateBuy[i] = Math.max(stateBuy[i - 1], stateCoolDown[i - 1] - prices[i]);
            stateSell[i] = stateBuy[i - 1] + prices[i];
        }
        
        return Math.max(stateCoolDown[len - 1], stateSell[len - 1]);
    }
}