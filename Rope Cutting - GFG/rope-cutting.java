// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java

class Solution{
    
    // Function for finding maximum and value pair
    public static ArrayList<Integer> RopeCutting (int arr[], int n) {
        // Complete the Function
        Arrays.sort(arr);
        int startIndex = 0;
        int len = arr.length;
        
        ArrayList<Integer> result = new ArrayList();
        
        int smallestVal = arr[0];
        
        while(startIndex < len){
            if(arr[startIndex] == smallestVal){
               arr[startIndex++] = 0; 
            }else{
                result.add(len - startIndex);
                smallestVal = arr[startIndex];
            }        
        }
        
        return result;
    }
}



// { Driver Code Starts.
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] =  Integer.parseInt(elements[i]);
		    }
		    
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res;
		    res = obj.RopeCutting(arr, sizeOfArray);
		    for(int i: res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            

  // } Driver Code Ends