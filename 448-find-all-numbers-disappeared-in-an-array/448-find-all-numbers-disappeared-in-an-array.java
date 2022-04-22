class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int n = nums.length;
        
        while(start < n){
            
            int correctIndex = nums[start] - 1;
            if(nums[start] != nums[correctIndex]){
                swap(nums, start, correctIndex);
            }else{
                start++;
            }
        }
        
        //search for the disappearing numbers
        for(int i = 0;i < n;i++){
            if(nums[i] != i + 1){
                result.add(i + 1);
            }
        }
        
        return result;
    }
    
    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}