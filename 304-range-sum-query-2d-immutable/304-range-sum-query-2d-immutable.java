class NumMatrix {
    
    int[][] matrix = new int[200][200];
    public NumMatrix(int[][] matrix) {
        
        this.matrix = matrix;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        
        //calculate sum of all rows
        for(int row = 0;row < rows;row++){
            for(int col = 1;col < cols;col++){
                matrix[row][col] += matrix[row][col - 1];
            }
        }
        
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int rowLimit = row2 - row1;
        int sum = 0;
        for(int row = row1;row <= row2;row++){
            
            if(col1 == 0)sum += matrix[row][col2];
            else sum += matrix[row][col2] - matrix[row][col1 - 1];
            
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */