class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        
        int left = 0;
        int right = cols - 1;
        
        int top = 0;
        int bottom = rows - 1;
        
        while(top <= bottom && left <= right){
            
            //moving left to right
            for(int i = left;i <= right;i++){
                result.add(matrix[top][i]);
            }
            top++;
            
            //moving top to bottom
                for(int i = top;i <= bottom;i++){
                    result.add(matrix[i][right]);   
                }
                right--;
            
           
            //moving right to left
            if(top <= bottom){
                for(int i = right;i >= left;i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
           
           
            
            //moving bottom to top
            if(left <= right){
                 for(int i = bottom;i >= top;i--){
                result.add(matrix[i][left]);
            }
            left++;
            }
           
        }
        
        return result;
    }
}