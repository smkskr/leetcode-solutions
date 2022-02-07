/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode slowP = head;
        ListNode fastP = head;
        boolean flag = false;
        
        while(fastP != null && fastP.next != null){
            
            slowP = slowP.next;
            fastP = fastP.next.next;
            if(slowP == fastP){
                flag = true;break;
            }
            
        }
        
        if(flag == true && fastP == head)return slowP; // if there is only one node in single linked list with a cycle on head node
        if(slowP != fastP || slowP == head)return null; //return null if there is no cycle
        
        slowP = head;
        while(slowP != fastP){
            slowP = slowP.next;
            fastP = fastP.next;
        }
        
        return slowP;
    }
}