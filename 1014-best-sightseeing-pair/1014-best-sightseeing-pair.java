class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int len = values.length;
        int maxStart = 0;
        int maxOverall = 0;
        /*
        * calculating max values[i]+i except the last element as the last element cannot be used as the starting point
        * calculating maxOverall with sum of maxStart + values[i+1]-i+1 except the first element as the first element cannot be           * used as the ending point. we are doing i + 1 since ending point must be greater than starting point;
        */
        for(int i = 0;i < len - 1;i++){
            maxStart = Math.max(maxStart, values[i] + i);
            maxOverall = Math.max(maxOverall, maxStart + values[i+1] - (i + 1));
        }
        
        return maxOverall;
    }
}