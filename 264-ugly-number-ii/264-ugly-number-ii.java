class Solution {
    public int nthUglyNumber(int n) {
        
        int[] dp = new int[n];
        dp[0] = 1;
        
        int i2 = 0, i3 = 0, i5 = 0;
        int nextMultipleOfTwo = 1 * 2;
        int nextMultipleOfThree = 1 * 3;
        int nextMultipleOfFive = 1 * 5;
        int uglyNo = 1;
        for(int i = 1;i < n;i++){
            
            uglyNo = Math.min(nextMultipleOfTwo, Math.min(nextMultipleOfThree, nextMultipleOfFive));
            
            dp[i] = uglyNo;
            
            if(uglyNo == nextMultipleOfTwo){
                i2++;
                nextMultipleOfTwo = dp[i2] * 2;
            }
            if(uglyNo == nextMultipleOfThree){
                i3++;
                nextMultipleOfThree = dp[i3] * 3;
            }
            if(uglyNo == nextMultipleOfFive){
                i5++;
                nextMultipleOfFive = dp[i5] * 5;
            }
        }
        
        return uglyNo;
    }
    
    
}