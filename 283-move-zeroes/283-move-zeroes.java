class Solution {
    public void moveZeroes(int[] nums) {
        
        int n = nums.length;
        int zeroPointer = 0;
        for(int i = 0;i < n;i++){
            
            //if the number is not zero then swap it with zero value in the array
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[zeroPointer];
                nums[zeroPointer] = temp;
                zeroPointer++;
            }
        }
        
    }
    
    //another approach
    public void moveZeroes2(int[] nums) {
        
        int len = nums.length;
        
        int index = 0;
        
        for(int i = 0;i < len;i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        
        while(index < len){
            nums[index] = 0;
            index++;
        }
            
            
    }
}