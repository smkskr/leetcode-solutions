class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        
        Stack<Integer> stack = new Stack<>();//store indices
        HashMap<Integer, Integer> nextGreaterElementMap = new HashMap<>();
        stack.push(0);
        for(int i = 1;i < nums2.length;i++){
            
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                nextGreaterElementMap.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            nextGreaterElementMap.put(nums2[stack.pop()], -1);
        }
        
        int[] res = new int[nums1.length];
        int index = 0;
        for(int num : nums1){
            res[index++] = nextGreaterElementMap.get(num);
        }
        
        return res;
    }
    
    
    
       
}