// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.isGoodorBad(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int isGoodorBad(String S) {
        // code here
        int countVowels = 0;
        int countConsonants = 0;
        
        int minVowels = 5;
        int minConsonants = 3;
        
        int len = S.length();
        
        for(int i = 0;i < len;i++){
            char ch = S.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                countVowels++;
                countConsonants = 0;
            }else if(ch == '?'){
                countVowels++;
                countConsonants++;
            }else{
                countConsonants++;
                countVowels = 0;
            }
            
            if(countVowels > minVowels || countConsonants > minConsonants)return 0;
        }
        
        return 1;
    }
};