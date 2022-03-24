class Solution {
    public int countOdds(int low, int high) {
        
        if(low%2 == 0)low++;
        
        int diff = high - low;
        if(diff < 0)return 0;
        return diff/2 + 1;
    }
}

