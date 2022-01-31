class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int len = nums.length;
        //return withExtraSpace(nums, len);
        return withoutExtraSpace(nums);
    }
    
    //with extra space
    public boolean withExtraSpace(int[] nums, int len){
        
        int[] leftSmaller = new int[len];
        int[] rightGreater = new int[len];
        
        leftSmaller[0] = nums[0];
        //finding left smaller
        for(int index = 1;index < len;index++){
            leftSmaller[index] = Math.min(leftSmaller[index - 1], nums[index]);
        }
        
        rightGreater[len - 1] = nums[len - 1];
        //finding right greater
        for(int index = len - 2;index >= 0;index--){
            rightGreater[index] = Math.max(rightGreater[index + 1], nums[index]);
        }
        
        for(int index = 0;index < len;index++){
            if(nums[index] > leftSmaller[index] && nums[index] < rightGreater[index])return true;
        }
        
        return false;
    }
    
    //without extra space
    public boolean withoutExtraSpace(int[] nums){
        
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int num : nums){
            
            if(num <= firstMin)firstMin = num;
            else if(num <= secondMin)secondMin = num;
            else return true;
        }
        
        return false;
       
    }
}