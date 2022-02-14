class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[len][len];
        
        // We only consider the upper half of the primary diagonal since palindrome elements are mirror of their half elements
        // In this algorithm we fill each cell diagonally starting with the primary diagonal as it represents the single element.
        // Each diagonal represents the length of the string...primary diagonal is length == 1 and as we go above,
        // length of the string increases.
        for(int gap = 0;gap < len;gap++){
            for(int index = 0;index + gap < len;index++){
                
                if(gap == 0)dp[index][index] = true;//filling all diagonals with value "true", as single elements are always palindrome;
                else if(gap == 1){
                    if(s.charAt(index) == s.charAt(index + gap)){
                        dp[index][index + gap] = true;
                        start = index;
                        end = index + gap;
                    }
                }else{
                    if(s.charAt(index) == s.charAt(index + gap) && dp[index + 1][index + gap - 1] == true){
                        dp[index][index + gap] = true;
                        start = index;
                        end = index + gap;
                    }
                }
            }
        }
        
        return s.substring(start, end + 1);
    }
}