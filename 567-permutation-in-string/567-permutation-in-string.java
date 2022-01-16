/**
* This problem can be solved by sliding window approach and is similar to the problem
*  
* https://leetcode.com/problems/find-all-anagrams-in-a-string/
*
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] charCountMap = new int[26];//to store count of each letter
        
        //finding the window.Here window is equal to the length of s1, because s2 should contain s1
        int windowSize = s1.length();
        
        int length = s2.length();
        
        for(char ch : s1.toCharArray()){
            charCountMap[ch - 'a']++;
        }
        
        int start = 0;
        int end = 0;
        int count = 0; // this counts helps in matching the total letters of the string s1 and substring in s2
        
        while(end < length){
            
            char ch = s2.charAt(end);
            charCountMap[ch - 'a']--;
            
            if(charCountMap[ch - 'a'] >= 0)count++;
            
            if(end - start + 1 == windowSize){
                
                if(count == windowSize)return true;
                char firstChar = s2.charAt(start);
                charCountMap[firstChar - 'a']++;
                if(charCountMap[firstChar - 'a'] >= 1)count--;
                start++;
            }
            
            end++;
        }
        
        return false;
    }
}