class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        int start = 0;
        
        while(start < n){
            
            int correctIndex = nums[start] - 1;
            if((nums[start] < n && nums[start] > 0) && nums[start] != nums[correctIndex]){
                swap(nums, start, correctIndex);
            }else{
                start++;
            }
        }
        
        int index;
        //search for the first missing number
        for(index = 0;index < n;index++){
            if(nums[index] != index + 1)return index + 1;
        }
        
        //if index value reaches to the last index of the array
        //then the first missing value is 1 + length of the array
        if(index == n)return 1 + n;
        
        
        return n;
    }
    
    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}


