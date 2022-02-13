class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int length1 = text1.length();
        int length2 = text2.length();
        
        int[][] dp = new int[length1 + 1][length2 + 1];
        
        //bottom up approach
        for(int row = 0;row <= length1;row++){
            for(int col = 0;col <= length2;col++){
                if(row == 0 || col == 0)dp[row][col] = 0;
                else{
                    if(text1.charAt(row - 1) == text2.charAt(col - 1)){
                        dp[row][col] = 1 + dp[row - 1][col - 1];
                    }else{
                        dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                    }
                }
               
            }
        }
        
        return dp[length1][length2];
        /**
        *
        * Following lines need to be uncommented when calling memoization solution
        *
        for(int[] row : dp)
        Arrays.fill(row, -1);
        
        return LCS(text1, text2, text1.length(), text2.length(), dp);
        **/
    }
    
    
    
    //recursive solution using memoization(top - down)
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