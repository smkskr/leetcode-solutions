class Solution {
    public int singleNumber(int[] nums) {
        
        int result = 0;
        
        // The idea here is to take XOR of each and every element.
        // But why XOR ? 
        // XOR has the property of returning value zero whenever two bits are same, 
        // hence whenever a number is XOR'd with it's duplicate number it returns as 0
        // and therefor the only element which is not present twice will not be cancelled out with XOR
        // and will give the result
        for(int num : nums){
            result ^= num; 
        }
        
        return result;
    }
}