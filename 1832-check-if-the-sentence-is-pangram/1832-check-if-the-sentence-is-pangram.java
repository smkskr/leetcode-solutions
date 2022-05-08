class Solution {
    public boolean checkIfPangram(String sentence) {
        
        int[] countChar = new int[26];
        
        for(int i = 0;i < sentence.length();i++){
            int charIndex = sentence.charAt(i) - 'a';
            countChar[charIndex]++;
        }
        
        for(int i = 0;i < 26;i++){
            if(countChar[i] == 0)return false;
        }
        
        return true;
    }
}