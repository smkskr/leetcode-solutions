class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int len = s.length();
        if(len == 0)return 0;
        int start = 0;
        int end = 0;
        
        int maxLen = Integer.MIN_VALUE;
        
        HashMap<Character, Integer> countMap = new HashMap<>();
        
        while(end < len){
            
            char ch = s.charAt(end);
            
            countMap.put(ch, countMap.getOrDefault(ch,0) + 1);
            
            if(countMap.get(ch) == 1){
                 maxLen = Math.max(maxLen, end - start + 1);
            }
           
            
            if(countMap.get(ch) > 1){
                 
                while(countMap.get(ch) > 1){
                    char firstChar = s.charAt(start);
                   
                    countMap.put(firstChar,countMap.get(firstChar) - 1);
                    start++;
                }
               
            }
           
            end++;
        }
        
        return maxLen = maxLen == Integer.MIN_VALUE ? 1 : maxLen;
    }
}