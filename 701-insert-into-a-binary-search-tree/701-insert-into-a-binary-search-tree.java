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
    public TreeNode insertIntoBST(TreeNode root, int val) {
       
        if(root == null)return new TreeNode(val);
        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }else{
            root.right = insertIntoBST(root.right, val);
        }
        
        return root;
    }
    
    //another method if the above method is not intuitive just call this method by replacing code
    //from line 20 to 24;
    public void solve(TreeNode root, int val){
         if(root == null){
            return;
        }
        if(val < root.val){
            if(root.left == null){
                root.left = new TreeNode(val);
                return;
            }
            insertIntoBST(root.left, val);
        }else{
            if(root.right == null){
                root.right = new TreeNode(val);
                return;
            }
            insertIntoBST(root.right, val);
        }
        
        
    }
}