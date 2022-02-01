class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int totalSum = 0;
        
        int len = nums.length;
        
        int normalSubArraySum = solveByKadane(nums, len);
        
        if(normalSubArraySum < 0)return normalSubArraySum;
        
        //find minimum sum of the array and subtract it from the totalSum
        //to find minimum sum of the array we will again use Kadane by changing the sign of all the array elements
        //this will give us the maximum sum with signs reversed(which is the minimum sum with original sign)
        //now instead of subtracting it from totalSum we will add it since totalSum - (-minSum) = totalSum + minSum(maxSum with sign reversed)
        
        for(int i = 0; i < len;i++){
            totalSum += nums[i];
            nums[i] = - nums[i];
        }
        
        int minSubArraySumWithSignsReversed = solveByKadane(nums, len);
        
        return Math.max(normalSubArraySum, totalSum + minSubArraySumWithSignsReversed);
    }
    
    public int solveByKadane(int[] nums, int len){
        
        int maxSum = nums[0];
        int sum = nums[0];
        
        
        
        for(int i = 1;i < len;i++){
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(sum, maxSum);
        }
        
        return maxSum;
    }
}