class Solution {
    public int closedIsland(int[][] grid) {
        
        //exclude corner islands as they won't be surrounded with water from all directions
        excludeCornerIslands(grid);
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        for(int row = 1;row < rows;row++){
            for(int col = 1;col < cols;col++){
                if(grid[row][col] == 0){
                    dfs(grid, row, col);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    //find group of islands which are the on the corner of the grid and exclude them
    public void excludeCornerIslands(int[][] grid){
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        
        //first row
        for(int col = 0;col < cols;col++){
            if(grid[0][col] == 0){
                dfs(grid, 0, col);
            }
        }
        
        //last row
        for(int col = 0;col < cols;col++){
            if(grid[rows - 1][col] == 0){
                dfs(grid, rows - 1, col);
            }
        }
        
        //first col
        for(int row = 0;row < rows;row++){
            if(grid[row][0] == 0){
                dfs(grid, row, 0);
            }
        }
        
        
        //last col
        for(int row = 0;row < rows;row++){
            if(grid[row][cols - 1] == 0){
                dfs(grid, row, cols - 1);
            }
        }
        
    }
    
    //perform dfs
    public void dfs(int[][] grid, int row, int col){
        
        if(row == -1 || row == grid.length || col == -1 || col == grid[0].length || grid[row][col] == 1){
            return;
        }
        
        grid[row][col] = 1;
        
        dfs(grid, row - 1, col);//up
        dfs(grid, row + 1, col);//down
        dfs(grid, row, col - 1);//left
        dfs(grid, row, col + 1);//right
    }
}