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
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int N = nums.length;
        int[] copyOfNums = Arrays.copyOfRange(nums, 0, N);
        Arrays.sort(copyOfNums);
        
        HashMap<Integer,Integer> indexNumsMap = new HashMap<>();
        
        for(int index = 0;index < N;index++){
            indexNumsMap.put(nums[index],index);
        }
        
        int count = 0;
        for(int index = 0;index < N;index++){
            
            if(copyOfNums[index] != nums[index]){
                count++;
                //swap
                int initValue = nums[index];
                swap(nums, index, indexNumsMap.get(copyOfNums[index]));
                indexNumsMap.put(initValue,indexNumsMap.get(copyOfNums[index]));
                indexNumsMap.put(copyOfNums[index], index);
            }
        }
        
        return count;
    }
    
    public void swap(int[] nums, int index, int targetIndex){
        
        int cache = nums[index];
        nums[index] = nums[targetIndex];
        nums[targetIndex] = cache;
    }
}