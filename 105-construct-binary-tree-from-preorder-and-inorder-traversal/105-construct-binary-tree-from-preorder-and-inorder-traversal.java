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
    
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int len = inorder.length;
        for(int index = 0;index < len;index++){
            indexMap.put(inorder[index],index);
        }
        
        return buildTreeUtil(preorder, inorder, 0, len - 1);
        
    }
    
    public TreeNode buildTreeUtil(int[] preorder, int[] inorder, int startIndex, int endIndex){
        
        if(startIndex > endIndex)return null;
        
        int val = preorder[preorderIndex++];
        TreeNode root = new TreeNode(val);
        
        int getIndex = indexMap.get(val);//get index of the value stored in inorder array
        
        root.left = buildTreeUtil(preorder, inorder, startIndex, getIndex - 1);
        root.right = buildTreeUtil(preorder, inorder, getIndex + 1, endIndex);
        
        return root;
    }
}