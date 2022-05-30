// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n  = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    matrix[i][j] = Integer.parseInt(S2[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.longestIncreasingPath(matrix);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestIncreasingPath(int[][] matrix)
    {
        // Code here
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] cache = new int[rows][cols];
        
        
        int longestPath = 0;
        
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(cache[row][col] == 0){
                    longestPath = Math.max(dfs(matrix, cache, row, col), longestPath);
                }
            }
        }
        
        return longestPath;
    }
    
    public int dfs(int[][] matrix, int[][] cache, int row, int col){
        
        if(cache[row][col] != 0)return cache[row][col];
        int pathLength = 1; 
        
        if(row > 0 && matrix[row - 1][col] > matrix[row][col])pathLength = Math.max(pathLength, 1 + dfs(matrix, cache, row - 1, col));//up
        if(row < matrix.length - 1 && matrix[row + 1][col] > matrix[row][col])pathLength = Math.max(pathLength, 1 + dfs(matrix, cache, row + 1, col));//down
        if(col > 0 && matrix[row][col - 1] > matrix[row][col])pathLength = Math.max(pathLength, 1 + dfs(matrix, cache, row, col - 1));//left
        if(col < matrix[0].length - 1 && matrix[row][col + 1] > matrix[row][col])pathLength = Math.max(pathLength, 1 + dfs(matrix, cache, row, col + 1));//right
        cache[row][col] = pathLength;
        return cache[row][col];
    }
}

