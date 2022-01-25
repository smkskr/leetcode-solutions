class Solution {
    public int numSquares(int n) {
        
        List<Integer> listOfPerfectSquares = findPerfectSquares(1, n);
        
        int size = listOfPerfectSquares.size();
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int sum = 1;sum <= n;sum++){
            for(int index = 0;index < size;index++){
                
                
                if(listOfPerfectSquares.get(index) <= sum){
                    int subRes = dp[sum - listOfPerfectSquares.get(index)];
                    if(subRes != Integer.MAX_VALUE){
                        dp[sum] = Math.min(dp[sum], 1 + subRes);
                    }
                }
            }
        }
        
        return dp[n];
    }
    
   
    
    //function to find perfect squares
   public List<Integer> findPerfectSquares(int start, int end){
        
        List<Integer> list = new ArrayList<>();
        
        int number = (int)Math.ceil(Math.sqrt(start));//calculate the starting number
        
        int perfectSquare = number * number; // calculate the first perfect square
        
        int difference = number * 2 + 1; //calculate the difference
        
       
        
        while(perfectSquare >= start && perfectSquare <= end){
            
            list.add(perfectSquare);
            perfectSquare = perfectSquare + difference;
            difference += 2;
        }
        
        return list;
    }
}