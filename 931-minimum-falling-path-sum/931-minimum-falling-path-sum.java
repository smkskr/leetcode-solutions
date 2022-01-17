class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = Integer.MAX_VALUE;
        
        for(int row = 0;row < rows;row++){
            
            for(int col = 0;col < cols;col++){
                
                if(row != 0){
                    
                   
                    int upperLeftDiagonalCell = (col - 1 == -1) ? Integer.MAX_VALUE : matrix[row - 1][col - 1];
                
                    int upperCell = matrix[row - 1][col];
                
                    int upperRightDiagonalCell = (col + 1 == cols)? Integer.MAX_VALUE : matrix[row - 1][col + 1];
                
                    int min = Math.min(upperLeftDiagonalCell , Math.min(upperCell, upperRightDiagonalCell));
                
                    matrix[row][col] = min + matrix[row][col];
                    
                }
               
                
                if(row == rows - 1)//calculate the min in last row
                res = Math.min(res, matrix[row][col]);                   
            
        }
    }
        
        return res;
}
}