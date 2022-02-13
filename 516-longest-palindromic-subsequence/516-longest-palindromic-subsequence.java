class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int len = s.length();
        
        if(len == 0 || len == 1)return len;
        
        String reverseString = reverseString(s);
        
        int[][] dp = new int[len + 1][len + 1];
        
        for(int row = 1;row <= len;row++){
            for(int col = 1;col <= len;col++){
                if(s.charAt(row - 1) == reverseString.charAt(col - 1)){
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                }else{
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        
        return dp[len][len];
        
    }
    
    public String reverseString(String s){
        
        char[] array = s.toCharArray();
        int end = array.length - 1;
        String result = "";
        
        for(int index = end;index >= 0;index--){
            result = result + array[index];
        }
        
        return result;
    }
}