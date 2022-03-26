class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        if(s1.compareTo(s2) == 0)return true;
            
        int len1 = s1.length();
        int len2 = s2.length();
        
        char[] arrS1 = new char[2];
        char[] arrS2 = new char[2];
        
        int count = 0;
        
        for(int i = 0;i < len1;i++){
            
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            
           
            
            if(ch1 != ch2){
                
                if(count == 2)return false;
                arrS1[count] = ch1;
                arrS2[count] = ch2;
                count++;
            }
            
                 
        }
       
        if(arrS1[0] == arrS2[1] && arrS2[0] == arrS1[1])return true;
        return false;
       
    }
}