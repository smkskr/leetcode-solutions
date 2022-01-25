class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int len = values.length;
        int maxStart = 0;
        int maxEnding = 0;
        /*
        * calculating max values[i]+i except the last element as the last element cannot be used as the starting point
        * calculating max values[j]-j except the first element as the first element cannot be used as the ending point
        */
        for(int i = 0;i < len - 1;i++){
            maxStart = Math.max(maxStart, values[i] + i);
            maxEnding = Math.max(maxEnding, maxStart + values[i+1] - (i + 1));
        }
        
        return maxEnding;
    }
}