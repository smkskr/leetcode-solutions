class Solution {
    public int numDecodings(String s) {
        
        int len = s.length();
        if(len== 0 || s.charAt(0) == '0')return 0;
        if(len == 1)return 1;
        
        //dp[i] means number of ways to decode at len 'i';
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int index = 2;index <= len;index++){
            
            if(s.charAt(index - 1) > '0'){
                dp[index] = dp[index - 1];
            }
            if((s.charAt(index - 2) == '1') || (s.charAt(index - 2) =='2' && s.charAt(index - 1) <'7')){
                dp[index] += dp[index - 2];
            }
        }
        
        return dp[len];
        //return solve(s, s.length());
    }
    
    public int solve(String s,int index){
        
        if(index == 0 || index == 1){
            return 1;
        }
        
        int count = 0;
        
        if(s.charAt(index - 1) > '0'){
            count = solve(s,index - 1);
        }
        if((s.charAt(index - 2) == '1') || (s.charAt(index - 2) == '2' && s.charAt(index - 1) < '7')){
            count += solve(s,index - 2);
        }
        
        return count;
       
    }
}