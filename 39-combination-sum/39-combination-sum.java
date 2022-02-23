class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        int len = candidates.length;
        
        //array storing number of ways sum is possible..rows -> contain number of elements, cols -> contains the target sum
        //int[][] dp = new int[len + 1][target + 1];
        
       
        //if target == 0, then 1 solution is possible
        //therefore, all the elements in the first col is going to be 1
//         for(int row = 0;row <= len;row++){
//             dp[row][0] = 1;
//         }
        
//         for(int row = 1;row <= len;row++){
//             for(int col = 1;col <= target;col++){
                
//                 if(candidates[row - 1] <= col){
//                     dp[row][col] = dp[row][col - candidates[row - 1]] + dp[row - 1][col];
//                 }else{
//                     dp[row][col] = dp[row - 1][col];
//                 }
//             }
//         }
        
        //result.add(new ArrayList<>(Arrays.asList(dp[len][target])));
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
             //temp.remove(temp.size() - 1);
             solve(candidates, target, index - 1,result, new ArrayList<>(temp));
        }
    }
}