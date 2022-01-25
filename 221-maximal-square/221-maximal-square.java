class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] dp = new int[rows][cols];
        int maxSqLen = 0;
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(matrix[row][col] == '1'){
                    
                    int upperDiagonalCell = row - 1 == -1 || col - 1 == -1 ? 0 : dp[row - 1][col - 1];
                    int upperCell = row - 1 == -1 ? 0 : dp[row - 1][col];
                    int prevCell = col - 1 == -1 ? 0 : dp[row][col - 1];
                    
                    dp[row][col] = Math.min(upperDiagonalCell, Math.min(upperCell, prevCell)) + 1;
                    maxSqLen = Math.max(maxSqLen, dp[row][col]);
                }
            }
        }
        
        return maxSqLen * maxSqLen;
    }
}