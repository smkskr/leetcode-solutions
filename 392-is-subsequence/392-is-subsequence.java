class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int lenS = s.length();
        int lenT = t.length();
        
        if(lenS == 0)return true;
        if(lenT == 0)return lenS == 0;
        if(lenS > lenT)return false;
        int indexS = 0;
        for(int index = 0;index < lenT;index++){
            char charT = t.charAt(index);
            if(charT == s.charAt(indexS)){
                indexS++;
                if(indexS == lenS)return true;
            }
        }
        
        return false;
    }
}