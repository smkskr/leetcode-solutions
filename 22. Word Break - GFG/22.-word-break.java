// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        Set<String> set = new HashSet<>();
        for(String word : B){
            set.add(word);
        }
        if(solve(A, 0,"",set))return 1;
        return 0;
    }
    
    public static boolean solve(String A, int index, String curr, Set<String> set){
        
        if(index == A.length()){
            return curr == "";
        }
        
        curr += A.charAt(index);
        if(set.contains(curr)){
            return solve(A, index + 1, "",set) || solve(A, index + 1, curr, set);
        }
        return solve(A, index + 1, curr, set);
    }
}