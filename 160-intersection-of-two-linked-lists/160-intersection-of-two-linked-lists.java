/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = length(headA);
        int lenB = length(headB);
        
        if(lenB > lenA)return getIntersectionNode(headB, headA);
        
        int diff = lenA - lenB;
        
        //skipping list A so that both the lists should have same length
        for(int i = 1;i <= diff;i++){
            headA = headA.next;
        }
        
        while(headA != null && headB != null){
            if(headA == headB)return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    public int length(ListNode list){
        
        int len = 0;
        
        while(list != null){
            len++;
            list = list.next;
        }
        
        return len;
    }
}