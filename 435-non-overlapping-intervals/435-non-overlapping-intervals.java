class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        int len = intervals.length;
        if(len <= 1)return 0;
        
        Arrays.sort(intervals, (arr1,arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        int[] currentInterval = intervals[0];
        int count = 0;
       
        
        
        for(int index = 1;index < len;index++){
            if(intervals[index][0] < currentInterval[1]){
                currentInterval[1] = Math.min(currentInterval[1],intervals[index][1]);
                count++;
            }else{
                currentInterval = intervals[index];   
            }
        }
        
        return count;
    }
}