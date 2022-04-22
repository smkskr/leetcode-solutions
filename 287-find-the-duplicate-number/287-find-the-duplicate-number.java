class Solution {
    public int findDuplicate(int[] nums) {
       
       int n = nums.length;
       int start = 0;
       
       while(start < n){
           
           int correctIndex = nums[start] - 1;
           if(nums[start] != nums[correctIndex]){
               int temp = nums[start];
               nums[start] = nums[correctIndex];
               nums[correctIndex] = temp;
           }
           else{
               start++;
           }
       }
        
        //search for duplicate
        for(int i = 0;i < n;i++){
            if(nums[i] != i + 1)return nums[i];
        }
        
        return -1;
      //return anotherMethod(nums);
        
    }
    
    //another method with one time parsing
    public int anotherMethod(int[] nums){
         int len = nums.length;
        int val = 0;
       for(int i = 0;i < len;i++){
           
           int abs = Math.abs(nums[i]) - 1;
           if(nums[abs] < 0){
               val = Math.abs(nums[i]);
               break;
           }
           nums[abs] *= -1;
       }
        
       return val;
    }
     
}