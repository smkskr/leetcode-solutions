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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int s = Integer.parseInt(S[2]);
            int d = Integer.parseInt(S[3]);
            int[][] edges = new int[m][2];
            for(int i = 0; i < m; i++){
                String[] S1 = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(S1[0]);
                edges[i][1] = Integer.parseInt(S1[1]);
            }
            Solution obj = new Solution();
            int ans = obj.possible_paths(edges, n, s, d);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{   
    int count = 0;
    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        // Code here 
        if(s == d)return 1;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int index = 0;index < n;index++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            addEdge(adjList, edge[0], edge[1]);    
        }
        
        
        boolean[] visited = new boolean[n];
        dfs(adjList, visited, s, d);
        return count;
        
    }
    
    public void addEdge(ArrayList<ArrayList<Integer>> adjList, int source, int destination){
        adjList.get(source).add(destination);
    }
    
    
    public void dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int source, int destination){
        visited[source] = true;
        
        for(int u : adjList.get(source)){
            if(visited[u] == false){
                visited[u] = true;
                if(u == destination)count++;
                dfs(adjList, visited, u, destination);
            }
        }
        
        visited[source] = false;
        
    }
}