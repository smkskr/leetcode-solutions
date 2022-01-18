class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        
      for(int i=0;i<9;i++)
        {
            HashSet row=new HashSet<>();
            HashSet column= new HashSet<>();
            HashSet cube=new HashSet<>();
            int rowIndex= (i/3 >= 2)? 6 :(i/3 >= 1)?3 : 0;
            int colIndex=3* (i%3);
            for(int j=0;j<9;j++)
            {   
                if(board[i][j]!='.' && !(row.add(board[i][j])) )
                   return false;
                if(board[j][i]!='.' && !(column.add(board[j][i])))
                   return false;  
                if(board[rowIndex + j/3][colIndex + j%3]!='.' && !cube.add(board[rowIndex + j/3][colIndex + j%3]))
                   return false;
            }
        }
        return true;
    }
    
}