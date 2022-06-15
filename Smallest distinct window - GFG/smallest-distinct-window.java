// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        // Your code goes here
        
        HashMap<Character,Integer> countMap = new HashMap<>();
        for(char ch : str.toCharArray()){
            countMap.put(ch,1);
        }
        
        int distinctCharacters = countMap.size();
        int count = 0;
        
        int start = 0;
        int end = 0;
        int length = str.length();
        int minLen = Integer.MAX_VALUE;
        
        while(end < length){
            
            char ch = str.charAt(end);
            countMap.put(ch, countMap.getOrDefault(ch,0) - 1);
            if(countMap.get(ch) >= 0)count++;
            
            while(count == distinctCharacters){
                
                minLen = Math.min(minLen, end - start + 1);
                char firstChar = str.charAt(start);
                countMap.put(firstChar, countMap.get(firstChar) + 1);
                if(countMap.get(firstChar) >= 1)count--;
                start++;
            }
            
            end++;
        }
        
        return minLen;
    }
}