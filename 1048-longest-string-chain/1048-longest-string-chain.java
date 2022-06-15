class Solution {
    public int longestStrChain(String[] words) {
        
        int len = words.length;
        int[] cache = new int[len];
        Arrays.fill(cache, 1);
        int maxLen = 1;
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        for(int cacheIndex = 0;cacheIndex < len;cacheIndex++){
            
            for(int wordIndex = 0;wordIndex <= cacheIndex;wordIndex++){
                if(compareString(words[wordIndex], words[cacheIndex])){
                    cache[cacheIndex] = Math.max(cache[cacheIndex],1 + cache[wordIndex]);
                }
            }
            
            maxLen = Math.max(maxLen, cache[cacheIndex]);
        }
     
        return maxLen;
    }
    
    public boolean compareString(String a, String b){
        int smallerStringIndex = 0;
        int largerStringIndex = 0;
            
        if(a.length() + 1 != b.length())return false;
        while(largerStringIndex < b.length()){
            if(smallerStringIndex < a.length() && b.charAt(largerStringIndex) == a.charAt(smallerStringIndex)){
                largerStringIndex++;
                smallerStringIndex++;
            }else{
                largerStringIndex++;
            }
        }
        
        return largerStringIndex == b.length() && smallerStringIndex == a.length();
    }
}