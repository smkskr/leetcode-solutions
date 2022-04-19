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
    public void recoverTree(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        Collections.sort(list);
        int[] index = new int[1];
        solve(root, list, index);
       
        
    }
    
    public void inorderTraversal(TreeNode root, List<Integer> list){
        
        if(root == null)return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
        
    }
    
    public void solve(TreeNode root, List<Integer> list, int[] index){
        
        if(root == null)return;
        solve(root.left, list, index);
        if(list.get(index[0]) != root.val){
            root.val = list.get(index[0]);         
        }
         index[0]++;
        solve(root.right, list, index);
    }
}