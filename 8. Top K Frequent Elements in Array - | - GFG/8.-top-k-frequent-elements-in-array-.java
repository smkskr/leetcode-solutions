// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Pair implements Comparator<Pair>{
    int val;
    int freq;
    
    Pair(){};
    
    @Override
    public int compare(Pair a, Pair b){
        if(a.freq == b.freq){
            return b.val - a.val;
        }
        return b.freq - a.freq;
    }
}
class Solution {
    public int[] topK(int[] nums, int k) {
        // Code here
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Pair());
        HashMap<Integer,Integer> countMap = new HashMap<>();
        
        for(int num : nums){
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }
        
        for(Integer key : countMap.keySet()){
            Pair pair = new Pair();
            pair.val = key;
            pair.freq = countMap.get(key);
            maxHeap.offer(pair);
        }
        
        int[] result = new int[k];
        int index = 0;
        while(index < k){
            result[index++] = maxHeap.poll().val;
        }
        
        return result;
    }
}