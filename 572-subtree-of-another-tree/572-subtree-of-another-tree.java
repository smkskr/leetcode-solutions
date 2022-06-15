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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null)return subRoot == null;
        //if(root.val == subRoot.val)return ;
        return isSubTreeUtil(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
       
    }
    
    public boolean isSubTreeUtil(TreeNode root1, TreeNode root2){
        
        if(root1 == null || root2 == null)return root1 == null && root2 == null;
        if(root1.val != root2.val)return false;
        return isSubTreeUtil(root1.left, root2.left) && isSubTreeUtil(root1.right, root2.right);
    }
}