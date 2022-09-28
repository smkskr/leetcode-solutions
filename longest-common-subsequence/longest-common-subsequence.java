class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        return solve(text1, text2, text1.length(), text2.length());
    }
    
    public int solve(String text1, String text2, int len1, int len2){
        
        int[][] cache = new int[len1 + 1][len2 + 1];
        
        
        for(int index1 = 1;index1 <= len1;index1++){
            for(int index2 = 1;index2 <= len2;index2++){
                 if(text1.charAt(index1- 1) == text2.charAt(index2 - 1)){
            cache[index1][index2] = 1 + cache[index1 - 1][index2 - 1];
        }else{
                   cache[index1][index2] = Math.max(cache[index1 - 1][index2], cache[index1][index2 - 1]);    
                 }
       
            }
        }
        
        return cache[len1][len2];
       
    }
}