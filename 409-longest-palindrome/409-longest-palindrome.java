class Solution {
    public int longestPalindrome(String s) {
        
        int len = s.length();
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        
        for(int index = 0;index < len;index++){
            
            char ch = s.charAt(index);
            charCountMap.put(ch , charCountMap.getOrDefault(ch, 0) + 1);
            
        }
        
        int maxLen = 0;
        int oddFlag = 0;
        
        for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()){
            
            int value = entry.getValue();
            if(value % 2 == 0)maxLen += value;//if char count is even then add it to the length
            else {
                oddFlag = 1;//this value needs to be added at last
                maxLen += value - 1;// if char count is odd then subtract 1 from the value since palindrome can contain only even values
            }
        }
        // add the oddFlag to the result because if oddFlag is 1 that means there is/are odd values
        // and hence it needs to be added to the string(in the center) to make it a palindrome
        return maxLen + oddFlag;
    }
}