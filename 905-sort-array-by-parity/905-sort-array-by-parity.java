class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int n = nums.length;
        int oddPointer = n - 1;
        int evenPointer = 0;
        
        while(evenPointer <= oddPointer){
            
            if(nums[evenPointer]%2 != 0)//if it is odd
            {
                int temp = nums[oddPointer];
                nums[oddPointer] = nums[evenPointer];
                nums[evenPointer] = temp;
                oddPointer--;
            }else{
                evenPointer++;
            }
        }
        
        return nums;
    }
    
}