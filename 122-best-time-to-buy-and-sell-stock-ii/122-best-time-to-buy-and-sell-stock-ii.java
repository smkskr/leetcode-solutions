class Solution {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        int profit = 0;
        
        for(int index = 1;index < len;index++){
            if(prices[index] > prices[index - 1]){
                profit += prices[index] - prices[index - 1];
            }
        }
        
        return profit;
    }
}