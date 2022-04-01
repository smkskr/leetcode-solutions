class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int rows = accounts.length;
        int cols = accounts[0].length;
        
        int maxSum = 0;
        
        for(int row = 0;row < rows;row++){
            
            int sum = 0;//calculate sum for every row
            
            for(int col = 0;col < cols;col++){
                sum += accounts[row][col];
            }
            
            maxSum = Math.max(maxSum,sum);
        }
        
        return maxSum;
    }
}