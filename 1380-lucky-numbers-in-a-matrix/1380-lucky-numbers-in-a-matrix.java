class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int row = 0;row < rows;row++){
            int min = matrix[row][0];
            for(int col = 1;col < cols;col++){
                min = Math.min(matrix[row][col], min);
            }
            set.add(min);
        }
        
        for(int col = 0;col < cols;col++){
            int max = matrix[0][col];
            for(int row = 1;row < rows;row++){
                max = Math.max(matrix[row][col], max);
            }
            if(set.contains(max))res.add(max);
        }
        
        return res;
    }
}