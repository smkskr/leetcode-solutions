class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, 0,result, new ArrayList<>());
        return result;
    }
    
    public void solve(int[] nums,int index,List<List<Integer>> result, List<Integer> temp){
        
        if(index == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(nums[index]);
        solve(nums, index + 1, result,temp);
        temp.remove(temp.size() - 1);
        solve(nums,index + 1,result,new ArrayList<>(temp));
        
        
    }
}