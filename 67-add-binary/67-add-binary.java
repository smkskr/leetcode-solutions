class Solution {
    public String addBinary(String a, String b) {
        
        int lengthA = a.length();
        int lengthB = b.length();
        
        int indexA = lengthA - 1;
        int indexB = lengthB - 1;
        
        StringBuilder sb = new StringBuilder();
        int[] charArr = new int[Math.max(lengthA,lengthB) + 1];
        int index = charArr.length - 1;
        int carry = 0;
        
        while(indexA >= 0 && indexB >= 0){
            
            int sum = (a.charAt(indexA--) - '0') + (b.charAt(indexB--) - '0') + carry; 
            sb.append(sum % 2);
            carry = sum / 2;
            
        }
        
        while(indexA >= 0){
            
            int sum = (a.charAt(indexA--) - '0') + carry; 
            sb.append(sum % 2);
            carry = sum / 2;
            
        }
        
        while(indexB >= 0){
            
            int sum = (b.charAt(indexB--) - '0') + carry; 
            sb.append(sum % 2);
            carry = sum / 2;
            
        }
        
        if(carry == 1)sb.append('1');
        return sb.reverse().toString();
        
    }
}