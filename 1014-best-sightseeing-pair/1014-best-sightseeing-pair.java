class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int len = values.length;
        int maxI = 0, max = 0;
        for(int i = 0; i < len - 1;i++){
            
            maxI = Math.max(maxI, values[i] + i);
            max = Math.max(max, maxI + values[i + 1] - (i + 1));
            
        }
        
        return max;
            
            
    }
}