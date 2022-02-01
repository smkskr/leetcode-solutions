class Solution {
    public String addStrings(String num1, String num2) {
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        if(len2 > len1)return addStrings(num2, num1);
       
        String result = "";
        int carry = 0;
        int sum = 0;
        
        
        while(len1 > 0 && len2 > 0){
            
            int digit1 = num1.charAt(len1 - 1) - '0';
            int digit2 = num2.charAt(len2 - 1) - '0';
            
            sum = digit1 + digit2 + carry;
            
            int digit = sum % 10;
            carry = sum / 10;
            
            result = digit + result;
            
            len1--;
            len2--;
            
        }
        
        while(len1 > 0){
            
            int digit = num1.charAt(len1 - 1) - '0';
            
            sum = digit + carry;
            carry = sum / 10;
            
            result = sum % 10 + result;
            
            len1--;
            
        }
        
        if(carry == 1){
            result = carry + result;
        }
        return result;
        
    }
}