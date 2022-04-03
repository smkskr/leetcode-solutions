class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        int len = coordinates.length;
        
        int x1 = coordinates[0][0];
        int x2 = coordinates[1][0];
        int y1 = coordinates[0][1];
        int y2 = coordinates[1][1];
        
        for(int i = 2;i < len;i++){
            
            
             int x = coordinates[i][0];
             int y = coordinates[i][1];
            
             if((y2 - y1)*(x - x2) != (y - y2)*(x2 - x1))return false;
        }
        
        return true;
    }
}