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
    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root == null)return 0;
        
        int[] sum = new int[1];
        
        solve(root, sum, false);
        
        return sum[0];
        
    }
    
    public void solve(TreeNode root, int[] sum,boolean left){
        
        if(root == null)return;
        
        if((root.left == null && root.right == null) && left == true)sum[0] += root.val;
        solve(root.left, sum,true);
        
        solve(root.right, sum,false);
        
    }
}