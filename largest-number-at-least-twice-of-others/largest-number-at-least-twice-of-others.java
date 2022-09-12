class Solution {
    public int dominantIndex(int[] nums) {
        
        int firstMax = nums[0];
        int secondMax = Integer.MIN_VALUE;
        int dominantIndex = 0;
        
        for(int index = 1;index < nums.length;index++){
            
            if(nums[index] > firstMax){
                secondMax = firstMax;
                firstMax = nums[index];
                dominantIndex = index;
            }
            else if(nums[index] > secondMax){
                secondMax = nums[index];
            }
        }
        
        if(firstMax >= secondMax * 2)return dominantIndex;
        return -1;
    }
}