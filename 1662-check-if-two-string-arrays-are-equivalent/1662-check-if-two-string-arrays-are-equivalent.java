class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        int index = 0;
        StringBuilder wordBuilder1 = new StringBuilder();
        StringBuilder wordBuilder2 = new StringBuilder();
        
        while(index < word1.length && index < word2.length){
            wordBuilder1.append(word1[index]);
            wordBuilder2.append(word2[index++]);
        }
              
        while(index < word1.length){
            wordBuilder1.append(word1[index++]);
        }
              
        while(index < word2.length){
            wordBuilder2.append(word2[index++]);
        }
         
        return wordBuilder1.toString().equals(wordBuilder2.toString());
    }
}