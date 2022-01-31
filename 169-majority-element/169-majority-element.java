class Solution {
    public int majorityElement(int[] nums) {
        
        int element = nums[0];
        int count = 1;
        
        for(int num : nums){
            if(num == element)count++;
            else count--;
            if(count == 0){
                element = num;
                count = 1;
            }
        }
        
        return linearSearch(nums, element);
    }
    
    public int linearSearch(int[] nums, int target){
        
        int count = 0;
        
        for(int num : nums){
            
            if(target == num)count++;
           
        }
         if(count > nums.length/2)return target;
        return 0;
    }
}