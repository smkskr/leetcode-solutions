// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

/* Steps to traverse boundary nodes of a binary tree
*  
* 1. Traverse all left boundary nodes except leaf nodes
* 2. Traverse all leaf nodes
* 3. Traverse all right boundary nodes except leaf nodes
*
*/
class Solution
{
	ArrayList <Integer> boundary(Node node)
	{   
	    ArrayList<Integer> result = new ArrayList<>();
	    if(node == null)return result;
	    result.add(node.data);
	    if(node.left == null && node.right == null)return result;
	    traverseLeftNodes(node.left, result);//left boundary nodes only
	    traverseLeafNodes(node, result);//leaf nodes only
	    traverseRightNodes(node.right, result);//right boundary nodes only
	    
	    return result;
	}
	
	//traverse only left nodes except leaf nodes
	public void traverseLeftNodes(Node root, ArrayList<Integer> result){
	    
	    if(root == null)return;
	    if(root.left == null && root.right == null)return;
	    
	    result.add(root.data);
	    if(root.left == null){
	        traverseLeftNodes(root.right,result);
	    }
	    traverseLeftNodes(root.left,result);
	}
	
	
	//traverse only leaf Nodes
	public void traverseLeafNodes(Node node, ArrayList<Integer> result){
	    
	    if(node == null)return;
	    if(node.left == null && node.right == null)result.add(node.data);
	    
	    traverseLeafNodes(node.left,result);
	    traverseLeafNodes(node.right,result);
	}
	
	//traverse only right boundary nodes except leaf nodes
	public void traverseRightNodes(Node node, ArrayList<Integer> result){
	    
	    if(node == null)return;
	    if(node.left == null && node.right == null)return;
	    
	    if(node.right == null){
	        traverseRightNodes(node.left,result);
	    }
	    traverseRightNodes(node.right,result);
	    result.add(node.data);
	}
}
