class Solution {
    public int numDecodings(String s) {
        
        char[] digits = s.toCharArray();
        int len = digits.length;
        if(len == 0 || digits[0] == '0')return 0;
        if(len == 1)return 1;
        return solve(digits, s.length());
    }
    
    public int solve(char[] digits, int n){
        
        if(n == 0 || n == 1) return 1;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        int count = 0;
        
        for(int i = 2;i <= n;i++){
             
            if(digits[i - 1] > '0')
            dp[i] = dp[i - 1];
        
             if((digits[i - 2] == '1') || (digits[i - 2] == '2' && digits[i - 1] < '7'))
             dp[i] += dp[i - 2];
        }
       
        
        return dp[n];
    }
}