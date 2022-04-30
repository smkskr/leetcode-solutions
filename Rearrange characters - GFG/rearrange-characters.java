// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}// } Driver Code Ends


class CharFreq implements Comparator<CharFreq>{
    
    char ch;
    int freq;
    
    CharFreq(){}
    
    CharFreq(char _ch, int _freq){
        ch = _ch;
        freq = _freq;
    }
    
    @Override
    public int compare(CharFreq a, CharFreq b){
        return b.freq - a.freq;
    }
    
}

class Solution
{
	public static String rearrangeCharacters(String str) {
	
	 int[] count = new int[26];
		int len = str.length();
		for(int i = 0;i < len;i++){
		    int ch = str.charAt(i) - 'a';
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
		
		return result.length() != str.length() ? "-1" : result;
		
	
	}
}