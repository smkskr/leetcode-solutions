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
    
    //TreeNode resultTree, temp;
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        return mergeTreesUtil(root1, root2);
        //return resultTree;
    }
    
    public TreeNode mergeTreesUtil(TreeNode root1, TreeNode root2){
        
        if(root1 == null)return cloneSubTree(root2);
        if(root2 == null)return cloneSubTree(root1);
        
        TreeNode resultTree = new TreeNode(root1.val + root2.val);
        resultTree.left = mergeTreesUtil(root1.left, root2.left);
        resultTree.right = mergeTreesUtil(root1.right, root2.right);
        
        return resultTree;
    }
    
    public TreeNode cloneSubTree(TreeNode root){
        
        if(root == null)return null;
            
        TreeNode resultTree = new TreeNode(root.val);
        resultTree.left = cloneSubTree(root.left);
        resultTree.right = cloneSubTree(root.right);
        
        return resultTree;
    }
}