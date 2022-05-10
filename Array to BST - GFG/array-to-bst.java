// { Driver Code Starts
//Initial Template for Java

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
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        int n = nums.length;
        int[] res = new int[n];
        
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for(int i = 0;i < n;i++){
            indexMap.put(i, nums[i]);
        }
        
        int[] index = new int[1];
        solve(nums, res, indexMap, 0, n - 1, index);
        return res;
    }
    
    public void solve(int[] nums, int[] res, HashMap<Integer,Integer> indexMap, int start, int end, int[] index){
        
        if(start > end)return;
        int mid = start + (end - start)/2;
        res[index[0]++] = indexMap.get(mid);
        solve(nums, res, indexMap, start, mid - 1, index);//left
        solve(nums, res, indexMap, mid + 1, end, index);//right
    }
}