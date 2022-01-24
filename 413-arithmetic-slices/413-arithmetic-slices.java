class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        if(nums.length < 3)return 0;
        int len = nums.length;
        int res = 0;
        int count = 0;
        for(int i = 2;i < len;i++){
            
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                count++;
            }else{
                count = 0;
            }
            
            res += count;
        }
        
        return res;
        
    }
}