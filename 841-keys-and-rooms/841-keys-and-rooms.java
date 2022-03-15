//This question is similar to traversing all nodes in a graph
//So you can use BFS or DFS
//The objective is to visit all the nodes(if possible) and return true or false accordingly
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return bfs(rooms);    
    }
    
    public boolean bfs(List<List<Integer>> rooms){
        
        int nodes = rooms.size();
        boolean[] visited = new boolean[nodes];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        int count = 1;
        
        while(!queue.isEmpty()){
            
            int source = queue.poll();
            for(int v : rooms.get(source)){
                if(visited[v] == false){
                    queue.add(v);
                    count++;
                    visited[v] = true;
                }
            }
        }
        
        return count == nodes;
    }
}