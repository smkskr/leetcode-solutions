/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        ListNode next = node.next;//store next node of the given node
        node.val = next.val;//copy the value of next node to the given node
        node.next = next.next;//point the give node to the next of next node (i.e skip the next node of the given node)
    }
}