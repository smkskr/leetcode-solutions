class Pair implements Comparable<Pair>{
    int key;
    int value;
    Pair(int _key,int _value){
        key = _key;
        value = _value;
    }
    
    @Override
    public int compareTo(Pair a){
        return this.key - a.key;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for(int num : nums){
            countMap.put(num,countMap.getOrDefault(num,0) + 1);
        }
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        
       
        
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            Pair obj = new Pair(entry.getValue(), entry.getKey());
            minHeap.add(obj);
            if(minHeap.size() > k)minHeap.poll();
        }
        
        int[] res = new int[k];
        for(int i = 0;i < k;i++){
            Pair obj = minHeap.poll();
            res[i] = obj.value;
        }
        return res;
        
    }
}