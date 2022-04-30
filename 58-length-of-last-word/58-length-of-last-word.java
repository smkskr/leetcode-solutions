class Solution {
    public int lengthOfLastWord(String s) {
        
        int len = s.length();
        int countLetter = 0;
        
        //Since we are looking for the last word ; run a reverse loop
        for(int i = len - 1;i >= 0;i--){
            char ch = s.charAt(i);
            
            //if the character is a space then check whether there is any letter present or not, if present then break the loop
            //if the character is not a space then increment the letter count
            if(ch == ' '){
               if(countLetter > 0)break;
            }else{
               countLetter++;
            }
        }
        
        return countLetter;
    }
}