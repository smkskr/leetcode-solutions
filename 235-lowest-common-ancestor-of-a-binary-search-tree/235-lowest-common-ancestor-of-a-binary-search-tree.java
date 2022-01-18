/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
//         if(p.val > q.val){
            
//             lowestCommonAncestor(root, q, p);
//         }
        
        if(p.val == root.val || q.val == root.val){
            
            if(p.val < root.val || p.val > root.val){
                return q;
            }else{
                return p;
            }
        }
        
        if((p.val < root.val && q.val > root.val) || (q.val < root.val && p.val > root.val)){
            return root;
        }
        
        if((p.val < root.val && q.val < root.val) || (q.val < root.val && p.val > root.val)){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}