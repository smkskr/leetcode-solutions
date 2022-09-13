class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int top = 0;
        int right = matrix[0].length - 1;
        int left = 0;
        int down = matrix.length - 1;
        List<Integer> spiralOrder = new ArrayList<>();
        while(top <= down && left <= right){
            
            
                for(int index = left;index <= right;index++){
                    spiralOrder.add(matrix[top][index]);
                }
                top++;
            
            
            
                for(int index = top;index <= down;index++){
                    spiralOrder.add(matrix[index][right]);
                }
                right--;
            
            
            if(top <= down){
                for(int index = right;index >= left;index--){
                    spiralOrder.add(matrix[down][index]);
                }
                down--;
            }
            
            if(left <=right){
                for(int index = down;index >= top;index--){
                    spiralOrder.add(matrix[index][left]);
                }
                left++;
            }
            
        }
        
        return spiralOrder;
    }
}