class Solution {
    
    
    public int lengthOfLIS(int[] nums) {
        
       int len = nums.length;
       int[] dp = new int[len];
       Arrays.fill(dp, 1);
       int maxLen = 0; 
       for(int i = 0;i < len;i++){
           
           for(int j = 0;j <= i;j++){
               if(nums[j] < nums[i]){
                   dp[i] = Math.max(dp[i],1 + dp[j]);
               } 
     
           }
           
           maxLen = Math.max(maxLen, dp[i]);
       }
        
        return maxLen;
       //return solve(nums, Integer.MAX_VALUE, len);
       
    }
    
    public int solve(int[] nums,int lastValue, int n){
        
        if(n == 0){
           return 0;
        }
        
       
        if(lastValue > nums[n - 1])
        return Math.max(1 + solve(nums, nums[n - 1], n - 1), solve(nums, lastValue, n - 1));
        else
        return solve(nums, lastValue, n - 1);
        
       
       
    }
}