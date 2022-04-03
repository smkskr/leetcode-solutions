class Pair implements Comparator<Pair>{
    
    int val;
    int count;
    
    Pair(){
        
    }
    
    Pair(int _val, int _count){
        val = _val;
        count = _count;
    }
    
    @Override
    public int compare(Pair p1, Pair p2){
        if(p1.count == p2.count){
            return p1.val - p2.val;
        }
        return p1.count - p2.count;
    }
}

class Solution {
    public int[] sortByBits(int[] arr) {
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Pair());
        
        for(int num : arr){
            int count = countOneBits(num);
            minHeap.add(new Pair(num, count));
        }
        
        int[] res = new int[arr.length];
        int index = 0;
        
        while(!minHeap.isEmpty()){
            res[index++] = minHeap.poll().val;   
        }
        
        return res;
    }
    
    public int countOneBits(int num){
        
        int count = 0;
        for(int i = 0;i < 32;i++){
            
            int bit = (num >> i) & 1;
            if(bit == 1)count++;
        }
        
        return count;
    }
}