//This problem is a slight variation of coin change/Unbounded Knapsack
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        int len = candidates.length;
      
        solve(candidates, target, len - 1,result, new ArrayList<>());
        return result;
    }
    
    public void solve(int[] candidates, int target, int index,List<List<Integer>> result, List<Integer> temp){
        
        if(index == -1){
            if(target == 0){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        
        if(candidates[index] <= target){
            
            temp.add(candidates[index]);
            List<Integer> newTemp = new ArrayList<>(temp);
            temp.remove(temp.size() - 1);
            solve(candidates, target - candidates[index], index, result, newTemp);
            solve(candidates, target, index - 1,result,new ArrayList<>(temp));
        }else{
             solve(candidates, target, index - 1,result, new ArrayList<>(temp));
        }
    }
}