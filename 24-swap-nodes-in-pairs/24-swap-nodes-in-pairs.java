/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null)return null;
        ListNode curr = head;
        ListNode prev = null;
        int length = listLength(head);
        int count = 1;
        
        //reverse list in pair
        while(curr != null && count <= 2){
            
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
            count++;
            
        }
        
        if(length - 2 >= 2 && curr != null){
            
            ListNode newHead = swapPairs(curr);
            head.next = newHead;
            
        }else{
            head.next = curr;
        }
        
        return prev;//returns the head of the reversed list
        
    }
    
    
    //calculate length of the list
    public int listLength(ListNode head){
        
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        
        return length;
    }
}