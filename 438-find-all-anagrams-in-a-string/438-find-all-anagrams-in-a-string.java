class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        HashMap<Character, Integer> countPChar = new HashMap<>();
        
        HashMap<Character, Integer> countSubstringChar = new HashMap<>();
        
        List<Integer> list = new ArrayList<>();
        
        int windowSize = p.length();
        int stringLength = s.length();
        
        for(char ch : p.toCharArray()){
            countPChar.put(ch, countPChar.getOrDefault(ch, 0)+1);
        }
        
        int start = 0;
        int end = 0;
        
        while(end < stringLength){
            
            char ch = s.charAt(end);
            countSubstringChar.put(ch, countSubstringChar.getOrDefault(ch, 0)+1);
            
            if(end - start + 1 == windowSize){
                int len = 0;
                for(Map.Entry<Character, Integer> entry : countSubstringChar.entrySet()){
                    char key = entry.getKey();
                    int count = entry.getValue();
                                  
                    if(countPChar.containsKey(key)){
                        if(countPChar.get(key) == count)len += count;
                        else break;
                    }
                }
                
                if(len == windowSize)list.add(start);
                
                char firstCharacter = s.charAt(start);
                
                countSubstringChar.put(firstCharacter,countSubstringChar.get(firstCharacter) - 1);
                
                start++;
            }
            
            end++;
        }
        
        return list;
    }
}