class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int len = nums.length;
        int[] leftElementsProduct = new int[len]; // product of all the left elements except that element
        int[] rightElementsProduct = new int[len];// product of all the right elements except that element
        
        leftElementsProduct[0] = 1;
        rightElementsProduct[len - 1] = 1;
        
        //calculating left elements products
        for(int index = 1;index < len;index++){
            leftElementsProduct[index] = nums[index - 1] * leftElementsProduct[index - 1];
        }
        
        //calculating right elements products
        for(int index = len - 2;index >= 0;index--){
            rightElementsProduct[index] = nums[index + 1] * rightElementsProduct[index + 1];
        }
        
        // product of right and left elements will be the result
        for(int index = 0;index < len;index++){
            nums[index] = leftElementsProduct[index] * rightElementsProduct[index];
        }
        
        return nums;
    }
}