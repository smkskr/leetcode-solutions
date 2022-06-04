// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        
        // Your code here
        int[] charCountMap = new int[26];
        int lenA = a.length();
        int lenB = b.length();
        if(lenA != lenB)return false;
        
        for(int index = 0;index < lenA;index++){
            int indexA = a.charAt(index) - 'a';
            int indexB = b.charAt(index) - 'a';
            charCountMap[indexA]++;
            charCountMap[indexB]--;
        }
        
        for(int index = 0;index < 26;index++){
            if(charCountMap[index] != 0)return false;
        }
        
        return true;
        
    }
}