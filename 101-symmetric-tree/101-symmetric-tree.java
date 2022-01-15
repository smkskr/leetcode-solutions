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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        
        return isSymmetricUtil(root.left, root.right);
    }
    
    public boolean isSymmetricUtil(TreeNode leftSubTree, TreeNode rightSubTree){
        
        if(leftSubTree == null || rightSubTree == null){
            return leftSubTree == null && rightSubTree == null;
        }
        if(leftSubTree.val != rightSubTree.val)return false;
        
        return isSymmetricUtil(leftSubTree.left,rightSubTree.right) && isSymmetricUtil(leftSubTree.right,rightSubTree.left);
        
    }
        
        
}