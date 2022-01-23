class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int length1 = text1.length();
        int length2 = text2.length();
        
        int[][] dp = new int[length1 + 1][length2 + 1];
        for(int[] row : dp)
        Arrays.fill(row, -1);
        
        return LCS(text1, text2, text1.length(), text2.length(), dp);
    }
    
    //recursive solution using memoization
    public int LCS(String text1, String text2, int length1, int length2, int[][] dp){
        
        if(length1 == 0 || length2 == 0)return dp[length1][length2] = 0;
        
        if(dp[length1][length2] != -1)return dp[length1][length2];
        
        if(text1.charAt(length1 - 1) == text2.charAt(length2 - 1)){
            dp[length1][length2] = 1 + LCS(text1, text2, length1 - 1, length2 -1, dp);
        }else{
            dp[length1][length2] = Math.max(LCS(text1, text2, length1, length2 - 1, dp), LCS(text1, text2, length1 - 1, length2, dp));
        }
        
        return dp[length1][length2];
    }
}