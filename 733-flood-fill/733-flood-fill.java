class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc]== newColor)return image; 
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    public void dfs(int[][] image, int row, int col, int sameColor, int newColor){
        
        if(row == -1 || row == image.length || col == -1 || col == image[0].length || image[row][col] != sameColor){
            return;
        }
        
       
        image[row][col] = newColor;
        
        dfs(image, row - 1,col, sameColor, newColor);//up
        dfs(image, row + 1, col, sameColor, newColor);//down
        dfs(image, row, col - 1, sameColor, newColor);//left
        dfs(image, row, col + 1, sameColor, newColor);//right
    }
}