class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int[][] res = new int[r][c];
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        if(rows*cols != r*c)return mat;
        
        for(int i = 0;i < r*c;i++){
            res[i / c][i % c] = mat[i / cols][i % cols];
        }
        
        return res;
    }
}