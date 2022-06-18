// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.io.*;
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])throws IOException
    {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
		 int t=Integer.parseInt(br.readLine());
		 while(t>0)
         {
            String S[] = br.readLine().split(" ");
			int N = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int n = Integer.parseInt(S[2]);
		
		    String S1[] = br.readLine().split(" ");
			insertion llist = new insertion(); 
			int a1=Integer.parseInt(S1[0]);
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) 
			{
				int a = Integer.parseInt(S1[i]);
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		Node newhead=ob.reverseBetween(llist.head, m, n);
		llist.printList(newhead);
		
        t--;		
        }
    }}// } Driver Code Ends


//User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    public static Node reverseBetween(Node head, int m, int n)
    {
        //code here
        if(head == null)return null;
        Node dummyHead = new Node(0);
        Node temp = dummyHead;
        temp.next = head;
        Node start = null;
        Node destination = null;
        int count = 1;
        
        while(head != null && count <= n){
            
            if(count == m)start = head;
            if(count == n)destination = head;
            
            count++;
            head = head.next;
        }
        
        Node listAfterDestination = reverseList(start, destination);
        
       
        while(temp.next != start){
            temp = temp.next;
        }
        
        temp.next = destination;//since destination is the new head of the reversedList
       
        start.next = listAfterDestination;
        return dummyHead.next;
    }
    
    public static Node reverseList(Node start, Node destination){
        
        Node prev = null;
        Node curr = start;
        while(curr != destination){
            
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }
        
        Node next = curr.next;
        curr.next = prev;
        curr = next;
        
        return curr;


    }
}