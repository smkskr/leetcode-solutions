class Pair{
    int row;
    int col;
    
    Pair(int _row, int _col){
        row = _row;
        col = _col;
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        
       //doProcessWithExtraSpace(matrix);
        doProcessWithConstantSpace(matrix);
    }
    
    //Method with Extra Space Complexity
    public void doProcessWithExtraSpace(int[][] matrix){
        
        //queue to store indices of matrix having value zero
        Queue<Pair> queue = new LinkedList<>();
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        //traverse through the matrix
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(matrix[row][col] == 0){
                    queue.add(new Pair(row,col));
                }
            }
        }
        
        //traverse through the queue
        while(!queue.isEmpty()){
            Pair currPair = queue.poll();
            int row = currPair.row;
            int col = currPair.col;
            doProcess(row, col, matrix);
        }
        
    }
    
    public void doProcess(int row, int col,int[][] matrix){
        
        //change entire row to zero
        for(int c = 0;c < matrix[0].length;c++){
            matrix[row][c] = 0;
        }
        
        //change entire col to zero
        for(int r = 0;r < matrix.length;r++){
                matrix[r][col] = 0;
        }
    }
    
    //method with constant space Complexity
    public void doProcessWithConstantSpace(int[][] matrix){
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean isFirstCol = false;//
        
       
        for(int row = 0;row < rows;row++){
            
            //check for first cell of the first col is zero or not 
            if(matrix[row][0] == 0){
                isFirstCol = true;
            }
            for(int col = 1;col < cols;col++){
                if(matrix[row][col] == 0){
                    matrix[row][0] = 0;//set first cell of the row to be zero
                    matrix[0][col] = 0;//set first cell of the col to be zero
                }
            }
        }
        
        for(int row = 1;row < rows;row++){
            for(int col = 1;col < cols;col++){
                if(matrix[row][0] == 0 || matrix[0][col] == 0){
                    matrix[row][col] = 0;
                }
            }
        }
        
        //set first row zero
        if(matrix[0][0] == 0){
            for(int col = 0;col < cols;col++){
                matrix[0][col] = 0;
            }
        }
        
        //set first col zero
        if(isFirstCol){
            for(int row = 0;row < rows;row++){
                matrix[row][0] = 0;
            }
        }
        
        
    }
}
