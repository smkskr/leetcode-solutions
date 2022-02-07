class Solution {
    public int nthUglyNumber(int n) {
        
        int[] dp = new int[n];
        
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        
        int factor2Count = 0;
        int factor3Count = 0;
        int factor5Count = 0;
        
        int uglyNum = 1;//first factor
        dp[0] = uglyNum;
        int index = 1;
        
        while(index < n){
            
            uglyNum = Math.min(factor2, Math.min(factor3, factor5));
            dp[index++] = uglyNum;
            
            if(uglyNum == factor2){
                factor2Count++;
                factor2 = dp[factor2Count] * 2;
            }
            if(uglyNum == factor3){
                factor3Count++;
                
                factor3 = dp[factor3Count] * 3;
            }
            if(uglyNum == factor5){
                factor5Count++;
                factor5 = dp[factor5Count] * 5;
            }
            
        }
        
        return uglyNum;
    }
}