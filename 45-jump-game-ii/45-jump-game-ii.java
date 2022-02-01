class Solution {
    public int jump(int[] nums) {
        
        int N = nums.length;
        if(nums[0] == 0 || N == 1)return 0;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[N - 1] = 1;
        
        for(int i = N - 2;i >= 0;i--){
            if(nums[i] + i >= N - 1)dp[i] = 1;
            else{
                for(int j = 1;j <= nums[i];j++){
                    if(dp[i + j] != Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i], 1 + dp[j+i]);
                    }
                }
            }
        }
        
        return dp[0];
    }
}