/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null)return null;
        
        iterativeSolution(root);
        //recursiveSolution(root);
        
        return root;
    }
    
    public void recursiveSolution(Node root){
        if(root == null)return;
        
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
        }
        
        recursiveSolution(root.left);
        recursiveSolution(root.right);
        
        
    }
    
    public void iterativeSolution(Node root){
       
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
           
            
            for(int i = 1;i <= size;i++){
                
                 Node currNode = queue.poll();
                
                if(i < size)currNode.next = queue.peek();
                else currNode.next = null;
                
                if(currNode.left != null)queue.add(currNode.left);
                if(currNode.right != null)queue.add(currNode.right);
            }
        }
        
    }
    
    
}