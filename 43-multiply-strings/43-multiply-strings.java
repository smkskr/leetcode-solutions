class Solution {
    public String multiply(String num1, String num2) {
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        int[] result = new int[len1 + len2];//length of product of two numbers are never greater than the sum of their respective lengths
        
        for(int i = len1 - 1;i >= 0;i--){
            for(int j = len2 - 1;j >= 0;j--){
                
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                int sum = result[i+j+1] + product;
                
                result[i+j+1] = sum % 10;
                result[i+j] += sum/10;
                
            }
        }
        
        StringBuilder output= new StringBuilder();
        for(int digit : result){
            if(output.length() != 0 || digit != 0)
            output.append(digit);
        }
        
        return output.length() == 0 ? "0" : output.toString();
    }
}