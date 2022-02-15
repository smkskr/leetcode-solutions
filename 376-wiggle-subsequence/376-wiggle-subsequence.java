class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        int len = nums.length;
        
        int[][] dp = new int[len][2];

        //dp[i][0] => element is smaller
        //dp[i][1] => element is bigger
       
        int max = 0;
        for(int i = 0;i < len;i++){
            dp[i][0] = 1;dp[i][1] = 1;
            for(int j = 0;j <= i;j++){
                if(nums[j] < nums[i]){
                    dp[i][1] = Math.max(1 + dp[j][0], dp[i][1]);
                }else if(nums[j] > nums[i]){
                    dp[i][0] = Math.max(1 + dp[j][1], dp[i][0]);
                }
            }
            
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        
        return max;
        //return Math.max(solve(nums, Integer.MAX_VALUE, nums.length, true), solve(nums, Integer.MIN_VALUE, nums.length, false));
    }
    
    public int solve(int[] nums, int lastVal, int n, boolean up){
        
        if(n == 0)return 0;
        
        if(up){
            if(nums[n - 1] < lastVal){
                return Math.max(1 + solve(nums, nums[n - 1], n - 1, !up),solve(nums, lastVal, n - 1, up));
            }else{
                return solve(nums, lastVal, n - 1, up);
            }
        }else{
            if(nums[n - 1] > lastVal){
                return Math.max(1 + solve(nums, nums[n - 1], n - 1, !up),solve(nums, lastVal, n - 1, up));
            }else{
                return solve(nums, lastVal, n - 1, up);
            }
        }
    }
}