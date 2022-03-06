class Solution {
    public int[] countBits(int n) {
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        
        for(int i = 1; i<= n;i++){
            int quotient = i / 2;
            if(i%2 == 0){
                dp[i] = dp[quotient];
            }else{
                dp[i] = dp[quotient] + 1;
            }
        }
        
            return dp;
       
    }
    
    //small three line code
    public int[] countBitsShortCode(int n){
        
        int[] dp = new int[n + 1];
        
        for(int i = 0;i <=n;i++){
          dp[i] = dp[i/2] + i%2;
        }
        
        return dp;
        
    }
    
   
}