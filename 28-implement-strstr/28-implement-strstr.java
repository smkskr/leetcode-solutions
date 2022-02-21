//This problem can be solved by using sliding window approach
class Solution {
    public int strStr(String haystack, String needle) {
        
        int windowSize = needle.length();
        int start = 0;
        int end = 0;
        int length = haystack.length();
        if(windowSize == 0){
            return 0;
        }
        String curr ="";
        while(end < length){
            
            
            curr = haystack.substring(start,end + 1);
            if(end - start + 1 == windowSize){
                
                if(needle.equals(curr))return start;
                curr = haystack.substring(start++,end + 1);
            }
            
            end++;
        }
        
        
        return -1;
    }
}