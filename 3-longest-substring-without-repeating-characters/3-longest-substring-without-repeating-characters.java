class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int start = 0;
        int end = 0;
        int length = s.length();
        if(length == 0 || length == 1)return length;
        HashMap<Character,Integer> charCountMap = new HashMap<>();
        
        int maxLen = Integer.MIN_VALUE;
        
        while(end < length){
            
            char ch = s.charAt(end++);
            charCountMap.put(ch, charCountMap.getOrDefault(ch,0) + 1);
            
            if(charCountMap.get(ch) == 1){
                maxLen = Math.max(maxLen, end - start);
            }
            
            while(charCountMap.get(ch) > 1){
               
                char startChar = s.charAt(start++); 
                charCountMap.put(startChar, charCountMap.get(startChar) - 1);
                
            }
            
        }
        
        return maxLen;
    }
}