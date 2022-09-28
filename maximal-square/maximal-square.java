class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int maxValue = 0;
        
        //check for first row
        for(int col = 0;col < matrix[0].length;col++){
            if(matrix[0][col] == '1'){
                maxValue = 1;break;
            }
        }
        
        //check for first col
        for(int row = 0;row < matrix.length;row++){
            if(matrix[row][0] == '1'){
                maxValue = 1;break;
            }
        }
       
        for(int row = 1;row < matrix.length;row++){
            for(int col = 1;col < matrix[0].length;col++){
                
                if(matrix[row][col] == '1'){
                      
                      int minVal = Math.min(matrix[row - 1][col - 1] - '0', Math.min(matrix[row - 1][col] -'0',matrix[row][col - 1] - '0')) + 1;
                    matrix[row][col] = (char)(minVal + '0');
                      maxValue = Math.max(maxValue, minVal);
                    
                    
                }
            }
        }
        
        return maxValue * maxValue;
    }
}