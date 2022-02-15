class Solution {
    public int minDistance(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        //Filling out first row, when word1 is null
        for(int col = 0;col <= len2;col++){
            dp[0][col] = col;
        }
        
        //Filling out first column, when word2 is null
        for(int row = 0;row <= len1;row++){
            dp[row][0] = row;
        }
        
        
        for(int row = 1;row <= len1;row++){
            for(int col = 1;col <= len2;col++){
                
                if(word1.charAt(row - 1) == word2.charAt(col - 1)){
                    dp[row][col] = dp[row - 1][col - 1];
                }else{
                    dp[row][col] = 1 + Math.min(dp[row- 1][col - 1], Math.min(dp[row - 1][col],dp[row][col - 1]));
                }
            }
        }
        
        return dp[len1][len2];
        //return recursiveCode(word1, word2, word1.length(), word2.length());
    }
    
    public int recursiveCode(String word1, String word2, int len1, int len2){
        
        if(len1 == 0)return len2;//if len1 becomes zero, then remaining elements of len2 will the be number of operations
        if(len2 == 0)return len1;//if len2 becomes zero, then remaining elements of len1 will the be number of operations
        
        if(word1.charAt(len1 - 1) == word2.charAt(len2 - 1)){
            return recursiveCode(word1, word2, len1 - 1, len2 - 1);
        }else{
            
            return 1 + Math.min(recursiveCode(word1, word2, len1 - 1, len2 - 1),//replace
                                Math.min(recursiveCode(word1, word2, len1 - 1, len2), //delete
                                         recursiveCode(word1, word2, len1, len2 - 1)));//insert
        }
    }
}