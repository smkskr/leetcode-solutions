//This question is similar to traversing all nodes in a graph
//So you can use BFS or DFS
//The objective is to visit all the nodes(if possible) and return true or false accordingly
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        return bfs(rooms);
        
        
    }
    
    public boolean bfs(List<List<Integer>> rooms){
        
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        int source = 0;
        queue.add(source);
        visited[source] = true;
        int count = 1;
        while(!queue.isEmpty()){
            
            int u = queue.poll();
            for(int v : rooms.get(u)){
                if(visited[v] == false){
                    visited[v] = true;
                    count++;
                    queue.add(v);
                }
                
            }
        }
        
        if(count == visited.length)return true;
        return false;
    }
}