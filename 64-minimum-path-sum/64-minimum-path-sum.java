class Solution {
    public int minPathSum(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                
                if(row == 0 & col == 0)continue;
                else{
                    
                    int up = row - 1 == -1 ? Integer.MAX_VALUE : grid[row - 1][col];
                    int left = col - 1 == -1 ? Integer.MAX_VALUE : grid[row][col - 1];
                    
                    grid[row][col] += Math.min(up, left);
                    
                }
            }
        }
        
        return grid[rows - 1][cols - 1];
    }
}


