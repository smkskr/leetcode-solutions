class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        //array to store count of values in the range of 0 to 100
        int[] countVal = new int[101];
        
        //keep count
        for(int num : nums){
            countVal[num]++;
        }
        
        //sum of the counts
        for(int index = 1;index < 101;index++){
            countVal[index] += countVal[index-1]; 
        }
        
        
        int[] ans = new int[nums.length];

        for(int index = 0;index < nums.length;index++){
            if(nums[index] == 0)ans[index] = 0;
            else ans[index] = countVal[nums[index]-1];
        }
        
        return ans;
    }
}