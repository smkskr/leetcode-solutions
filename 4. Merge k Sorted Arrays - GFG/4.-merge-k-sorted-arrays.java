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
    int row;
    int col;
    
    ValIndex(int _val, int _row, int _col){
        val = _val;
        row = _row;
        col = _col;
    }
}
class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        PriorityQueue<ValIndex> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));
       
        //extract first elements of all arrays and insert into min heap
        for(int i = 0;i < K;i++){
            ValIndex valIndex = new ValIndex(arr[i][0], i, 0);
            minHeap.offer(valIndex);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!minHeap.isEmpty()){
            ValIndex valIndex = minHeap.poll();
            result.add(valIndex.val);
            int row = valIndex.row;
            int col = valIndex.col;
            if(col + 1 < K)
            minHeap.offer(new ValIndex(arr[row][col+1], row, col+1));
        }
        
        return result;
        
        
    }
}