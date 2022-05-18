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
    
    int prev = Integer.MIN_VALUE;
    public int minDiffInBST(TreeNode root) {
        
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        inOrderTraversal(root, min);
        return min[0];
    }
    
    public void inOrderTraversal(TreeNode root,int[] min){
        
        if(root == null)return;
        inOrderTraversal(root.left, min);
        if(prev != Integer.MIN_VALUE){
             min[0] = Math.min(min[0],root.val - prev);
        }
        prev = root.val;
        inOrderTraversal(root.right, min);
    }
}