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
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int K = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int candies[]= new int[N];
            for(int i = 0; i < N; i++)
                candies[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> cost = ob.candyStore(candies,N,K);
            System.out.println(cost.get(0)+" "+cost.get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(candies);
        result.add(minPrice(candies, 0, N - 1, K));
        result.add(maxPrice(candies, 0, N - 1, K));
        return result;
    }
    
    static int minPrice(int[] candies,int low,int high, int K){
        
        int sum = 0;
        while(low <= high){
            sum += candies[low];
            low++;
            high = high - K;
        }
        return sum;
    }
    
    static int maxPrice(int[] candies,int low,int high, int K){
        
        int sum = 0;
        while(low <= high){
            sum += candies[high];
            high--;
            low = low + K;
        }
        return sum;
    }
}
