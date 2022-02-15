class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int value = 1; value <= target;value++){
            for(int num = 0;num < nums.length;num++){
                if(nums[num] <= value){
                    dp[value] += dp[value - nums[num]];
                }
            }
        }
        
        return dp[target];
        //return recursiveCode(nums, target);
    }
    
    public int recursiveCode(int[] nums, int target){
        
        if(target == 0)return 1;
        if(target < 0)return 0;
        
        int res = 0;
        
        for(int i = 0;i < nums.length;i++){
            
            if(nums[i] <= target){
                res = res + recursiveCode(nums, target - nums[i]);
            }
        }
        
        return res;
    }
}