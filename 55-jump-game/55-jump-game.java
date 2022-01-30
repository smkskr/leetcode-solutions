class Solution {
    public boolean canJump(int[] nums) {
        
        int len = nums.length;
        int[] dp = new int[len];
        dp[len - 1] = 1;
        int target = len - 1;
        for(int index = len - 2;index >= 0;index--){
            if(nums[index] + index >= target){
                dp[index] = 1;
                target = index;
            }else dp[index] = 0;
        }
        
        return dp[0] == 1;
    }
}