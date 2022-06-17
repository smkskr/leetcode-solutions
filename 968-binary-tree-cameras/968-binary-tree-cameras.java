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
    
    int cameras = 0;
    Set<TreeNode> covered = new HashSet<>();
    public int minCameraCover(TreeNode root) {
        covered.add(null);
        placeCameras(root, null);
        return cameras;
    }
    
    public void placeCameras(TreeNode root, TreeNode parent){
        
        if(root != null){
        placeCameras(root.left, root);
        placeCameras(root.right, root);
        
        if((parent == null && !covered.contains(root)) || !covered.contains(root.left) || !covered.contains(root.right)){
           
            cameras++;
            covered.add(root);
            covered.add(parent);
            covered.add(root.left);
            covered.add(root.right);
        }
        }
       
        
       
    }
}