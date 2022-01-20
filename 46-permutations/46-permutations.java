class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, 0, nums.length - 1, result);
        return result;
    }
    
    public void solve(int[] nums, int left, int right, List<List<Integer>> result){
        
        if(left == right){
            result.add(new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList())));
            return;
        }
        for(int i = left;i < nums.length;i++){
                
            swap(nums, left, i);
            solve(nums, left + 1, right, result);
            swap(nums, left, i);
        }
        
    }
    public void swap(int[] nums, int left, int right){
        
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}