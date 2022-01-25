class Solution {
    
    int product = 1;
    
    public int integerBreak(int n) {
        return solve(n - 1 ,n);
    }
    
    public int solve(int start, int n){
        
        if(start == 0)return 0;
        if(n == 0)return 1;
       
        if(start <= n){
            
          return Math.max(start * solve(start, n - start),solve(start - 1, n));
        }else{
            return  solve(start - 1, n);
        }
        
    }
}