class Solution {
    public void nextPermutation(int[] nums) {
        
        int len = nums.length;
        int firstDecreasingIndex = -1;
            
        //scan the array from last index to first index until the first decreasing element is found
        //but why the first decreasing element is searched for ?
        //because the first decreasing element needs to be swapped with the just next greater element than it
        //in order to make the next higher permutation
            
        for(int index = len - 1;index > 0;index--){
            if(nums[index] > nums[index - 1]){
                firstDecreasingIndex = index - 1;
                break;
            }
        }
        
        
        if(firstDecreasingIndex != -1){
            
             //find the next greater element
            int indexOfNextGreaterElement = findNextGreaterElement(nums, firstDecreasingIndex, len);
            //swapping of elements
            swap(nums,indexOfNextGreaterElement, firstDecreasingIndex);
            
            
        }
        
        //Now we need to reverse the array from the next index of first decreasing element to the last index
        //Why we do this ?
        //Reversing of array from first decreasing element to the last index gives us the next lexicographically greater number
        //what if we have not reversed it ? -> then there might be a number which might be not the next lexicographically greater                     //number 
        //eg. Next permutation of [2,4,3,1] -> [3,1,2,4] 
        //but if we don't reverse it after finding the next greater element
        //then [2,4,3,1] becomes [3,4,2,1] which is definitely not the next lexicographically greater number
        reverse(nums, firstDecreasingIndex + 1, len - 1);
        
       
    }
    
    public int findNextGreaterElement(int[] nums, int firstDecreasingIndex, int len){
        
        int maxValue = nums[firstDecreasingIndex + 1];
        int indexOfNextGreaterElement = firstDecreasingIndex + 1;
        
        for(int i = firstDecreasingIndex + 1;i < len;i++){
            maxValue = Math.max(maxValue, nums[i]);
            if(nums[i] > nums[firstDecreasingIndex] && nums[i] <= maxValue){
                indexOfNextGreaterElement = i;
            }
        }
        
        return indexOfNextGreaterElement;
    }
    
     public void reverse(int[] nums, int firstIndex, int lastIndex){
            
         while(firstIndex < lastIndex){
             swap(nums, firstIndex++, lastIndex--);
         }
     }
    
    public void swap(int[] nums, int firstIndex, int lastIndex){
        
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[lastIndex];
        nums[lastIndex] = temp;
    }
}