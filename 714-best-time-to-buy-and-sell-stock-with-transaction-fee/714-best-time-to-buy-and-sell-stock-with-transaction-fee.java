class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int len = prices.length;
        
        int buy = - prices[0];
        int sell = 0;
        
        for(int i = 1;i < len;i++){
            
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        
        return sell;
    }
}