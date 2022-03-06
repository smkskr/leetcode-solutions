class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(grid[row][col] == '1'){
                    dfs(grid, row, col);
                    count++;                
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int row, int col){
        
        if(row == -1 || row == grid.length || col == -1 || col == grid[0].length || grid[row][col] == '0')return;
        
        grid[row][col] = '0';
        
        dfs(grid, row - 1, col);//up
        dfs(grid, row + 1, col);//down
        dfs(grid, row, col - 1);//left
        dfs(grid, row, col + 1);//right
    }
}