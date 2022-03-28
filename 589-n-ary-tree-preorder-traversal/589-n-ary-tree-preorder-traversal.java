/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        
        List<Integer> res = new ArrayList<>();
        solve(res, root);
        return res;
    }
    
    public void solve(List<Integer> res, Node root){
        
        if(root == null)return;
        
        res.add(root.val);
        List<Node> children = root.children;
        for(int i = 0;i < children.size();i++){
            solve(res, children.get(i));
        }
    }
}