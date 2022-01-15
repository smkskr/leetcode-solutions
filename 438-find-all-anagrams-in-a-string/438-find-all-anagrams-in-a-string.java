class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int[] charCountMap = new int[26];
        List<Integer> list = new ArrayList<>();

        for(char ch : p.toCharArray()){
            charCountMap[ch - 'a']++;
        }
        
        int start = 0;
        int end = 0;
        int lengthOfMainString = s.length();
        int windowSize = p.length();
        
        int count = 0;
        
        while(end < lengthOfMainString){
            
            char ch = s.charAt(end);
            charCountMap[ch - 'a']--;
            if(charCountMap[ch - 'a'] >= 0)count++;
            

            
            if(end - start + 1 == windowSize){
                
                if(count == windowSize)list.add(start);
                char firstCharacter = s.charAt(start);
                if(charCountMap[firstCharacter - 'a']++ >= 0){
                    count--;
                }
                
                start++;
            }
            
            end++;
        }
        
        return list;
    }
}