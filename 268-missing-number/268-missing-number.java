class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        
        int start = 0;
        
        while(start < n){
            
            int correctIndex = nums[start];
            if(nums[start] < n && nums[start] != nums[correctIndex]){
                swap(nums, start, correctIndex);
            }else{
                start++;
            }
        }
        
        //CASE 1 : when missing number is within bounds of array
        for(int index = 0;index < n;index++){
            if(nums[index] != index)return index;
        }
        
        //CASE 2 : when missing number is outside of bounds
        return n;
        
        //Another approach to solve this problem
        //return usingXor(nums);
    }
    
    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    
    public int usingXor(int[] nums){
        
        int n = nums.length;
        int xor = 0;
        for(int i = 1;i <= n;i++){
            xor = xor ^ i;
        }
        
        for(int i = 0;i < n;i++){
            xor = xor ^ nums[i];
        }
        
        return xor;
    }
    
}