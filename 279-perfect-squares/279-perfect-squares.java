class Solution {
    public int numSquares(int n) {
        
        List<Integer> perfectSquareList = perfectSquaresList(1,n);
        int size = perfectSquareList.size();
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int sum = 1;sum <= n;sum++){
            for(int j = 0;j < size;j++){
                    
                if(perfectSquareList.get(j) <= sum){
                    int subRes = dp[sum - perfectSquareList.get(j)];
                    if(subRes != Integer.MAX_VALUE){
                        dp[sum] = Math.min(dp[sum], 1 + subRes);
                    }
                }    
            }
        }
        
        return dp[n];
    }
    
    public List<Integer> perfectSquaresList(int start, int end){
        
        List<Integer> list = new ArrayList<>();
        
        int number = (int)Math.ceil(Math.sqrt(start));//starting number
        
        int perfectSquare = number * number; //first perfect Square
        
        /**
         * Perfect squares : 1 , 4 , 9 , 16 , 25, . . . 
         * Difference between consecutive perfect squares : 3 , 5 , 7 , 9 
         */
        int difference = number * 2 + 1;
        
        while(perfectSquare <= end){
            
            list.add(perfectSquare);
            perfectSquare = perfectSquare + difference;
            difference+=2;
            
        }
        
        return list;
    }
}