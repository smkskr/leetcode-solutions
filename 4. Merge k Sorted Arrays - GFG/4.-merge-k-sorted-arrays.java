// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class ValIndex{
    int val;
    int index;
    
    ValIndex(int _val, int _index){
        val = _val;
        index = _index;
    }
}
class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        // PriorityQueue<ValIndex> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        //extract first elements of all arrays and insert into min heap
        // for(int i = 0;i < k;i++){
        //     ValIndex valIndex = new ValIndex(arr[i][0], 0);
        //     minHeap.offer(valIndex);
        // }
        
        for(int i = 0; i < K;i++){
            for(int j = 0; j < K;j++){
                minHeap.offer(arr[i][j]);
            }
        }
        
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }
        
        return result;
        
        
    }
}