class Pair{
    int rowIndex;
    int colIndex;
    
    Pair(int _rowIndex, int _colIndex){
        rowIndex = _rowIndex;
        colIndex = _colIndex;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(grid[row][col] == 2){
                    queue.add(new Pair(row,col));
                }
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            
            int size = queue.size();
            for(int i = 0;i < size;i++){
                Pair currPair = queue.poll();
                int row = currPair.rowIndex;
                int col = currPair.colIndex;
                rotAdjacentOranges(grid, row, col, queue);
            }
            count++;
        }
        
       
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(grid[row][col] == 1)return -1;
            }
        }
        
        return count == 0 ? 0 : count - 1;
    }
    
    public void rotAdjacentOranges(int[][] mat, int row, int col, Queue<Pair> queue){
        
        //above cell
        if(row - 1 >= 0 && mat[row - 1][col] == 1){
            queue.add(new Pair(row - 1,col));
            mat[row-1][col] = 2;           
        }
        
        //below cell
        if(row + 1 < mat.length && mat[row + 1][col] == 1){
            mat[row + 1][col] = 2;
            queue.add(new Pair(row + 1,col));
        }
        //left cell
        if(col - 1 >= 0 && mat[row][col - 1] == 1){
            mat[row][col - 1] = 2;
            queue.add(new Pair(row, col - 1));
        }
        //right cell
        if(col + 1 < mat[0].length && mat[row][col + 1] == 1){
            mat[row][col + 1] = 2;
            queue.add(new Pair(row ,col+1));
        }
        
    }
}