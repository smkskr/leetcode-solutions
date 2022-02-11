/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;
        List<Integer> list = new ArrayList<>();
        solve(root, targetSum, list, result);
        return result;
    }
    
    public void solve(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> result){
        
        
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                List<Integer> newList = new ArrayList<>();
                for(int num : list){
                    newList.add(num);
                }
                newList.add(root.val);
                result.add(newList);
            }  
            
            return;
            
        }
        
        list.add(root.val);      
        solve(root.left, targetSum - root.val, list, result); 
        solve(root.right, targetSum - root.val, list, result);
        list.remove(list.size() - 1);
    }
}