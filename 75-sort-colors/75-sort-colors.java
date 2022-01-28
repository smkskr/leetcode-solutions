class Solution {
    public void sortColors(int[] nums) {
       
        
        int index = 0;
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        
        while(index <= rightPointer){
            
            if(nums[index] == 0){
               swap(nums, leftPointer, index);
                leftPointer++;index++;
            }
            else if(nums[index] == 2){
                swap(nums, rightPointer, index);
                rightPointer--;
            }else 
            index++;
            
        }
        
    }
    
    public void swap(int[] nums, int pos1, int pos2){
        
         int temp = nums[pos1];
         nums[pos1] = nums[pos2];
         nums[pos2] = temp;
        
    }
}