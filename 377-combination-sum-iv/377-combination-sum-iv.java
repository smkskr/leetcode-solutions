class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int len = nums.length;
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int i = 1;i <= target;i++){
            for(int j = 0;j < len;j++){
                
                if(nums[j] <= i)
                dp[i] = dp[i] + dp[i - nums[j]];
            }
        }
        
        return dp[target];
        //return solve(nums, target);
    }
    
    //recursive solution
    public int solve(int[] nums, int target){
        
        if(target < 0)return 0;
        if(target == 0)return 1;
        
        int res = 0;
        
        for(int i = 0;i < nums.length;i++){
            
            if(nums[i] <= target){
                res += solve(nums,target - nums[i]);
            }
        }
        
        return res;
    }
}