class Solution {
    public char findTheDifference(String s, String t) {
        
        int[] countArr = new int[26];
        int len = s.length();
        
        for(int i = 0;i < len;i++){
            
            countArr[s.charAt(i) - 'a']++;
            countArr[t.charAt(i) - 'a']--;
            
        }
        
        countArr[t.charAt(len) - 'a']--;
        char res = ' ';
        
        for(int i = 0;i < 26;i++){
            if(countArr[i] != 0){
                res = (char)(97 + i);break;
            }
        }
        
        return res;
    }
}