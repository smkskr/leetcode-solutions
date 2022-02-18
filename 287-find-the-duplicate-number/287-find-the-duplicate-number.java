class Solution {
    public int findDuplicate(int[] nums) {
        
        int n = nums.length;
        int val = 0;
        for(int i = 0;i < n;i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
               val = Math.abs(nums[i]);break;
            }
            nums[index] *= -1;
        }
        
        return val;
    }
    
}