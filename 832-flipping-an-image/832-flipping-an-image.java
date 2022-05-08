class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        int rows = image.length;
        int cols = image[0].length;
        
        for(int row = 0;row < rows;row++){
                reverseArrayAndChangeBit(image[row]);
        }
        
        return image;
        
    }
    
    public void reverseArrayAndChangeBit(int[] row){
       
        int left = 0;
        int right = row.length - 1;
     
        while(left <= right){
            int temp = row[left] ^ 1;
            row[left] = row[right] ^ 1;
            row[right] = temp;
            left++;
            right--;
        }
    }
}