class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        
        for(int index = 0;index < n;index++){
            
            sum += nums[index];
            if(sum == k){
                count++;    
            }
            
            if(countMap.containsKey(sum - k)){
                count = count + countMap.get(sum - k);
            }
            
            countMap.put(sum, countMap.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}