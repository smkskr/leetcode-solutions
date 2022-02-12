class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int start = 0;
        int end = 0;
        int len = nums.length;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        
        while(end < len){
            
          sum += nums[end];
            
          while(sum >= target){
              minLen = Math.min(minLen,end - start + 1);
              sum = sum - nums[start];
              start++;
          }
            
          end++;
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}