// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            
            for(int i=0; i<N-1; i++)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                String S[] = read.readLine().split(" ");
                temp.add(Integer.parseInt(S[0]));
                temp.add(Integer.parseInt(S[1]));
                arr.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxBinTreeGCD(arr,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int N) {
        // code here
        Collections.sort(arr, (a,b) -> a.get(0) - b.get(0));
        int maxGCD = 0;
        for(int index = 0;index < arr.size() - 1;){
            ArrayList<Integer> first = arr.get(index);
            ArrayList<Integer> second = arr.get(index + 1);
            if(first.get(0) == second.get(0)){
                maxGCD = Math.max(maxGCD, calcGCD(first.get(1), second.get(1)));
                index+=2;
            }else{
                index+=1;
            }
        }
        
        return maxGCD;
    }
    
    static int calcGCD(int numA, int numB){
        
        if(numA == 0)return numB;
        if(numB == 0)return numA;
        
        if(numA == numB)return numA;
        
        if(numA > numB)return calcGCD(numA - numB, numB);
        else return calcGCD(numA, numB - numA);
        
    }
};

