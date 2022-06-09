class Solution {
    public int[] twoSum(int[] numbers, int target) {
            
        int len = numbers.length;
        
        int leftPointer = 0;
        int rightPointer = len - 1;
        
        int[] result = new int[2];
        
       while(leftPointer < rightPointer){
           if(numbers[leftPointer] + numbers[rightPointer] < target){
               leftPointer++;
           }else if(numbers[leftPointer] + numbers[rightPointer] > target){
               rightPointer--;
           }else{
               result[0] = leftPointer + 1;
               result[1] = rightPointer + 1;
               break;
           }
       }
        
        return result;
    }
}