class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int len = s.length();
        
        String reverse = reverse(s);
        
        if(len == 0 || len == 1)return len;
        
        int[][] dp = new int[len + 1][len + 1];
        
        for(int row = 1;row <= len;row++){
            for(int col = 1;col <= len;col++){
                
                if(s.charAt(row - 1) == reverse.charAt(col - 1)){
                    dp[row][col] = 1 + dp[row-1][col-1];
                }else{
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        
        return dp[len][len];
        
    }
    
    public String reverse(String word){
        
        char[] arr = word.toCharArray();
        
        int startIndex = 0;
        int endIndex = arr.length - 1;
        
        while(startIndex < endIndex){
            
            char temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        
        return String.valueOf(arr);
    }
}