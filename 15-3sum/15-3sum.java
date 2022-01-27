class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
     
        int len = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<List<Integer>> set = new HashSet<>();//to store unique sets
        Arrays.sort(nums);
        for(int i = 1;i < len;i++){
            map.put(nums[i],i);
        }
        
        List<List<Integer>> result = new ArrayList<>();
       
        for(int i = 0;i < len - 2;i++){
            
           
            int count = 0;
            
            // Reducing 3 sum problem to 2 sum problem
            // nums[i] + nums[j] + nums[k] = 0 , therefore nums[k] = - nums[i] - nums[j]
            for(int j = i + 1; j < len;j++){
                
                int target = - nums[i] - nums[j];
                
                if(map.containsKey(target)){
                    
                    int val = map.get(target);
                    
                    if(val > j) {
                        
                        List<Integer> list = new ArrayList<>();
                        
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[val]);
                        set.add(list);//adding list to set to remove duplicate values
                        
                        
                    }
                    
                }
            }
            
            map.remove(nums[i]);
        }
        
        
       
        
        return new ArrayList<>(set);
    }
}