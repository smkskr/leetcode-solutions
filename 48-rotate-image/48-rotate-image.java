class Solution {
    public void rotate(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        swapAlongDiagonal(matrix, rows, cols);
        swapColumns(matrix, rows, cols);
    
    }
    
    //swap elements along the diagonal
    public void swapAlongDiagonal(int[][] matrix, int rows, int cols){
        
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < row;col++){
                
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
                
            }
        }
    }
    
    //swap first column with last column until you reach the middle column
    public void swapColumns(int[][] matrix, int rows, int cols){
        
        int lastCol = cols;
        
        for(int col = 0; col < cols/2;col++){
            
            lastCol--;
            for(int row = 0;row < rows;row++){
                
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][lastCol];
                matrix[row][lastCol] = temp;
                
            }
        }
    }
}