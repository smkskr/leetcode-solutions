class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> deque = new LinkedList<Integer>();
        
        int start = 0;
        int end = 0;
        int len = nums.length;
        int[] result = new int[len - k + 1];
        int index = 0;
        while(end < len){
            
            
            while(!deque.isEmpty() && nums[end] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(end);
            
            if(end - start + 1 == k){
                
                result[index] = nums[deque.peekFirst()];
                index++;
                start++;
                while(!deque.isEmpty() && deque.peek() < start){
                    deque.poll();   
                }
                
                
            }
            
            end++;
            
            
        }
        return result;
    }
}