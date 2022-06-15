class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int start = 0;
        int end = 0;
        int lengthS = s.length();
        int lengthP = p.length();
        
        HashMap<Character, Integer> countMap = new HashMap<>();
        int countP = 0;
        List<Integer> list = new ArrayList<>();
        
        for(char ch : p.toCharArray()){
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);    
        }
        
        while(end < lengthS){
            
            char ch = s.charAt(end);
            countMap.put(ch, countMap.getOrDefault(ch, 0) - 1);
            if(countMap.get(ch) >= 0)countP++;
            
            if(end - start + 1 == lengthP){
                
                if(countP == lengthP)list.add(start);
                char firstChar = s.charAt(start++);
                countMap.put(firstChar, countMap.get(firstChar) + 1);
                if(countMap.get(firstChar) >= 1)countP--;
            }
            end++;
        }
        
        return list;
    }
}