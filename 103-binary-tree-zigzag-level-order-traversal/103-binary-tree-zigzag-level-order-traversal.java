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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int level = 0;
        
        while(!queue.isEmpty()){
            
            level++;
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < size;i++){
                
                TreeNode curr = queue.poll();
                
                if(level%2 == 0)list.add(0, curr.val);
                else list.add(curr.val);
                
                if(curr.left != null)queue.add(curr.left);
                if(curr.right != null)queue.add(curr.right);
                
            }
            result.add(list);
            
        }
        
        return result;
    }
}