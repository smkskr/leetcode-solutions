class Solution {
    public int[] countBits(int n) {
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        if(n == 0)return dp;
        dp[1] = 1;
        if(n == 1)return dp;
        dp[2] = 1;
        
        for(int i = 3;i <=n;i++){
            int quotient = i/2;
            if(i%2 == 1){  
                dp[i] = dp[quotient] + 1;
            }else{
                dp[i] = dp[quotient];
            }
        }
        
        return dp;
    }
    
   
}