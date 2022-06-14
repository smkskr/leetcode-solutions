//find the longest subsequence and subtract it from both the length of the strings and add their sum
class Solution {
    public int minDistance(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        int longestSubsequence = longestSubsequenceCache(word1, word2, len1, len2);
        //int longestSubsequence = longestSubsequenceRecursion(word1, word2, len1, len2);
        return (len1 + len2 - 2*longestSubsequence);
    }
    
    //longest common subsequence using cache
    public int longestSubsequenceCache(String word1, String word2, int len1, int len2){
        
        
        int[][] cache = new int[len1 + 1][len2 + 1];
        
        for(int row = 1;row <= len1;row++){
            for(int col = 1;col <= len2;col++){
                 if(word1.charAt(row - 1) == word2.charAt(col - 1)){
                     cache[row][col] = 1 + cache[row - 1][col - 1];
                 }
                else
                    cache[row][col] = Math.max(cache[row - 1][col], cache[row][col - 1]);
            }
        }
        
        return cache[len1][len2];
    }
    
    
    //longest common subsequence recursion
    public int longestSubsequenceRecursion(String word1, String word2, int index1, int index2){
        
        if(index1 == 0 || index2 == 0)return 0;
        
        if(word1.charAt(index1 - 1) == word2.charAt(index2 - 1)){
            return 1 + longestSubsequenceRecursion(word1, word2, index1 - 1, index2 - 1);
        }
        else
            return Math.max(longestSubsequenceRecursion(word1, word2, index1 - 1, index2),longestSubsequenceRecursion(word1, word2, index1, index2 - 1));
    }
}