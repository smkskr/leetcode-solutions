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
    
    boolean isBST;
    int max;
    int min;
    int size;
    
    NodeValue(){}
    
    NodeValue(boolean _isBST, int _max, int _min, int _size){
        isBST = _isBST;
        max = _max;
        min = _min;
        size = _size;
    }
}

class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        
        return largestBSTUtil(root).size;
    }
    
    static NodeValue largestBSTUtil(Node root){
        
        if(root == null){
            return new NodeValue(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        
        if(root.left == null && root.right == null){
            return new NodeValue(true, root.data, root.data, 1);
        }
        
        NodeValue left = largestBSTUtil(root.left);
        NodeValue right = largestBSTUtil(root.right);
        
        if((left.isBST && right.isBST) && left.max < root.data && root.data < right.min){
            int max = Math.max(Math.max(left.max, right.max),root.data);
            int min = Math.min(Math.min(left.min, right.min),root.data);
            int size = 1 + left.size + right.size;
            return new NodeValue(true, max, min, size);
        }
        
        return new NodeValue(false, Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.size, right.size));
    }
    
}