class Solution {
    public int integerBreak(int n) {
        
//         int[] dp = new int[n + 1];
//         dp[0] = 1;
//         dp[1] = 1;
//         dp[2] = 1;
        
//         for(int value = 3;value <= n;value++){
//             int subRes = 1;
//             int target = value;
//             for(int i = 1;i < n;i++){
//                 if(i <= value){
//                     subRes = i * dp[target - i];
//                     target = target - i;
//                 }
                
//             }
//             dp[value] = Math.max(dp[value], subRes);
//         }
        
      // return dp[n];
       return solve(n - 1, n);
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