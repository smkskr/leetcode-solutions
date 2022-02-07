//using sliding window approach
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        int len = s.length();
        int windowSize = 10;
        int start = 0;
        int end = 0;
        
        HashMap<String, Integer> countMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        if(len < 10) return result;
        
        while(end < len){
            
            if(end - start + 1 == windowSize){
                String sub = s.substring(start, end + 1);
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
                start++;
            }
            
            end++;
            
        }
        
        for(Map.Entry<String, Integer> entry : countMap.entrySet()){
            int value = entry.getValue();
            if(value > 1){
                result.add(entry.getKey());
            }
        }
        
        return result;
    }
}