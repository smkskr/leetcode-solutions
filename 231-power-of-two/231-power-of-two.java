class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if(n == Integer.MIN_VALUE) return false;
        return n != 0 && (n & (n - 1)) == 0;
    }
}