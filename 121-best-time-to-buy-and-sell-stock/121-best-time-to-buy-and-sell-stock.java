class Solution {
    public int maxProfit(int[] prices) {
        
        int buyPrice = prices[0];
        int maxProfit = 0;
        int len = prices.length;
        if(len == 0 || len == 1)return 0;
        
        for(int index = 1; index < len;index++){
            
            buyPrice = Math.min(buyPrice, prices[index]);
            maxProfit = Math.max(maxProfit, prices[index] - buyPrice);
            
        }
        
        return maxProfit;
    }
}