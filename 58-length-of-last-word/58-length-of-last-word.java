class Solution {
    public int lengthOfLastWord(String s) {
        
        int len = s.length();
        String lastWord = "";
        
        for(int i = len - 1;i >= 0;i--){
            char ch = s.charAt(i);
            if(ch == ' '){
                if(lastWord.length() != 0){
                    break;
                }
            }else{
                lastWord += ch;
            }
        }
        
        return lastWord.length();
    }
}