class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
		int len = s.length();
		for(int i = 0;i < len;i++){
		    int ch = s.charAt(i) - 'a';
		    count[ch]++;
		}
		
		PriorityQueue<CharFreq> maxHeap = new PriorityQueue<>(new CharFreq());
		for(int i = 0;i < 26;i++){
		    if(count[i] > 0)
		    {
		        CharFreq charFreq = new CharFreq((char)(i + 97),count[i]);
		        maxHeap.offer(charFreq);
		    }
		}
		
        CharFreq prev = new CharFreq('#',-1);
		String result = "";
		while(!maxHeap.isEmpty()){
		    CharFreq charFreq = maxHeap.poll();
            charFreq.freq--;
            if(prev.freq > 0){ 
                maxHeap.offer(prev);
            }
            prev = charFreq;
		    result += charFreq.ch;
		}
		
		return result.length() == len ? result : "";
    }
}
class CharFreq implements Comparator<CharFreq>{
    
    char ch;
    int freq;
    
    CharFreq(){};
    
    CharFreq(char _ch, int _freq){
        ch = _ch;
        freq = _freq;
    }
    
    @Override
    public int compare(CharFreq a, CharFreq b){
        return b.freq - a.freq;
    }
}