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
    
    int maxLevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        solve(root, 1, result);
        
        //return result;//called for recursive solution
        return solveUsingBFS(root);
    }
    
    //recursive solution
    public void solve(TreeNode root, int level, List<Integer> result){
        
        if(root == null)return;
        
        if(maxLevel < level){
            maxLevel = level;
            result.add(root.val);
        }
        
        solve(root.right, level + 1, result);
        solve(root.left, level + 1, result);
    }
    
    //iterative solution
    public List<Integer> solveUsingBFS(TreeNode root){
         if(root == null)return new ArrayList<Integer>();  
        List<Integer> nodeVal = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                TreeNode currNode = queue.remove();
                if(size - i == 1){
                    nodeVal.add(currNode.val);
                }
                if(currNode.left != null)queue.add(currNode.left);
                if(currNode.right != null)queue.add(currNode.right);
                
            }
        }
        return nodeVal;
    }
}