class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        int result[][] = new int[rows][cols];
        
        //filling with Integer.MAX_VALUE - 20000
        // Why Integer.MAX_VALUE - 20000 ? --> To avoid integer overflow(check constraints ot understand why 20000 is chosen)
        for(int row = 0;row < rows;row++){
             Arrays.fill(result[row], Integer.MAX_VALUE - 20000);
        }
       
        
        //in first parsing check adjacent left and top values
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(mat[row][col] == 0)result[row][col] = 0;
                else{
                    
                    //check for left
                    if(col > 0){
                        result[row][col] = Math.min(result[row][col], result[row][col - 1] + 1);
                    }
                    //check for top
                    if(row > 0){
                        result[row][col] = Math.min(result[row][col], result[row - 1][col] + 1);
                    }
                }
            }
        }
        
        //in second parsing check adjacent right and bottom values
        for(int row = rows - 1;row >= 0;row--){
            for(int col = cols - 1;col >= 0;col--){
                if(mat[row][col] == 0)result[row][col] = 0;
                else{
                    
                    //check for right
                    if(col < cols - 1){
                        result[row][col] = Math.min(result[row][col], result[row][col + 1] + 1);
                    }
                    //check for bottom
                    if(row < rows - 1){
                        result[row][col] = Math.min(result[row][col], result[row + 1][col] + 1);
                    }
                    
                }
            }
        }
        
        return result;
    }
}