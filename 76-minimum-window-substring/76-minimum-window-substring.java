class Solution {
    public String minWindow(String s, String t) {
        
        int lenS = s.length();
        int lenT = t.length();
        if(lenT > lenS)return "";
        HashMap<Character,Integer> charCountMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            charCountMap.put(ch, charCountMap.getOrDefault(ch,0) + 1);
        }
        
        int start = 0;
        int end = 0;
        String result = "";
        int count = 0;
        int minLen = lenS;
        
        while(end < lenS){
            
            char ch = s.charAt(end);
            if(charCountMap.containsKey(ch)){
                charCountMap.put(ch,charCountMap.get(ch) - 1);
                if(charCountMap.get(ch) >= 0)count++;
            }
            

                while(count == lenT){
                    
                    int len = end - start + 1;
                    if(len <= minLen){
                        minLen = len;
                        result = s.substring(start,end + 1);
                    }
                   
                    char firstChar = s.charAt(start);
                    if(charCountMap.containsKey(firstChar)){
                        charCountMap.put(firstChar, charCountMap.get(firstChar) + 1);
                        if(charCountMap.get(firstChar) >= 1)count--;
                    }
                    start++;
                }
               
           
            end++;
        }
        
        return result;
    }
}