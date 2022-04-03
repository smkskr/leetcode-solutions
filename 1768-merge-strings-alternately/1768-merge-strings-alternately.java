/**
* This question is similar to merge sort
* 
*/
class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int pointer1 = 0;
        int pointer2 = 0;
        
        int len1 = word1.length();
        int len2 = word2.length();
        
        String res = "";
            
        while(pointer1 < len1 && pointer2 < len2){
            
            res = res + word1.charAt(pointer1++);
            res = res + word2.charAt(pointer2++);
            
        }
        
        if(pointer1 != len1)res = res + word1.substring(pointer1);
        else res = res + word2.substring(pointer2);
        
        return res;
    }
}