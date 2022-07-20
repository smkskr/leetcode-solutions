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
        
        if(node == null)return node;
        Map<Node, Node> visited = new HashMap<>();
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        return cloneUtil(node, newNode, visited);
    }
    
    public Node cloneUtil(Node node, Node newNode,Map<Node, Node> visited){
          
        for(Node neighbor : node.neighbors){
            
            if(visited.containsKey(neighbor)){
                newNode.neighbors.add(visited.get(neighbor));
                continue;
            }
            Node newNeighbor = new Node(neighbor.val);
            visited.put(neighbor, newNeighbor);
            newNode.neighbors.add(newNeighbor);
            cloneUtil(neighbor, newNeighbor, visited);
        }
        
        return newNode;
    }
}