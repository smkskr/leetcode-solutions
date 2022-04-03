class Solution {
    public boolean isAnagram(String s, String t) {
     
        HashMap<Character, Integer> countMap = new HashMap<>();
        
        int lenS = s.length();
        int lenT = t.length();
        
        if(lenS != lenT)return false;
        
        for(int index = 0;index < lenS;index++){
            
            char chS = s.charAt(index);
            char chT = t.charAt(index);
            
            countMap.put(chS, countMap.getOrDefault(chS,0) + 1);
            countMap.put(chT, countMap.getOrDefault(chT,0) - 1);
            
        }
        
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            
            if(entry.getValue() != 0)return false;
        }
        
        return true;
    }
}