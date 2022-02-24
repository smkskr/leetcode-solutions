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
    public int sumNumbers(TreeNode root) {
        
        if(root == null)return 0;
        return solve(root, 0);
    }
    
    public int solve(TreeNode root, int sum){
        
        if(root == null)return 0;
        
        if(root.left == null && root.right == null){
            return sum*10 + root.val;
        }
        
        sum = sum*10 + root.val;
        int leftNum = solve(root.left, sum);
        int rightNum = solve(root.right, sum);
        
        return leftNum + rightNum;
    }
    
  
}