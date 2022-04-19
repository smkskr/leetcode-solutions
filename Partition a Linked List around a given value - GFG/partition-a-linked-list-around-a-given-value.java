// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node node, int x) {
        // Your code here
        List<Integer> lessThanList = new ArrayList();
        List<Integer> greaterThanList = new ArrayList();
        int countX = 0;
        
        Node curr = node; 
        while(curr != null){
            if(curr.data < x){
                lessThanList.add(curr.data);
            }else if(curr.data > x){
                greaterThanList.add(curr.data);
            }else{
                countX++;   
            }
            curr = curr.next;
        }
        
        curr = node;
        for(int num : lessThanList){
            curr.data = num;
            curr = curr.next;
        }
        
        for(int i = 0;i < countX;i++){
            curr.data = x;
            curr = curr.next;
        }
        
        for(int num : greaterThanList){
            curr.data = num;
            curr = curr.next;
        }
        return node;
    }
}