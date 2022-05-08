class Solution {
    public int diagonalSum(int[][] mat) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        int sum = 0;
        
        
        for(int row = 0;row < rows;row++){
            sum += mat[row][row];//primary diagonal
            sum += mat[row][rows - row - 1];//secondary diagonal
        }
        
        if(rows%2 == 1){
            sum = sum - mat[rows/2][rows/2];
        }
        
        return sum;
    }
}