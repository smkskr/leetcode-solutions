class Solution {
    public int findMaxLength(int[] nums) {
        
        int len = nums.length;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        
        //replace all zeros with minus 1(-1)
        for(int i = 0;i < len;i++){
            if(nums[i] == 0)
                nums[i] = -1;
        }
        
        //Now the problem reduces to find the maximum length of the subarray having sum zero
        //since zeros have been replaced with -1, therefore equal number of ones and zeros will give the sum as zero
        
        int sum = nums[0];
        int maxLen = 0;
        sumMap.put(sum, 0);
        
        for(int index = 1;index < len;index++){
            
            sum += nums[index];
           
            if(sum == 0){
                 sumMap.put(sum, index);
                maxLen = Math.max(index + 1,maxLen);
            }
            else if(sumMap.containsKey(sum)){
                int val = sumMap.get(sum);
                maxLen = Math.max(maxLen, index - val);
            }else{
                 sumMap.put(sum, index);
            }
        }
        
        return maxLen;
    }
}