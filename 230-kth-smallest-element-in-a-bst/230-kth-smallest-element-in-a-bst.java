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
    public int kthSmallest(TreeNode root, int k) {
        
        int[] val = new int[1];
        int[] count = new int[1];count[0] = 1;
        solve(root, k, count, val);
        return val[0];
    }
    
    public void solve(TreeNode root, int k,int[] count, int[] val){
        
        if(root == null)return;
        solve(root.left, k, count, val);
        if(count[0]++ == k){
            val[0] = root.val;
            return;
        }
        solve(root.right, k, count, val);
    }
}