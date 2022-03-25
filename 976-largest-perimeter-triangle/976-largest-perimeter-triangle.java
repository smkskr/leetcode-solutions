class Solution {
    public int largestPerimeter(int[] nums) {
        
        // for a triangle to form
        // the necessary and sufficient condition is a + b > c
        // therefore sort the array in increasing order
        // then calculate the perimeter according to the condition mentioned above(a + b > c) 
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = len - 3;i >= 0;i--){
            
            if(nums[i] + nums[i + 1] > nums[i + 2]){
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        
        return 0;
    }
}