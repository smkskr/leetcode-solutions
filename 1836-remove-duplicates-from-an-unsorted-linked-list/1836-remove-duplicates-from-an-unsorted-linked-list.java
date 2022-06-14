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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        
        Map<Integer, Integer> countMap = new HashMap<>();
        countValues(head, countMap);
        
        ListNode dummyHead = new ListNode(0,head);
        ListNode prevNode = dummyHead;
        
        while(head != null){
            
            if(countMap.get(head.val) > 1){
                prevNode.next = head.next;
            }else{
                prevNode = prevNode.next;
            }
            head = head.next;
        }
        
        return dummyHead.next;
    }
    
    public void countValues(ListNode head, Map<Integer, Integer> countMap){
        
        while(head != null){
            countMap.put(head.val, countMap.getOrDefault(head.val,0) + 1);
            head = head.next;
        }
        
    }
}