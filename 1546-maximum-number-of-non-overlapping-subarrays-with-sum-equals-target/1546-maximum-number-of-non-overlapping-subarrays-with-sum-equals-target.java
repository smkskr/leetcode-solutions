//This problem is a variation of the problem subarray sum equals k and non-overlapping intervals
//https://leetcode.com/problems/subarray-sum-equals-k/
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        
        //map to store index of prefix sum
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        List<List<Integer>> intervals = new ArrayList<>();
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i < n;i++){
            
            sum += nums[i];
            if(sum == target){
                List<Integer> interval = new ArrayList<>();
                interval.add(0);
                interval.add(i);
                intervals.add(interval);
            }
            
            if(indexMap.containsKey(sum - target)){
                List<Integer> interval = new ArrayList<>();
                interval.add(indexMap.get(sum - target) + 1);
                interval.add(i);
                intervals.add(interval);
            }
            indexMap.put(sum,i);
        }
        
        
        return countNonOverLappingIntervals(intervals);
    }
    
    public int countNonOverLappingIntervals(List<List<Integer>> intervals){
        
        
        int size = intervals.size();
        if(size == 0)return 0;
        int interval = intervals.get(0).get(1);
        int count = 1;    
        for(int i = 1;i < size;i++){
            
            if(interval < intervals.get(i).get(0)){
                count++;
                interval = intervals.get(i).get(1);
            }
        }
        
        return count;
    }
}