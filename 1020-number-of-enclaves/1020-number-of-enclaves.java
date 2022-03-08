class Solution {
    public int numEnclaves(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        removeAllLandFromBoundary(grid, rows, cols);
        
        int sum = 0;
        for(int row = 1;row < rows;row++){
            for(int col = 1;col < cols;col++){
                if(grid[row][col] == 1){
                    sum += dfs(grid, row, col);
                }
            }
        }
        
        return sum;
    }
    
    //remove all 1s from the boundary
    public void removeAllLandFromBoundary(int[][] grid, int rows, int cols){
        
        
        //first row and last row
        for(int col = 0;col < cols;col++){
            if(grid[0][col] == 1){
                dfs(grid, 0, col);//first row
            }
             if(grid[rows - 1][col] == 1){
                dfs(grid, rows - 1, col);//last row
            }
        }
        
        //first col and last col
        for(int row = 0;row < rows;row++){
            if(grid[row][0] == 1){
                dfs(grid, row, 0);//first col
            }
            if(grid[row][cols - 1] == 1){
                 dfs(grid, row, cols - 1);//last col
            }
        }
        
       
    }
    
    
    public int dfs(int[][] grid, int row, int col){
        
        if(row == -1 || row == grid.length || col == -1 || col == grid[0].length || grid[row][col] == 0){
            return 0;
        }
        
        grid[row][col] = 0;
        
        
        return 1 + dfs(grid, row - 1, col) + //up
        dfs(grid, row + 1, col) + //down
        dfs(grid, row, col - 1) +//left
        dfs(grid, row, col + 1);//right
        
    }
}