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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummyHead = new ListNode(0, head);
        
        ListNode prevNode = dummyHead;
        
        while(head != null){
            
            //skip all duplicates
            if(head.next != null && head.val == head.next.val){
                
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                
                prevNode.next = head.next;
            }else{
                prevNode = prevNode.next;
            }
            
            //move forward
            head = head.next;
        }
        
        return dummyHead.next;
    }
}