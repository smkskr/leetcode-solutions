class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        HashMap<Character,String> charStringMap = new HashMap<>();
        List<String> words = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        
        int len = s.length();
        
        String curr = "";
        for(int i = 0;i < len;i++){
            char ch = s.charAt(i);
            if(ch != ' '){
                curr += ch;
            }else{
                words.add(curr);
                curr = "";
            }
        }
        
        words.add(curr);
        if(words.size() != pattern.length())return false;
       
        int index = 0;
        for(String word : words){
            char ch = pattern.charAt(index);
           
            if(charStringMap.containsKey(ch)){
                if(!charStringMap.get(ch).equals(word))return false;
            }else{
                if(set.contains(word))return false;
                set.add(word);
                charStringMap.put(ch, word);
            }
            index++;
        }
        
        return true;
    }
}