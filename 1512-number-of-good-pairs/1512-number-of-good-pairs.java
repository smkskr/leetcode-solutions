class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        int[] countVal = new int[101];//since 1 <= nums[i] <= 100
        for(int num : nums){
            countVal[num]++;
        }
        
        int sum = 0;
        for(int val : countVal){
            int combinations = val*(val - 1)/2; // follow this formula nC2
            sum += combinations;
        }
        
        return sum;
    }
}


