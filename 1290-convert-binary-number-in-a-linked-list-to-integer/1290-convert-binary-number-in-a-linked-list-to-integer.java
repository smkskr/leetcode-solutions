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
    public int getDecimalValue(ListNode head) {
        
        int[] totalLen = {1};
        
        return solve(head, 1, totalLen);
    }
    
    public int solve(ListNode head,int currentLen, int[] totalLen){
        
        if(head == null){
            totalLen[0] = currentLen - 1;
            return 0;
        }
        int sum = 0;
        
        int prevSum = solve(head.next, currentLen + 1, totalLen);
        
        sum = prevSum + (int)(head.val * Math.pow(2, totalLen[0] - currentLen)); 
            
        return sum;
    }
}