class Solution {
    public int longestPalindrome(String s) {
        
        int len = s.length();
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        
        for(int index = 0;index < len;index++){
            
            char ch = s.charAt(index);
            charCountMap.put(ch , charCountMap.getOrDefault(ch, 0) + 1);
            
        }
        
        int maxLen = 0;
        int oddFlag = 0;
        
        for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()){
            
            int value = entry.getValue();
            if(value % 2 == 0)maxLen += value;
            else {
                oddFlag = 1;
                maxLen += value - 1;
            }
        }
        
        return maxLen + oddFlag;
    }
}