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
    public ListNode swapNodes(ListNode head, int k) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        convertToArray(head, arr);
        swapValues(arr, k);
        return convertToList(arr);

    }
    
    public void convertToArray(ListNode head, ArrayList<Integer> arr){  
        
        while(head != null){
            arr.add(head.val);
            head = head.next;
        }
        
    }
    
    public void swapValues(ArrayList<Integer> arr, int k){
        
        int len = arr.size();
        int val1 = arr.get(k - 1);
        int val2 = arr.get(len - k);
        arr.set(k - 1, val2);
        arr.set(len - k, val1);
        
    }
    
    public ListNode convertToList(ArrayList<Integer> arr){  
        
       ListNode dummyHead = new ListNode(0);
       ListNode temp = dummyHead;
       for(int num : arr){
            
           temp.next = new ListNode(num);
           temp = temp.next;
       }
        
       return dummyHead.next;
        
    }
}