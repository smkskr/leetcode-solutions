class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int leftPointer = 0;
        
        int tLength = t.length();
        int sLength = s.length();
        
        if(sLength == 0)return true;
        
        if(tLength == 0){
            return sLength == 0;
        }
        
        for(int index = 0;index < tLength;index++){
            if(s.charAt(leftPointer) == t.charAt(index)){
                leftPointer++;
            }
            if(leftPointer == sLength)return true;
        }
        
        return false;
    }
}