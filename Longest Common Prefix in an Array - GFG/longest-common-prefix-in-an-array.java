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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
        String result = "";
        
        for(int index = 0;index < arr[0].length();index++){
            
            char ch = arr[0].charAt(index);
            for(int nextStringIndex = 1;nextStringIndex < arr.length;nextStringIndex++){
                
                try{
                    
                    if(ch != arr[nextStringIndex].charAt(index))return result == "" ? "-1" : result;
                }catch(IndexOutOfBoundsException exception){
                    return result == "" ? "-1" : result;
                }
            }
            
            result += ch;
        }
        
        return result == "" ? "-1" : result;
    }
}