class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int cache[][] = new int[rows][cols];
        int[] prev = new int[1];
        int count = 0;
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(cache[row][col] == 0){
                    count = Math.max(count,dfs(matrix, row, col, cache));
                }
            }
        }
        
        return count;
        
       
    }
    
    public int dfs(int[][] matrix, int row, int col, int[][] cache){
        
        if(cache[row][col] != 0)return cache[row][col];
        
        int max = 1;
        if(row > 0 && matrix[row - 1][col] > matrix[row][col]) max = Math.max(max, 1 + dfs(matrix, row - 1, col, cache));//up
        if(row < matrix.length - 1 && matrix[row + 1][col] > matrix[row][col]) max = Math.max(max, 1 + dfs(matrix, row + 1, col, cache));//down
        if(col > 0 && matrix[row][col - 1] > matrix[row][col]) max = Math.max(max, 1 +dfs(matrix, row, col - 1, cache));//left
        if(col < matrix[0].length - 1 && matrix[row][col + 1] > matrix[row][col]) max = Math.max(max, 1 + dfs(matrix, row, col + 1, cache));//right
        cache[row][col] = max;
        return max;
    }
}