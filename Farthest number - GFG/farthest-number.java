// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
        	int N = Integer.parseInt(br.readLine()); 
        	int[] Arr = new int[N];
        	String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
        	for(int i=0; i<N; i++)
        	{
        		Arr[i] = Integer.parseInt(strs[i]); 
        	}
        	

            Solution ob = new Solution();
			int[] ans = ob.farNumber(N,Arr);
  
            for(int i=0; i<ans.length; i++)
                out.print(ans[i] + " ");
            out.println();

            t--;
        }
        out.flush();
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int[] farNumber(int N, int Arr[])
	{    
	   
	   int[] suffixMinArray = new int[N];//array to store smallest right element
	   suffixMinArray[N - 1] = Arr[N - 1];
	   for(int index = N - 2;index >= 0;index--){
	       suffixMinArray[index] = Math.min(suffixMinArray[index + 1], Arr[index]);
	   }
	    
	   //perform binary search
	   return binarySearch(N, Arr, suffixMinArray);
	   //return bruteForce(N, Arr);
        
	}
	
	
	//binary search to find the farthest smallest element
	static int[] binarySearch(int N, int[] Arr, int[] suffixMinArray){
	    
	    int[] result = new int[N];
	    result[N - 1] = -1;
	    for(int index = 0;index < N - 1;index++){
	        int left = index + 1;
	        int right = N - 1;
	        int ans = -1;
	        while(left <= right){
	            int mid = left + (right - left)/2;
	            if(Arr[index] > suffixMinArray[mid]){
	                ans = mid;
	                left = mid + 1;
	            }else{
	                right = mid - 1;
	            }
	        }
	        
	        result[index] = ans;
	    }
	    
	    return result;
	}
	//brute force
	static int[] bruteForce(int N, int[] Arr){
	    
	    int[] result = new int[N];
	    Arrays.fill(result, -1);
	    
	    for(int index = 0;index < N - 1;index++){
	        for(int secondaryIndex = index + 1;secondaryIndex < N;secondaryIndex++){
	            if(Arr[index] > Arr[secondaryIndex]){
	                result[index] = secondaryIndex;
	            }
	        }
	    }
	    
	    return result;
	}
} 