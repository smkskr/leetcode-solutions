class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        int[][] result = new int[rows][cols];
        
        for(int row = 0; row < rows;row++){
            for(int col = 0;col < cols;col++){
                
                int lowerLimitR = row - k < 0 ? 0 : row - k;
                int upperLimitR = row + k >= rows ? rows - 1 : row + k;
                
                int lowerLimitC = col - k < 0 ? 0 : col - k;
                int upperLimitC = col + k >= cols ? cols - 1 : col + k;
                
                for(int i = lowerLimitR;i <= upperLimitR;i++){
                    for(int j = lowerLimitC;j <= upperLimitC;j++){
                        result[row][col] = result[row][col] + mat[i][j]; 
                    }
                }
            }
                
            
        }
        
        return result;
    }
}