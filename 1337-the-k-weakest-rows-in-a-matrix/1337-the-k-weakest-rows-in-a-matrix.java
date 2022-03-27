class Pair implements Comparable<Pair>{
    int count;
    int index;
    
    Pair(int _count, int _index){
        count = _count;
        index = _index;
    }
    
    @Override
    public int compareTo(Pair p){
        if(count == p.count){
            return index - p.index;
        }else{
            return count - p.count;
        }
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>();
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        for(int row = 0;row < rows;row++){
            int count = 0;
            for(int col = 0;col < cols;col++){
                if(mat[row][col] == 1){
                    count++;
                }
            }
            heap.add(new Pair(count, row));
        }
        
        int[] result = new int[k];
        
        int count = 0;
        while(count < k){
            result[count++] = heap.poll().index;
        }
        
        return result;
        
    }
}