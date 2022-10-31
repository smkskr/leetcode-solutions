class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        StringBuilder parsedStringBuilder = new StringBuilder();
        StringBuilder finalStringBuilder = new StringBuilder();
        
        for(int index = 0;index < s.length();index++){
            if(s.charAt(index) != '-'){
                parsedStringBuilder.append(s.charAt(index));    
            }
        }
        
        String parsedString = parsedStringBuilder.toString();
        if(parsedString.length() == 0)return "";
        int secondGroupStartingIndex = parsedString.length()%k;
        secondGroupStartingIndex = secondGroupStartingIndex == 0 ? secondGroupStartingIndex + k : secondGroupStartingIndex;
        finalStringBuilder.append(parsedString.substring(0,secondGroupStartingIndex));
        
        for(int index = secondGroupStartingIndex;index < parsedString.length();index+=k){
            finalStringBuilder.append("-").append(parsedString.substring(index,index+k));
        }
        
        return finalStringBuilder.toString().toUpperCase();
    }
}