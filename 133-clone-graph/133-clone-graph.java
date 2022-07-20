/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        Map<Node, Node> visited = new HashMap<>();
        return cloneUtil(node, visited);
    }
    
    public Node cloneUtil(Node node,Map<Node, Node> visited){
          
        if(node == null)return node;
        
        if(visited.containsKey(node))return visited.get(node);
        
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        for(Node neighbor : node.neighbors){
            
           
            Node newNeighbor = cloneUtil(neighbor, visited);;
            newNode.neighbors.add(newNeighbor);
           
        }
        
        return newNode;
    }
}