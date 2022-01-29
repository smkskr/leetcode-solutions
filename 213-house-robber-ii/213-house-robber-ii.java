class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n == 0)return 0;
        if(n == 1)return nums[0];
        if(n == 2)return Math.max(nums[0], nums[1]);
        
        int withoutLast = sum(Arrays.copyOfRange(nums, 0, n - 1));
        int withoutFirst = sum(Arrays.copyOfRange(nums, 1, n));
        
        
        /**
        *
        * recursive function call
        
        int withoutLast = sum(Arrays.copyOfRange(nums, 0, n - 1), n - 1);
        int withoutFirst = sum(Arrays.copyOfRange(nums, 1, n), n - 1);
        */
        
        
        
        return Math.max(withoutFirst,withoutLast);
    }
    
    //dp method
    public int sum(int[] nums){
        
        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        
        for(int i = 2;i < n;i++){
            dp[i] = Math.max(dp[i - 1],nums[i] + dp[i - 2]);
        }
        
        return dp[n - 1];
    }
    
    //recursive method
    public int sum(int[] nums, int n){
        if(n <= 0)return 0;
        return Math.max(sum(nums, n - 1), nums[n - 1] + sum(nums, n - 2));
    }
    
  
}