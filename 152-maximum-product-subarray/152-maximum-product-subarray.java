class Solution {
    public int maxProduct(int[] nums) {
        
        int len = nums.length;
        int maxProduct = nums[0];
        int result = nums[0];
        int minProduct = nums[0];
        
        for(int i = 1;i < len;i++){
            
            if(nums[i] < 0){
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            
            maxProduct = Math.max(maxProduct * nums[i], nums[i]);
            minProduct = Math.min(minProduct * nums[i], nums[i]);
            
            result = Math.max(result, maxProduct);
        }
        
        return result;
    }
}