class Pair implements Comparable<Pair>{
    int freq;
    char ch;
    Pair(int _freq, char _ch){
        freq = _freq;
        ch = _ch;
    }
    
    @Override
    public int compareTo(Pair a){
        return a.freq - this.freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> countMap = new HashMap<>();
        
        int len = s.length();
        for(int index = 0;index < len;index++){
            char ch = s.charAt(index);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
        
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            Pair obj = new Pair(entry.getValue(), entry.getKey());
            maxHeap.add(obj);
        }
        
        StringBuilder result = new StringBuilder();
        while(!maxHeap.isEmpty()){
            
            Pair curr = maxHeap.poll();
            int freq = curr.freq;
            for(int i = 1;i <= freq;i++){
                result.append(curr.ch);
            }
            
        }
        
        return result.toString();
        
    }
}