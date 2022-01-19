class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(row == 0 && col == 0)obstacleGrid[row][col] = obstacleGrid[row][col] == 1 ? 0 : 1;
                
                else{
                    
                    int left = row - 1 == -1 ? 0 : obstacleGrid[row - 1][col];
                    int up = col - 1 == -1 ? 0 : obstacleGrid[row][col - 1];
                    
                    obstacleGrid[row][col] = obstacleGrid[row][col] == 1 ? 0 : left + up;
                        
                }
                
            }
        }
        
        return obstacleGrid[rows - 1][cols - 1];
    }
}