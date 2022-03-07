class Solution {
    
 
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(grid[row][col] == 1){       
                    maxArea = Math.max(maxArea, dfs(grid, row, col));
                }
            }
        }
        
        return maxArea;
    }
    
    public int dfs(int[][] grid,int row,int col){
        
        if(row == -1 || row == grid.length || col == -1 || col == grid[0].length || grid[row][col] == 0){
            return 0;
        }
        
        grid[row][col] = 0;    
        return 1 + dfs(grid, row - 1, col) + dfs(grid, row + 1, col) + dfs(grid, row, col - 1) + dfs(grid, row, col + 1);
        
      
    }
}