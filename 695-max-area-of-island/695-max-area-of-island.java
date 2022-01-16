class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int sum = 0;
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(grid[row][col] == 1){
                    sum = Math.max(sum, maxAreaUsingDfs(grid, row, col));
                }
            }
        }
        
        return sum;
    }
    
    public int maxAreaUsingDfs(int[][] grid, int row, int col){
        
        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] == 0){
            return 0;
        }
        
        grid[row][col] = 0;
        
        return 1 + maxAreaUsingDfs(grid, row - 1, col) + maxAreaUsingDfs(grid, row + 1, col) + maxAreaUsingDfs(grid, row, col - 1) + maxAreaUsingDfs(grid, row, col + 1);
    }
}