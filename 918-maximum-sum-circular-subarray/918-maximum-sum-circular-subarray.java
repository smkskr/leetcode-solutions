class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        
        int len = nums.length;
        
        if(len == 0)return 0;
        if(len == 1)return nums[0];
        
        int maxSubArraySum = solveByKadane(nums, len);
        
        if(maxSubArraySum < 0)return maxSubArraySum;
        
        int totalSum = 0;
        
        for(int i = 0;i < len;i++){
            totalSum += nums[i];
            nums[i] = - nums[i];
        }
        
        int maxSubArrayCircularSum = solveByKadane(nums, len);
        
        return Math.max(maxSubArraySum, totalSum + maxSubArrayCircularSum);
        
    }
    
    public int solveByKadane(int[] nums,int len){
        
        
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i = 0;i < len;i++){
            
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(sum, maxSum);
            
        }
        
        return maxSum;
    }
}