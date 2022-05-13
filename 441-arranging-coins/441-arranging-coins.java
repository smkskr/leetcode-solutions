class Solution {
    public int arrangeCoins(int n) {
        
        
        long start = 0;
        long end = n;
        int ans = 1;
        
        while(start <= end){
            
            long mid = start + (end - start)/2;
            long sum = sumOfFirstNNaturalNumbers(mid);
            if(n >= sum){
                ans = (int)mid; 
                start = mid + 1;
            }else{
                 end = mid - 1;
            }
        }
        
        return ans;
    }
    
    public long sumOfFirstNNaturalNumbers(long n){
        return n*(n+1)/2;
    }
}

