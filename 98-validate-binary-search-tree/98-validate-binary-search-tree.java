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
    public boolean isValidBST(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        
        for(int index = 1;index < list.size();index++){
            if(list.get(index) <= list.get(index - 1))return false;
        }
        
        return true;
    }
    
    public void inorderTraversal(TreeNode root, List<Integer> list){
        
        if(root == null)return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}