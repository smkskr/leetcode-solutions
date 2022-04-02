// { Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
class Zeroes{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Node head=null;
            while(n-->0){
                int a=sc.nextInt();
                if(head==null){
                    head=new Node(a);
                }
                else{
                    Node temp=new Node(a);
                    temp.next=head;
                    head=temp;
                }
            }
            GfG g=new GfG();
            head = g.moveZeroes(head);
            while(head!=null){
                System.out.print(head.data+" ");
                head=head.next;
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
*/

class GfG{
    public Node moveZeroes(Node head){
        //Your Code here.
        Node prev = null;//to keep track of the last non-zero value
        Node nonZeroHead = null;//to keep track of the non-zero head
        Node zeroPointer = head;//keeps track of the zero head
        Node curr = head;
        
        
        while(curr != null){
            
            if(curr.data != 0){
                int temp = zeroPointer.data;
                zeroPointer.data = curr.data;
                curr.data = temp;
                
                if(nonZeroHead == null){
                    nonZeroHead = zeroPointer;
                }
                
                prev = zeroPointer;
                zeroPointer = zeroPointer.next;
            }
          
            curr = curr.next;
        }
       
       if(zeroPointer == curr || prev == null)return head;
       
       Node zeroCurr = zeroPointer;
       
       while(zeroCurr.next != null){
           zeroCurr = zeroCurr.next;
       }
        
       zeroCurr.next = nonZeroHead;
       prev.next = null;
       return zeroPointer;
    }
}