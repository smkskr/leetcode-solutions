// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int fun(String s)
    {
        // Write your code here
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int modValue = 1000000007;
        
        for(int index = 0;index < s.length();index++){
            
            char ch = s.charAt(index);
            
            if(ch == 'a'){
                aCount = (2*aCount%modValue + 1)%modValue;
            }
            else if(ch == 'b'){
                bCount = (2*bCount%modValue + aCount)%modValue;
            }
            else if(ch == 'c'){
                cCount = (2*cCount%modValue + bCount)%modValue;
            }
            
        }
        return cCount%modValue;
    }
}