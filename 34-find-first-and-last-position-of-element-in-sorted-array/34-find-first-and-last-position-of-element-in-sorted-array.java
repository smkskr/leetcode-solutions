class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int first = binarySearchFirstPosition(nums, target);
        int last = binarySearchLastPosition(nums, target);
        
        int[] result = new int[2];
        result[0] = first;
        result[1] = last;
        
        return result;
    }
    
    public int binarySearchFirstPosition(int[] nums, int target){
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
           
            //if target is in left half
           if(nums[mid] > target){
               right = mid - 1;
           }
           //if target is in right half 
           else if(nums[mid] < target){
               left = mid + 1;
           }
          //if target is equal
           else {
               if(mid == 0 || nums[mid] == target && nums[mid - 1] != target){
                    return mid;
                }else{
                    right = mid - 1;
                }
           }
            
        }
        
        return -1;
    }
    
    public int binarySearchLastPosition(int[] nums, int target){
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            
            int mid = left + (right - left)/2;
            
            //if target is in first half
            if(nums[mid] > target){
                right = mid - 1;
            }
            //if target is in right half
            else if(nums[mid] < target){
                left = mid + 1;
            }
            //if target is equal
            else{
                if(mid == nums.length - 1 || nums[mid] == target && nums[mid + 1] != target){
                    return mid;
                }else{
                    left = mid + 1;
                }
            }
        }
        
        return -1;
    }
}