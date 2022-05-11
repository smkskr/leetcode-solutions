class Solution {
    public int mySqrt(int x) {
        
        if (x < 2) return x;
        
        int right = x / 2;
        int left = 1;
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left)/2;
            
            if((long)mid*mid == x)return mid;
            if ((long)mid*mid > x) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
        
        
    }
}

    
    
