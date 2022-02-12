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
    public TreeNode searchBST(TreeNode root, int val) {
        
        return iterativeSolution(root, val);
        //return recursiveSolution(root, val);
    }
    
    //recursive solution
    public TreeNode recursiveSolution(TreeNode root, int val){
         if(root == null)return root;
        
        if(root.val == val)return root;
        
        if(val < root.val){
            return recursiveSolution(root.left, val);    
        }
        return recursiveSolution(root.right, val);
    }
    
    //iterative solution
    public TreeNode iterativeSolution(TreeNode root, int val){
        
        while(root != null){
            if(val < root.val){
                root = root.left;
            }else if(val > root.val){
                root = root.right;
            }else{
                break;
            }
        }
        
        return root;
    }
}