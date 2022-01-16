class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        //saving the index of the current maximum of the window in deque at the first position
        Deque<Integer> deque = new LinkedList<Integer>();
        
        int start = 0;
        int end = 0;
        int len = nums.length;
        int[] result = new int[len - k + 1];
        int index = 0;
        while(end < len){
            
            /*whenever we encounter any maximum number than the last element in the deque
            * remove the last element and insert the present element(maximum number) and continue
            * till the present element becomes maximum than all the elements.
            * 
            * Why we do this ? --> We do this because if we encounter any maximum element then that element is               
            * going to be maximum for the previous windows.
            * 
            * But what if the present number is smaller than the last element in the deque...then we just simply 
            * put it in the queue as there is a chance that present number(which is currently smaller) can be               
            * maximum for the upcoming windows.
            *
            * NOTE : Here we are storing the indices of the numbers in the array
            */
            while(!deque.isEmpty() && nums[end] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(end);
            
            if(end - start + 1 == k){
                
                result[index] = nums[deque.peekFirst()];
                index++;
                start++;
                
                //Remove indices which are smaller than the starting index of the window
                while(!deque.isEmpty() && deque.peek() < start){
                    deque.poll();   
                }
                
                
            }
            
            end++;
            
            
        }
        return result;
    }
}
