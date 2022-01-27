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
           
            // if sum == 0 then there are equal number of zeros and ones upto that index
            if(sum == 0){
                maxLen = Math.max(index + 1,maxLen);
            }
            // if the map contains the key/sum then there are equal number of zeros and ones from earlier position of the key                 // upto the current position
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