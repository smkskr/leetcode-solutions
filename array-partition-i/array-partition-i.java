class Solution {
    public int arrayPairSum(int[] nums) {
       Arrays.sort(nums);
       int sum = 0;
       for(int index = 0;index < nums.length;index+=2){
           sum += Math.min(nums[index],nums[index+1]);
       }
    return sum;
    }
}