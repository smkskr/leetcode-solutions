class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int n = arr.length;
        int[] preSum = new int[n];
        preSum[0] = arr[0];
        
        for(int i = 1;i < n;i++){
            preSum[i] = preSum[i-1] + arr[i]; 
        }
        
        int sum = 0;
        int index = 2;
        
        int start = 3;
        while(start <= n){
            
            for(int i = start - 1;i < n;i++){
                if(i - start == -1)sum = sum + preSum[i];
                else sum = sum + preSum[i] - preSum[i - start];
            }
            start += 2;
        }
        
        return sum + preSum[n-1];
      
    }
    
    
}


    
