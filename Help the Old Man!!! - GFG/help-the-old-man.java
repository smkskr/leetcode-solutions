// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int n = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.shiftPile(N, n);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> shiftPile(int N, int n){
        // code here
        List<List<Integer>> transferList = new ArrayList<>();
        transferPlates(N, 1, 3, 2, transferList);
        return transferList.get(n-1);
    }
    
    static void transferPlates(int N, int from, int to, int aux,List<List<Integer>> transferList){
        
        if(N <= 0)return;
        transferPlates(N - 1, from, aux, to, transferList);
        List<Integer> list = new ArrayList<>();
        list.add(from);
        list.add(to);
        transferList.add(list);
        transferPlates(N - 1, aux, to, from, transferList);
    }
}