class Solution {
    public int trap(int[] height) {
        
        int len = height.length;
        
        int[] leftHighest = new int[len];
        int[] rightHighest = new int[len];
        int result = 0;
        
        // filling left highest bar for the particular element
        // the first element will be the highest for itself
        leftHighest[0] = height[0];
        for(int index = 1;index < len;index++){
            leftHighest[index] = Math.max(leftHighest[index - 1], height[index]); 
        }
        
        // filling right highest bar for the particular element
        // the last element will be the highest for itself
        rightHighest[len - 1] = height[len - 1];
        for(int index = len - 2;index >= 0;index--){
            rightHighest[index] = Math.max(rightHighest[index + 1], height[index]);
        }
        
        //Now sum up the differences of that element with it's minimum height from either side
        for(int index = 0;index < len;index++){
            result = result + Math.min(leftHighest[index],rightHighest[index]) - height[index];
        }
        
        return result;
    }
}