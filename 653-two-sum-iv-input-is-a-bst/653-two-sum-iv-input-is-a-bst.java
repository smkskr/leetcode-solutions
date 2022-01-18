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
    public boolean findTarget(TreeNode root, int k) {
        
        HashSet<Integer> set = new HashSet();
        inorderTraversal(root, set);
        
        for(int num : set){
            if((k - num != num) && set.contains(k - num))return true;
        }
        
        return false;
    }
    
    public void inorderTraversal(TreeNode root, HashSet<Integer> set){
        
        if(root == null)return;
        inorderTraversal(root.left, set);
        set.add(root.val);
        inorderTraversal(root.right, set);

    }
}