class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int[][] prevProfit = new int[2][k + 1];
        int[][] currProfit = new int[2][k + 1];
        int n = prices.length;
        
        for(int index = n - 1;index >=0;index--){
            for(int buy = 0;buy < 2;buy++){
                for(int cap = 1;cap <= k;cap++){
                    
                    if(buy == 1){
                        currProfit[buy][cap] = Math.max(-prices[index] + prevProfit[0][cap], 0 + prevProfit[1][cap]);
                    }else{
                        currProfit[buy][cap] = Math.max(prices[index] + prevProfit[1][cap - 1], 0 + prevProfit[0][cap]);
                    }
                }
            }
            
            prevProfit = currProfit;
        }
        
        return currProfit[1][k];
    }
}