// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here // Code here
        Arrays.sort(Intervals, (a,b) -> a[0] - b[0]);
        ArrayList<int[]> intervalList = new ArrayList<>();
        
        int[] prevInterval = new int[2];
        prevInterval[0] = Intervals[0][0];
        prevInterval[1] = Intervals[0][1];
        
        //interval.add(prevInterval);
        
        for(int index = 1;index < Intervals.length;index++){
            
            if(prevInterval[1] >= Intervals[index][0]){
                prevInterval[1] = Math.max(Intervals[index][1],prevInterval[1]);
            }else{
                int[] currInterval = new int[2];
                currInterval[0] = prevInterval[0];
                currInterval[1] = prevInterval[1];
                intervalList.add(currInterval);
                prevInterval[0] = Intervals[index][0];
                prevInterval[1] = Intervals[index][1];
            }
        }
        
        intervalList.add(prevInterval);
        int[][] result = new int[intervalList.size()][2];
        int index = 0;
        for(int[] interval : intervalList){
            result[index][0] = interval[0];
            result[index][1] = interval[1];
            index++;
        }
        
        return result;
    }
}