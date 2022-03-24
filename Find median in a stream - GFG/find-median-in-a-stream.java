// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}

// } Driver Code Ends


class Solution
{   
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        // add your code here
        if(maxHeap.isEmpty() || x < maxHeap.peek())maxHeap.offer(x);
        else{
            minHeap.offer(x);
        }
        
        if(maxHeap.size() - minHeap.size() == 2){
            balanceHeaps(maxHeap, minHeap);
        }else if(minHeap.size() - maxHeap.size() == 2){
             balanceHeaps(minHeap, maxHeap);
        }
    }
    
    //Function to balance heaps.
    public static void balanceHeaps(PriorityQueue<Integer> largerHeap, PriorityQueue<Integer> smallerHeap)
    {
       // add your code here
       int element = largerHeap.poll();
       smallerHeap.offer(element);
       
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        int size = maxHeap.size() + minHeap.size();
        if(size % 2 == 0){
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        }else{
            if(maxHeap.size() > minHeap.size()){
                return maxHeap.peek();
            }else{
                return minHeap.peek();
            }
        }
    }
    
}