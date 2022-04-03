class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        HashMap<Character, Integer> charRankMap = new HashMap<>();
        
        for(int index = 0;index < order.length();index++){
            charRankMap.put(order.charAt(index), index + 1);
        }
        
        
        
        for(int i = 1;i < words.length;i++){
            
            int len1 = words[i - 1].length();
            int len2 = words[i].length();
            int count = 0;
            
            for(int j = 0; j < Math.min(len1,len2);j++){
                
                char ch1 = words[i - 1].charAt(j);
                char ch2 = words[i].charAt(j);
                
                if(charRankMap.get(ch1) < charRankMap.get(ch2))break;
                else if(charRankMap.get(ch1) == charRankMap.get(ch2)){
                    count++;continue;
                }
                else{
                    return false;
                }
            }
              if(count == len2 && len2 < len1)return false;  
            }
            
            //if(count < len1)return false;
        
        
        return true;
    }
    
}