class Solution {
    public void sortColors(int[] nums) {
        
       int leftPointer = 0;
       int rightPointer = nums.length - 1;
       int index = 0;
        
       while(index <= rightPointer){
           
           if(nums[index] == 0){
               swap(nums, leftPointer, index);
               leftPointer++;index++;
           }else if(nums[index] == 2){
               swap(nums, rightPointer, index);
               rightPointer--;
           }else{
               index++;
           }
       }
        
        
    }
    
    public void swap(int[] nums, int index1, int index2){
        int cache = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = cache;
    }
}