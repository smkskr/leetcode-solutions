class Solution {
    public void moveZeroes(int[] nums) {
        
        int n = nums.length;
        int zeroPointer = 0;
        for(int i = 0;i < n;i++){
            
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[zeroPointer];
                nums[zeroPointer] = temp;
                zeroPointer++;
            }
        }
        
    }
}