class Solution {
    public boolean detectCapitalUse(String word) {
        
        int len = word.length();
        int countCapital = 0;
        boolean firstLetterCapital = false;
        
        for(int i = 0;i < len;i++){
            
            char ch = word.charAt(i);
            
            if(ch >= 65 && ch <= 90){
                if(countCapital == 0 && i == 0) firstLetterCapital = true;
                countCapital++;
            }
            
        }
        
        if(countCapital == len)return true;
        if(countCapital == 0)return true;
        if(countCapital == 1 && firstLetterCapital) return true;
        
        return false;
    }
}