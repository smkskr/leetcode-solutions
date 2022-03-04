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
    
    int min;
    long secondMin = Long.MAX_VALUE;
    
    public int findSecondMinimumValue(TreeNode root) {
        
        if(root == null)return -1;
        min = root.val;
        solveUsingDFS(root);
        return secondMin == Long.MAX_VALUE ? -1 : (int)secondMin;
        
    }
    
    public void solveUsingDFS(TreeNode root){
        
        if(root == null)return;
        if(root.val > min && root.val < secondMin){
            secondMin = root.val;//update secondMin only when root.val is greater than min Value and less than secondMin value
        }
        /**
        * Since we know that the root.val is the minimum of its left child node value and its right child node value
        * Therefore we will only traverse the subtree with the minimum node value,
        * because the subtree having greater node value will only have elements atleast greater than or equal to itself.
        *
        */
        else if(min == root.val){
            solveUsingDFS(root.left);
            solveUsingDFS(root.right);
        }
    }
    
  
}