class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();
        int start = 0,end = 0;
        boolean[][] dp = new boolean[len][len];
        
        for(int gap = 0;gap < len;gap++){
            
            for(int i = 0;i + gap < len;i++){
                
                if(gap == 0)dp[i][i+gap] = true;
                else if(gap == 1){
                    if(s.charAt(i) == s.charAt(i+gap)){
                        dp[i][i+gap] = true;
                        start = i;
                        end = i + gap;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(i+gap) && dp[i+1][i+gap-1] == true){
                        dp[i][i+gap] = true;
                        start = i;
                        end = i + gap;
                    }
                }
                
            }
        }
        //System.out.println(longestPalindromeUtil(0,s.length() - 1,s));
        return s.substring(start,end+1);
    }
    
    
    
    //recursive function to calculate the length of longest plaindromic substring
    public int longestPalindromeUtil(int b, int e, String s){
        
        if(b > e){
            return 0;
        }
        
        if(e == b)return 1;
        
        if(s.charAt(b) == s.charAt(e)){
            
            if(e - b == 1) return 2;
            return 2 + longestPalindromeUtil(b+1,e-1,s);
        }
        
        return Math.max(longestPalindromeUtil(b+1,e,s),longestPalindromeUtil(b,e-1,s));
    }
}