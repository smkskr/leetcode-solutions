class Solution {
    public int maxArea(int[] height) {
        
        int startIndex = 0;
        int endIndex = height.length - 1;
        int maxArea = 0;
        while(startIndex < endIndex){
            maxArea = Math.max(maxArea, Math.min(height[startIndex],height[endIndex]) * (endIndex - startIndex));
            if(height[startIndex] < height[endIndex]){
                startIndex++;
            }else{
                endIndex--;
            }
        }
       
        
        return maxArea;
    }
}