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
        
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        
        int leftPointer = 0;
        int rightPointer = list.size() - 1;
        
        while(leftPointer < rightPointer){
            
            if(list.get(leftPointer) + list.get(rightPointer) == k)return true;
            if(list.get(leftPointer) + list.get(rightPointer) < k){
                leftPointer++;
            }else{
                rightPointer--;
            }
            
        }
        
        return false;
    }
    
    public void inorderTraversal(TreeNode root, List<Integer> list){
        
        if(root == null)return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);

    }
}