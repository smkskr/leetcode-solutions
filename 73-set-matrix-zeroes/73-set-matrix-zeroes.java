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
}
