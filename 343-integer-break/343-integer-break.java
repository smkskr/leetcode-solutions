class Solution {
    public int integerBreak(int n) {
        
        int[][] dp = new int[n][n + 1];
       // Arrays.fill(dp, 1);
        
        for(int row = 0;row < n;row++){
            dp[row][0] = 1;
        }
        
        
        for(int row = 1;row < n;row++){
            for(int col = 1;col <= n;col++){
                
                if(row <= col){
                    dp[row][col] = Math.max(row * dp[row][col - row], dp[row - 1][col]);
                }else{
                    dp[row][col] = dp[row - 1][col];
                }
            }
        }
      return dp[n - 1][n];
      // return solve(n - 1, n);
    }
    
    public int solve(int n, int target){
        
        if(target == 0)return 1;
        if(n == 0)return 0;
        
       
        if(n <= target){
            return Math.max(n * solve(n, target - n),solve(n - 1,target));
        }else{
            return solve(n - 1, target);
        }
    }
}