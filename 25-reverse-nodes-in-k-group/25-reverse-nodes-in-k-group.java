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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null)return null;
        ListNode curr = head;
        ListNode prev = null;
        int length = listLength(head);
        int count = 1;
        
        //reverse list in k-size
        while(curr != null && count <= k){
            
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
            count++;
            
        }
        
        
        if(curr != null && length - k >= k){
            
            ListNode newHead = reverseKGroup(curr,k);
            head.next = newHead;
            
        }else{
            
            head.next = curr;
            
        }
        
        return prev;
        
    }
    
    public int listLength(ListNode head){
        
        int length = 0;
        while(head != null){
            head = head.next;
            length++;
        }
        return length;
    }
}