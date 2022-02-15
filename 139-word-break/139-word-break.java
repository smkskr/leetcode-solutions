class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<>();
        int len = s.length();
        
        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[len];
        
        for(String word : wordDict){
            set.add(word);
        }
        
        for(int i = 0;i < len;i++){
            for(int j = 0;j <= i;j++){
                String curr = s.substring(j,i+1); 
                if((j == 0 || dp[j - 1]) && set.contains(curr)){
                    dp[i] = true;
                    break;   
                }
            }
        }
        
       return dp[len - 1];
        //return solve(s, "",0,set); 
    }
    
    public boolean solve(String s, String curr, int index, Set<String> set){
        
       
        if(index == s.length()){
            return curr == "";
        }
        
        char ch = s.charAt(index);
        curr = curr + ch;
        if(set.contains(curr)){
            return solve(s,"",index + 1,set) || solve(s, curr, index + 1,set);
        }else{
            return solve(s, curr, index + 1,set);
        }
    }
}