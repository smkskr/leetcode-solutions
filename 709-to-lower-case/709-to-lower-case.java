class Solution {
    
    public String toLowerCase(String s) {
        
        char[] charArr = s.toCharArray();
        int len = s.length();
        
        for(int index = 0;index < len;index++){
            
             int val =  charArr[index];
            
            if(val >= 65 && val <= 90){
                charArr[index] = (char)(val + 32);   
            }
            
        }
        return String.valueOf(charArr);
    }
}
    
    
    