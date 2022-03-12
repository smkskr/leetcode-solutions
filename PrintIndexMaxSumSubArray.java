class Solution {
    
    
    public int[] maxSubArray(int[] nums) {
        
        //pointers to keep track of starting and ending index of an array
        int startIndex = 0;
        int endIndex = 0;
        int globalStartIndex = 0;//this pointer keeps track of the starting index of the largest sum subarray
        
        int sum = nums[0];
        int maxSum = nums[0];
        
        for(int i = 1;i < nums.length;i++){
            
            
            if(sum + nums[i] < nums[i]){
                //if the current element is greater than the current sum,then update the starting index to current index
                //because the new possible max sum will start from this index
                startIndex = i; 
                sum = nums[i];
            }else{
                sum = sum + nums[i];
            }
            
            if(sum > maxSum){
                maxSum = sum;
                //if current sum is greater than max Sum, then update the end index to the current index 
                //because the new max sum will end at this index
                endIndex = i;
                //also update the global start index to the start index updated earlier, as this will be the
                //answer for the start index of maximum subarray
                globalStartIndex = startIndex;
            }
        }
        
        int[] indices = new int[2];
        indices[0] = globalStartIndex;
        indices[1] = endIndex;
        return indices;
    }
}
