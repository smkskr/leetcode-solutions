class Solution {
    public int diagonalSum(int[][] mat) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        int sum = 0;
        
        //primary diagonal
        for(int row = 0;row < rows;row++){
            sum += mat[row][row];
            sum += mat[row][rows - row - 1];
        }
        
        //secondary diagonal
        // for(int row = rows - 1;row >= 0;row--){
        //     sum += mat[row][row];    
        // }
        
        if(rows%2 == 1){
            sum = sum - mat[rows/2][rows/2];
        }
        
        return sum;
    }
}