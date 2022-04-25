// { Driver Code Starts
//Initial Template for Java

import java.util.*;
class KthSmallestElement{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.next());
		while(t>0)
		{
			int n=Integer.parseInt(sc.next());
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
    				a[i][j]=Integer.parseInt(sc.next());
    		
			int k=Integer.parseInt(sc.next());
		    Solution ob = new Solution();
		    System.out.println(ob.kthSmallest(a,n,k));
		    
		    t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Element implements Comparator<Element>{
    
    int val;
    int row;
    int col;
    
    Element(){};
    
    Element(int _val, int _row, int _col){
        val = _val;
        row = _row;
        col = _col;
    }
    
    @Override
    public int compare(Element a, Element b){
        return a.val - b.val;
    }
    
}
class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        //code here.
        PriorityQueue<Element> minHeap = new PriorityQueue<>(new Element());
        int val = -1;
        int count = 1;
        
        for(int i = 0;i < n;i++){
            minHeap.offer(new Element(mat[i][0], i, 0));
        }
        
        for(int i = 1;i < k;i++){
            Element elem = minHeap.poll();
            if(elem.col + 1 < n)minHeap.offer(new Element(mat[elem.row][elem.col+1], elem.row, elem.col + 1));
        }
        
        return minHeap.poll().val;
        

    }
}
