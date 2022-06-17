class Solution {
    public String longestPalindrome(String s) {
        
        //return solvingUsingDP(s);//solving using DP similar to Palindrome Partitioning :: TC -> n^2 : SC -> n^2
        return solvingExpandingAroundCenter(s);//solving expanding around center :: TC -> n^2 : SC -> constant
    }
    
    
    //solving using DP approach
    public String solvingUsingDP(String s){
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
    
    //solving using expanding around center
    public String solvingExpandingAroundCenter(String s){
        
        int length = s.length();
        String[] resultString = new String[1];resultString[0] = "";
        for(int index = 0;index < length;index++){
            expandAroundCenterUtil(s, index, index, resultString);//for odd length palindromes
            expandAroundCenterUtil(s, index, index + 1, resultString);//for even length palidromes
        }
        
        return resultString[0];
        
    }
    
    public void expandAroundCenterUtil(String s, int left, int right, String[] resultString){
        
        String res = "";
        int resLen = 0;
        while((left >= 0 && right < s.length()) && s.charAt(left) == s.charAt(right)){
            if((right - left + 1) > resLen){
                res = s.substring(left, right + 1);
                resLen = right - left + 1;
            }
            left--;
            right++;
        }
        
        resultString[0] = resultString[0].length() > res.length() ? resultString[0] : res;
    }
}