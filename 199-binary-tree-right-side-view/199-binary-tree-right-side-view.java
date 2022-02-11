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
    
    int maxLevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        solve(root, 1, result);
        return result;
    }
    
    public void solve(TreeNode root, int level, List<Integer> result){
        
        if(root == null)return;
        
        if(maxLevel < level){
            maxLevel = level;
            result.add(root.val);
        }
        
        solve(root.right, level + 1, result);
        solve(root.left, level + 1, result);
    }
}