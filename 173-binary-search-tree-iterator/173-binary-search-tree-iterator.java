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
class BSTIterator {
    
    Stack<TreeNode> stack;
    TreeNode current;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        current = root;
    }
    
    public int next() {
        
        while(current != null){
            stack.push(current);
            current = current.left;
            
        }
        TreeNode node = stack.pop();
        if(node.right != null){
            current = node.right;
            while(current != null){
                 stack.push(current);
                current = current.left;
               
            }
        }
       
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty() || current != null ? true : false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */