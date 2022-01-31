//This is a sliding window problem(since it contains operations related to subarray) with variable size window
class Solution {
    public int subarraySum(int[] nums, int k) {
        
     HashMap<Integer, Integer> freqMap = new HashMap<>();
     int len = nums.length;
     int sum = 0;
     int count = 0;
        
     for(int index = 0;index < len;index++){
        
         sum = sum + nums[index];
         if(sum == k){
             count++;
         }
         if(freqMap.containsKey(sum - k)){
            count = count + freqMap.get(sum - k);
         }
         freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);
         
     }
        
     return count;
       
    }
}