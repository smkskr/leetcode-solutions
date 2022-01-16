class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int rows = image.length;
        int cols = image[0].length;
        
        performDfs(image, sr, sc, newColor, image[sr][sc]);
 
        return image;
    }
    
    public void performDfs(int[][] image, int row, int col,int newColor, int sameColor){
        
        if(row < 0 || row == image.length || col < 0 || col == image[0].length || image[row][col] != sameColor ){
            return;
        }
        
        if(image[row][col] == newColor)return;
       
        image[row][col] = newColor;
        
        performDfs(image, row - 1, col, newColor, sameColor);//go up
        performDfs(image, row + 1, col, newColor, sameColor);//go down
        performDfs(image, row, col - 1, newColor, sameColor);//go left
        performDfs(image, row, col + 1, newColor, sameColor);//go right
        
    }
}