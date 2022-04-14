// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

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
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
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
        
                  // Create the right child for the curr node
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
            System.out.println(T.largestBst(root));
            
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

class NodeValue{

    int minNodeVal;
    int maxNodeVal;
    int maxSize;
    
    NodeValue(int _minNodeVal, int _maxNodeVal, int _maxSize){
        minNodeVal = _minNodeVal;
        maxNodeVal = _maxNodeVal;
        maxSize = _maxSize;
    }
    
}
class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
       NodeValue node = solve(root);
       return node.maxSize;
           
    }
    
    static NodeValue solve(Node root){
        
        //An empty tree is a BST of size 0
        if(root == null)return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        
        //calculate left and right subtree
        NodeValue left = solve(root.left);
        NodeValue right = solve(root.right);
        
        //Current node is greater than max in left subtree AND smaller than min in right subtree, then it is a BST
        if(left.maxNodeVal < root.data && root.data < right.minNodeVal){
            return new NodeValue(Math.min(root.data,left.minNodeVal), Math.max(root.data,right.maxNodeVal),1 + left.maxSize + right.maxSize);
        }
            //otherwise, return -INF and INF so that the parent root becomes invalid BST
            return new NodeValue( Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize,right.maxSize));
        
       
    }
    
}