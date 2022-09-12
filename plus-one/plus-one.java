class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        int carry = 1;
        for(int index = n - 1;index >= 0;index--){
            
            int num = digits[index] + carry;
            carry = num / 10;
            digits[index] = num % 10;
            
        }
        
        if(carry == 1){
            int[] result = new int[n + 1];
            result[0] = 1;
            for(int index = 1;index <= n;index++){
                result[index] = digits[index - 1];
            }
            return result;
        }
        
        return digits;
    }
    
    
    
}