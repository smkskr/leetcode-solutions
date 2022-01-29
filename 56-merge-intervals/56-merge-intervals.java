class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length <= 1)return intervals;
        
        //sorting intervals in increasing order of first value
        Arrays.sort(intervals, (arr1,arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        
        int[] currentInterval = intervals[0];
        List<int[]> mergedArray = new ArrayList<>();
        mergedArray.add(currentInterval);
        
        for(int i = 1;i < intervals.length;i++){
            if(currentInterval[1] >= intervals[i][0]){
                currentInterval[1] = Math.max(currentInterval[1],intervals[i][1]);
            }else{
                currentInterval = intervals[i];
                mergedArray.add(currentInterval);
            }
        }
        
        return mergedArray.toArray(new int[mergedArray.size()][]);
    }
}