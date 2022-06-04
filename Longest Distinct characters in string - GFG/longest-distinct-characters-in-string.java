// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        int start = 0;
        int end = 0;
        int len = S.length();
        int maxLen = 0;
        HashMap<Character,Integer> countMap = new HashMap<>();
        
        while(end < len){
            
            char ch = S.charAt(end);
            countMap.put(ch, countMap.getOrDefault(ch,0) + 1);
            while(countMap.get(ch) > 1){
                char targetChar = S.charAt(start++);
                countMap.put(targetChar,countMap.get(targetChar) - 1);
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        
        return maxLen;
    }
}